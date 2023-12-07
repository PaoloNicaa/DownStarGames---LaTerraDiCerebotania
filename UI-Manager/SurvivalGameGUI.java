import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SurvivalGameGUI extends JFrame implements ActionListener, KeyListener {
    private JLayeredPane layeredPane;
    private JLabel backgroundLabel;
    private JPanel playerPanel;
    private JLabel playerLabel;
    private int playerX, playerY;

    public SurvivalGameGUI() {
        setTitle("Survival Game");
        setSize(1920, 1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setUndecorated(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Caricamento immagine sfondo
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("background.png"));
        backgroundLabel = new JLabel(backgroundIcon);
        backgroundLabel.setSize(getWidth(), getHeight());

        // Creazione pannello layered
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(new Dimension(getWidth(), getHeight()));

        // Aggiunta sfondo al livello 0
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        // Creazione giocatore
        ImageIcon playerIcon = new ImageIcon(getClass().getResource("image.png"));
        playerLabel = new JLabel(playerIcon);

        // Creazione pannello giocatore con layout manager FlowLayout
        playerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        playerPanel.setSize(playerIcon.getIconWidth(), playerIcon.getIconHeight());
        playerPanel.setOpaque(false); // Trasparenza per vedere lo sfondo
        playerPanel.add(playerLabel);

        // Posiziona giocatore al livello 1
        layeredPane.add(playerPanel, JLayeredPane.PALETTE_LAYER);

        add(layeredPane);

        addKeyListener(this);
        setFocusable(true);

        Timer timer = new Timer(16, this);
        timer.start();
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
            playerY -= 10; //Valore da cambiare in relazine al peso dopo la creazione di tale funzione
        } else if (key == KeyEvent.VK_A) {
            playerX -= 10;
        } else if (key == KeyEvent.VK_S) {
            playerY += 10;
        } else if (key == KeyEvent.VK_D) {
            playerX += 10;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SurvivalGameGUI game = new SurvivalGameGUI();
            game.setVisible(true);
        });
    }
}
