import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

import utils.Player;
import utils.PopUp;
import Item.Mela;
import Item.Stivali;
import Item.Spada;
import Item.Coppa;
import Item.Item;
import Item.Anello;

public class SurvivalGameGUI extends JFrame implements ActionListener, KeyListener {
    private JLayeredPane layeredPane;
    private JLabel backgroundLabel;
    private JPanel playerPanel;
    private JLabel playerLabel;
    private JLabel testoLabel;
    private ImageIcon playerIcon;
    private JPanel[] itemPanel = new JPanel[15];
    private int playerX;
    private int playerY;
    private List<Item> itemLista;
    private int mela,stivali,spada,coppa,anello;
    Player player;

    public String getText() {
        return "<html><div style='text-align: center;'>W A S D per muoversi | ESC per uscire | E per raccogliere oggetti | I per aprire inventario<br><br>Mosse Rimanenti: " + player.getStepRimanenti() + "</div></html>";
    }

    public void aggText() {
        testoLabel.setText(getText());
    }

    public SurvivalGameGUI() {
        setTitle("Survival Game");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //Funzione per ottenere risoluzione dello schermo
        setSize((int)size.getWidth(), (int)size.getHeight());
        setResizable(false);
        setExtendedState(JFrame.MAXIMIZED_BOTH); //Frame a schermo intero
        setUndecorated(true); //True per togliere la barra sopra del frame - False per metterla
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // --------- Caricamento immagine sfondo ---------
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/images/background.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setSize(getSize());

        // --------- Creazione pannello layered ---------
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // --------- Creazione giocatore ---------
        playerIcon = new ImageIcon(getClass().getResource("/images/playerIdle.gif"));
        playerLabel = new JLabel(playerIcon);
        playerX = 920; // Coordinate per farlo spawnare al centro
        playerY = 300;
        playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        playerPanel.setSize(playerIcon.getIconWidth(), playerIcon.getIconHeight());
        playerPanel.setOpaque(false); // Trasparenza per vedere lo sfondo
        playerPanel.add(playerLabel);
        playerPanel.setBounds(playerX, playerY, playerIcon.getIconWidth(), playerIcon.getIconHeight());
        player = new Player(playerX, playerY);

        // Dichiarazione componenti per spawn edgli oggetti
        Random random = new Random();
        ImageIcon[] itemIcon = new ImageIcon[15];
        JLabel[] itemLabel = new JLabel[15];
        
        itemLista = new ArrayList<>();
        // Ciclo for per spawn random degli oggetti
        for (int i = 0; i < 15; i++) {
            int rnd = random.nextInt(5);
            if(rnd == 0)
            {
                Mela mela = new Mela();
                mela.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("/images/mela.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, mela, i);
                itemLista.add(mela);
                
                System.out.println("mela: " + mela.getItemX() + " " + mela.getItemY()); // Controllo in console cosa ritorna
            }
            else if(rnd == 1)
            {
                Stivali stivali = new Stivali();
                stivali.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("/images/stivali.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, stivali, i);
                itemLista.add(stivali);

                System.out.println("stivali: " + stivali.getItemX() + " " + stivali.getItemY()); // Controllo in console cosa ritorna
            }
            else if(rnd == 2)
            {
                Spada spada = new Spada();
                spada.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("/images/spada.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, spada, i);
                itemLista.add(spada);

                System.out.println("spada: " + spada.getItemX() + " " + spada.getItemY()); // Controllo in console cosa ritorna
            }
            else if(rnd == 3)
            {
                Coppa coppa = new Coppa();
                coppa.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("/images/coppa.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, coppa, i);
                itemLista.add(coppa);

                System.out.println("coppa: " + coppa.getItemX() + " " + coppa.getItemY()); // Controllo in console cosa ritorna
            }
            else if(rnd == 4)
            {
                Anello anello = new Anello();
                anello.spawnItem();
                itemIcon[i] = new ImageIcon(getClass().getResource("/images/anello.png"));
                player.spawnOgg(itemIcon, itemLabel, itemPanel, layeredPane, anello, i);
                itemLista.add(anello);

                System.out.println("anello: " + anello.getItemX() + " " + anello.getItemY()); // Controllo in console cosa ritorna
            }
        }

        // --------- Creazione JLabel per il testo ---------
        testoLabel = new JLabel(getText());
        testoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        testoLabel.setForeground(Color.WHITE); // Colore del testo
        testoLabel.setHorizontalAlignment(JLabel.CENTER);
        testoLabel.setVerticalAlignment(JLabel.TOP);
        testoLabel.setBounds(0, 20, getWidth(), getHeight()); // Imposta dimensioni e posizione al centro

        // Aggiunta componenti al layeredPane
        layeredPane.add(playerPanel, JLayeredPane.MODAL_LAYER);
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
                    playerIcon = new ImageIcon(getClass().getResource("/images/playerIdle.gif"));
                    playerLabel.setIcon(playerIcon);
                }
            }
        });
    }

    public void GruppoMove() {
        if(player.canMove())
        {
            player.movimento();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "              Game Over!\n  Valore Oggetti totalizzato: " + player.getValoreOgg(),"____________________________________________", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent e) {
        playerX = Math.max(0, Math.min(getWidth() - playerIcon.getIconWidth(), playerX)); // Bordi per player
        playerY = Math.max(0, Math.min(getHeight() - playerIcon.getIconHeight(), playerY)); // Per bordo inferiore
        playerPanel.setBounds(playerX, playerY, playerPanel.getWidth(), playerPanel.getHeight());
        revalidate();
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W)
        {
            playerIcon = new ImageIcon(getClass().getResource("/images/playerRun.gif"));
            GruppoMove();
            aggText();
            playerY -= 20;
            player.setY(playerY);
            playerLabel.setIcon(playerIcon);
        }
        else if (key == KeyEvent.VK_A)
        {
            playerIcon = new ImageIcon(getClass().getResource("/images/playerRunSx.gif"));
            GruppoMove();
            aggText();
            playerX -= 20;
            player.setX(playerX);
            playerLabel.setIcon(playerIcon);
        }
        else if (key == KeyEvent.VK_S)
        {
            playerIcon = new ImageIcon(getClass().getResource("/images/playerRun.gif"));
            GruppoMove();
            aggText();
            playerY += 20;
            player.setY(playerY);
            playerLabel.setIcon(playerIcon);
        }
        else if (key == KeyEvent.VK_D)
        {
            playerIcon = new ImageIcon(getClass().getResource("/images/playerRun.gif"));
            GruppoMove();
            aggText();
            playerX += 20;
            player.setX(playerX); 
            playerLabel.setIcon(playerIcon);
        }
        else if (key == KeyEvent.VK_E)
        {
            Item closestItem = player.findClosestItem(itemLista); // Distanza molto aumentata per via di bug coordinate
            System.out.println("Closest Item: " + closestItem + ", x e y del player: " + player.getX() + " " + player.getY() + "\n"); // Controllo in console cosa ritorna
            if (closestItem != null) {  // Controlla se ci sono oggetti vicini
                if (player.collectItem(closestItem) == true) {  // Controlla se ci sta nello zaino                    
                    if (closestItem instanceof Mela) {
                        mela++;
                    }
                    else if (closestItem instanceof Stivali) {
                        stivali++;
                        player.setStepRimanenti((player.getStepRimanenti()+10));
                    }
                    else if (closestItem instanceof Spada) {
                        spada++;
                    }
                    else if (closestItem instanceof Coppa) {
                        coppa++;
                    }
                    else if (closestItem instanceof Anello) {
                        anello++;
                    }
                    testoLabel.setText("<html><div style='text-align: center;'>" + "L'oggetto " + closestItem.getName() + " e' stato aggiunto all'inventario!");
                    if (itemLista.indexOf(closestItem) != -1) { // Controllo per evitare che elimini il player o lo sfondo
                        player.removeItem(itemPanel, layeredPane, closestItem.getItemX(), closestItem.getItemY());
                    }
                    itemLista.remove(closestItem);
                }
                else {
                    testoLabel.setText("<html><div style='text-align: center;'>" + "L'oggetto " + closestItem.getName() + " non può essere aggiunto allo zaino perché supera il peso massimo");
                    getText();
                }
                
            }
            else { 
                testoLabel.setText("<html><div style='text-align: center;'>" + "Non ci sono oggetti vicini");
            }

        }
        else if (key == KeyEvent.VK_I)
        {
            InventarioGUI invGUI = new InventarioGUI(mela, stivali, spada, coppa, anello);
            invGUI.setVisible(true);
        }
        else if (key == KeyEvent.VK_ESCAPE)
        {
            System.exit(0); // Uscito dal programma
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // InvokeLater serve per gli aggiornamenti alla gui costanti
            SurvivalGameGUI game = new SurvivalGameGUI();
            ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("/images/icon.png"));
            Image image = iconaFrame.getImage();
            game.setIconImage(image);
            game.setVisible(true);

            Random random = new Random();
            int popup = random.nextInt(5); // 1 possibilita su 5 per far partire la pubblicita di grubhub
            if (popup == 1) {
                new PopUp();
            }
        });
    }
}
