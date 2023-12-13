package UIManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PlayerNameGUI extends JFrame implements KeyListener, ActionListener {
    private JLayeredPane layeredPane;
    private String playerName = null;

    public PlayerNameGUI() {
        setTitle("Inserisci nome");
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Per togliere la barra sopra bianca
        setBackground(new Color(0,0,0,0)); // Sfondo gui trasparente
        setLocationRelativeTo(null); // Per farlo apparire al centro
        setResizable(false);
        setVisible(true);
        addKeyListener(this);
        setFocusable(true);

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/UIManager/images/playerNameGUI.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setSize(getSize());

        layeredPane = new JLayeredPane();

        JLabel playerNameLabel = new JLabel("<html><div>Tanto tempo fa, ci fu un cavaliere di nome<br>Egli aveva la missione di dover raccogliere piu' oggetti di valore che poteva per riportarli al re, ma le sue gambe avevano un problema, dopo 50 passi smettevano di funzionare per il resto della giornata per cui doveva pensare a ogni sua mossa con cura.</div></html>");
        playerNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        playerNameLabel.setForeground(new Color(0,0,0,255));
        playerNameLabel.setBounds(100, 0, 300, 500);
        layeredPane.add(playerNameLabel, JLayeredPane.PALETTE_LAYER);

        JTextField playerNameField = new JTextField();
        playerNameField.setBounds(175, 142, 200, 23);
        playerNameField.setFont(new Font("Arial", Font.PLAIN, 20));
        playerNameLabel.setForeground(new Color(0,0,0,255));
        playerNameField.setBorder(null);
        playerNameField.setBackground(new Color(231,213,179,255));
        layeredPane.add(playerNameField, JLayeredPane.PALETTE_LAYER);
        playerNameField.requestFocusInWindow();

        ImageIcon IconCross = new ImageIcon(getClass().getResource("/UIManager/images/X.png"));
        IconCross = new ImageIcon(IconCross.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel LabelCross = new JLabel(IconCross);
        int crossX = 910;
        int crossY = 25;
        JPanel PanelCross = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelCross.setSize(IconCross.getIconWidth(), IconCross.getIconHeight());
        PanelCross.setOpaque(false);
        PanelCross.add(LabelCross);
        PanelCross.setBounds(crossX, crossY, 64,64);
        PanelCross.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        ImageIcon IconButton = new ImageIcon(getClass().getResource("/UIManager/images/buttonStart.png"));
        IconButton = new ImageIcon(IconButton.getImage().getScaledInstance(128, 64, Image.SCALE_SMOOTH));
        JLabel LabelButton = new JLabel(IconButton);
        int buttonX = 200;
        int buttonY = 500;
        JPanel PanelButton = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelButton.setSize(IconButton.getIconWidth(), IconButton.getIconHeight());
        PanelButton.setOpaque(false);
        PanelButton.add(LabelButton);
        PanelButton.setBounds(buttonX, buttonY, 128,64);
        PanelButton.addMouseListener(new MouseAdapter() {
            
            public void mouseClicked(MouseEvent e) {
                if (!playerNameField.getText().isEmpty()) {
                    playerName = playerNameField.getText();
                    SurvivalGameGUI game = new SurvivalGameGUI(playerName);
                    game.setVisible(true);
                    ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("/UIManager/images/icon.png"));
                    Image image = iconaFrame.getImage();
                    game.setIconImage(image);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Inserisci un nome");
                }
            }

            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        
        layeredPane.setPreferredSize(getSize());
        layeredPane.add(PanelCross, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
        add(layeredPane);

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE)
        {
            System.exit(0); // Uscito dal programma
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
