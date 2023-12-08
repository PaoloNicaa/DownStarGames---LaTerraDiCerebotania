import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import utils.Player;
import Item.Item;

public class SurvivalGameGUI extends JFrame implements ActionListener, KeyListener {
    private JLayeredPane layeredPane;
    private JLabel backgroundLabel;
    private JPanel playerPanel;
    private JLabel playerLabel;
    private JLabel testoLabel;
    private int playerX, playerY;
    Player player = new Player();
    Item item;

    //Testo con formattazzione html cosi è bello
    private String getText() {
        return "<html><div style='text-align: center;'>- W A S D per muoversi<br>- ESC per uscire<br>- E per raccogliere oggetti<br><br>Mosse Rimanenti: " + player.getStepRimanenti() + "</div></html>";
    }
    //Funzione per aggiornare il counter dei passi rimanenti nel testo
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
        ImageIcon playerIcon = new ImageIcon(getClass().getResource("image.png"));
        playerLabel = new JLabel(playerIcon);
        //Coordinate per giocatore al centro
        playerX = (getWidth() - playerIcon.getIconWidth()) / 2;
        playerY = (getHeight() - playerIcon.getIconHeight()) / 2;

        /*ImageIcon mela = new ImageIcon(getClass().getResource("mela.png"));
        JLabel melaLabel = new JLabel(mela);
        melaLabel.setBounds(1000, 1000, mela.getIconWidth(), mela.getIconHeight());
        layeredPane.add(melaLabel, JLayeredPane.PALETTE_LAYER);*/


        // Creazione pannello giocatore con layout manager FlowLayout
        playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        playerPanel.setSize(playerIcon.getIconWidth(), playerIcon.getIconHeight());
        playerPanel.setOpaque(false); // Trasparenza per vedere lo sfondo
        playerPanel.add(playerLabel);

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
    }

    public void GruppoMove() {
        if(player.canMove()) {
            player.movimento();
        }
        else {
            JOptionPane.showMessageDialog(null, "              Game Over!\n  Valore Oggetti totalizzato: " + player.getValoreOgg(),"━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }

    public void actionPerformed(ActionEvent e) {
        // Aggiorna la posizione del giocatore
        playerPanel.setBounds(playerX, playerY, playerPanel.getWidth(), playerPanel.getHeight());
        revalidate();
        repaint();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            GruppoMove();
            aggText();
            playerY -= 20; //Valore da cambiare in relazine al peso dopo la creazione di tale funzione
        } else if (key == KeyEvent.VK_A) {
            GruppoMove();
            aggText();
            playerX -= 20;
        } else if (key == KeyEvent.VK_S) {
            GruppoMove();
            aggText();
            playerY += 20;
        } else if (key == KeyEvent.VK_D) {
            GruppoMove();
            aggText();
            playerX += 20;
        } else if (key == KeyEvent.VK_E) {
            player.collectItem(null); //Trovare un modo per sapere l'item che voglio raccogliere
        } else if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SurvivalGameGUI game = new SurvivalGameGUI();
            ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("icon.png"));
            Image image = iconaFrame.getImage();

            game.setIconImage(image);
            game.setVisible(true);
        });
    }
}
