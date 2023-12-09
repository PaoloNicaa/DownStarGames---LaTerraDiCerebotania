import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import utils.Player;
import Item.Mela;
import Item.Stivali;
import Item.Spada;
import Item.Coppa;
import Item.Anello;

public class SurvivalGameGUI extends JFrame implements ActionListener, KeyListener {
    private JLayeredPane layeredPane;
    private JLabel backgroundLabel;
    private JPanel playerPanel;
    private JLabel playerLabel;
    private JLabel testoLabel;
    private ImageIcon playerIcon;
    private int playerX, playerY;
    Player player = new Player();

    // Testo con formattazzione html cosi è bello
    private String getText() {
        return "<html><div style='text-align: center;'>- W A S D per muoversi<br>- ESC per uscire<br>- E per raccogliere oggetti<br><br>Mosse Rimanenti: " + player.getStepRimanenti() + "</div></html>";
    }
    // Funzione per aggiornare il counter dei passi rimanenti nel testo
    private void aggText() {
        testoLabel.setText(getText());
    }

    public SurvivalGameGUI() {
        setTitle("Survival Game");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //Funzione per ottenere risoluzione dello schermo
        setSize((int)size.getWidth(), (int)size.getHeight());
        setExtendedState(JFrame.MAXIMIZED_BOTH); //Frame a schermo intero
        setUndecorated(true); //True per togliere la barra sopra del frame - False per metterla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Caricamento immagine sfondo
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("background.png"));
        backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setSize(getSize());

        // Creazione pannello layered
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());

        // Aggiunta sfondo al livello 0
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Creazione giocatore
        playerIcon = new ImageIcon(getClass().getResource("playerIdle.gif"));
        playerLabel = new JLabel(playerIcon);
        //Coordinate per giocatore al centro
        playerX = (getWidth() - playerIcon.getIconWidth()) / 2;
        playerY = (getHeight() - playerIcon.getIconHeight()) / 2;

        // Creazione pannello giocatore con layout manager FlowLayout
        playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        playerPanel.setSize(playerIcon.getIconWidth(), playerIcon.getIconHeight());
        playerPanel.setOpaque(false); // Trasparenza per vedere lo sfondo
        playerPanel.add(playerLabel);

        // Dichiarazione componenti per spawn edgli oggetti
        Random random = new Random();
        ImageIcon[] itemIcon = new ImageIcon[15];
        JLabel[] itemLabel = new JLabel[15];
        JPanel[] itemPanel = new JPanel[15];

        // Ciclo for per spawn random degli oggetti
        for (int i = 0; i < 15; i++) {
            int rnd = random.nextInt(0,5);
            if(rnd == 0) {
                Mela mela = new Mela();
                mela.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("mela.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, mela, i);
            }
            else if(rnd == 1) {
                Stivali stivali = new Stivali();
                stivali.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("stivali.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, stivali, i);
            }
            else if(rnd == 2) {
                Spada spada = new Spada();
                spada.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("spada.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, spada, i);
            }
            else if(rnd == 3) {
                Coppa coppa = new Coppa();
                coppa.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("coppa.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, coppa, i);
            }
            else if(rnd == 4) {
                Anello anello = new Anello();
                anello.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("anello.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, anello, i);
            }
        }

        // Creazione JLabel per il testo
        testoLabel = new JLabel(getText());
        testoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        testoLabel.setForeground(Color.WHITE); // Colore del testo
        testoLabel.setHorizontalAlignment(JLabel.CENTER);
        testoLabel.setVerticalAlignment(JLabel.TOP);
        testoLabel.setBounds(0, 20, getWidth(), getHeight()); // Imposta dimensioni e posizione al centro


        // Posiziona giocatore al livello 1
        playerPanel.setBounds(playerX, playerY, playerIcon.getIconWidth(), playerIcon.getIconHeight());
        layeredPane.add(playerPanel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(testoLabel, JLayeredPane.MODAL_LAYER);

        add(layeredPane);

        addKeyListener(this);
        setFocusable(true);

        Timer timer = new Timer(16, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();
                if ((key == KeyEvent.VK_W) || (key == KeyEvent.VK_A) || (key == KeyEvent.VK_S) || (key == KeyEvent.VK_D)) {
                    playerIcon = new ImageIcon(getClass().getResource("playerIdle.gif"));
                    playerLabel.setIcon(playerIcon);
                }
            }
        });
    }

    public void GruppoMove(char op, char xy) {
        playerIcon = new ImageIcon(getClass().getResource("playerRun.gif"));
        if(player.canMove()) {
            player.movimento();
            aggText();
            if (op == '-' && xy == 'X') {
                playerX -= 20;
            }
            else if (op == '-' && xy == 'Y') {
                playerY += 20;
            }
            else if (op == '+' && xy == 'X') {
                playerX += 20;
            }
            else if (op == '+' && xy == 'Y') {
                playerY -= 20;
            }
            playerLabel.setIcon(playerIcon);
        }
        else {
            JOptionPane.showMessageDialog(null, "              Game Over!\n  Valore Oggetti totalizzato: " + player.getValoreOgg(),"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Aggiorna la posizione del giocatore
        playerPanel.setBounds(playerX, (playerY-200), playerPanel.getWidth(), playerPanel.getHeight());
        revalidate();
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            GruppoMove('+','Y');
        } else if (key == KeyEvent.VK_A) {
            GruppoMove('-', 'X');
        } else if (key == KeyEvent.VK_S) {
            GruppoMove('-', 'Y');
        } else if (key == KeyEvent.VK_D) {
            GruppoMove('+', 'X');
        } else if (key == KeyEvent.VK_E) {
            player.collectItem(null); // Trovare un modo per sapere l'item che voglio raccogliere
        } else if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // InvokeLater serve per gli aggiornamenti alla gui costanti
            SurvivalGameGUI game = new SurvivalGameGUI();
            ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("icon.png"));
            Image image = iconaFrame.getImage();

            game.setIconImage(image);
            game.setVisible(true);
            
        });
    }
}
