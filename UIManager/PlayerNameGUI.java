package UIManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import UIManager.audio.AudioLoop;

public class PlayerNameGUI extends JFrame implements KeyListener, ActionListener {
    private JLayeredPane layeredPane;
    private String playerName = null;
    private boolean ctrlName = false;
    private JPanel PanelON;
    private JPanel PanelOFF;
    private JTextField playerNameField;
    private JTextField stepField;
    private JTextField itemField;
    private SurvivalGameGUI game;

    public PlayerNameGUI() {
        setTitle("Survival Game");
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

        ImageIcon IconBanner = new ImageIcon(getClass().getResource("/UIManager/images/banner.png"));
        IconBanner = new ImageIcon(IconBanner.getImage().getScaledInstance(250, 64, Image.SCALE_SMOOTH));
        JLabel LabelBanner = new JLabel(IconBanner);
        int bannerX = 135;
        int bannerY = 110;
        JPanel PanelBanner = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelBanner.setSize(IconBanner.getIconWidth(), IconBanner.getIconHeight());
        PanelBanner.setOpaque(false);
        PanelBanner.add(LabelBanner);
        PanelBanner.setBounds(bannerX, bannerY, 250,64);

        ImageIcon IconON = new ImageIcon(getClass().getResource("/UIManager/images/ON.png"));
        IconON = new ImageIcon(IconON.getImage().getScaledInstance(64, 32, Image.SCALE_SMOOTH));
        JLabel LabelON = new JLabel(IconON);
        int musicX = 820;
        int musicY = 40;
        PanelON = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelON.setSize(IconON.getIconWidth(), IconON.getIconHeight());
        PanelON.setOpaque(false);
        PanelON.add(LabelON);
        PanelON.setBounds(musicX, musicY, 64,32);
        PanelON.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PanelON.setVisible(false);
                PanelOFF.setVisible(true);
                AudioLoop.togglePause();
            }

            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        ImageIcon IconOFF = new ImageIcon(getClass().getResource("/UIManager/images/OFF.png"));
        IconOFF = new ImageIcon(IconOFF.getImage().getScaledInstance(64, 32, Image.SCALE_SMOOTH));
        JLabel LabelOFF = new JLabel(IconOFF);
        PanelOFF = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelOFF.setSize(IconOFF.getIconWidth(), IconOFF.getIconHeight());
        PanelOFF.setOpaque(false);
        PanelOFF.add(LabelOFF);
        PanelOFF.setBounds(musicX, musicY, 64,32);
        PanelOFF.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PanelON.setVisible(true);
                PanelOFF.setVisible(false);
                AudioLoop.togglePause();
            }

            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        JLabel musica = new JLabel("<html>MUSICA:</html>");
        musica.setFont(new Font("Arial", Font.BOLD, 15));
        musica.setForeground(new Color(0,0,0,255));
        musica.setBounds(750, 30, 130, 54);

        JLabel text = new JLabel("<html>SURVIVAL GAME</html>");
        text.setFont(new Font("Arial", Font.BOLD, 15));
        text.setForeground(new Color(0,0,0,255));
        text.setBounds(200, 115, 130, 54);


        JLabel playerNameLabel = new JLabel("<html><p align='justify'><br>Tanto tempo fa, ci fu un cavaliere di nome:<br><br>Egli aveva la missione di esplorare la terra di Cerebotania per raccogliere tutti gli oggetti di estremo valore presenti e riportarli al re, ma le sue gambe avevano un problema: dopo 100 passi smettevano di funzionare per il resto della giornata. Raccogli tutti gli item presenti per vincere.</p></html>");
        playerNameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        playerNameLabel.setForeground(new Color(0,0,0,255));
        playerNameLabel.setBounds(110, 60, 300, 500);
        

        playerNameField = new JTextField();
        playerNameField.setBounds(110, 215, 150, 23);
        playerNameField.setFont(new Font("Arial", Font.ITALIC, 20));
        playerNameLabel.setForeground(new Color(0,0,0,255));
        playerNameField.setBorder(null);
        playerNameField.setBackground(new Color(231,213,179,255));
        playerNameField.setText("...");
        playerNameField.requestFocusInWindow();
        playerNameField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                playerNameField.setText("");
                ctrlName = true;
            }

            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

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
        IconButton = new ImageIcon(IconButton.getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH));
        JLabel LabelButton = new JLabel(IconButton);
        int buttonX = 200;
        int buttonY = 500;
        JPanel PanelButton = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelButton.setSize(IconButton.getIconWidth(), IconButton.getIconHeight());
        PanelButton.setOpaque(false);
        PanelButton.add(LabelButton);
        PanelButton.setBounds(buttonX, buttonY, 120,60);
        PanelButton.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!playerNameField.getText().isEmpty() && ctrlName) {
                    playerName = playerNameField.getText();
                    int step = 100;
                    int item = 10;
                    game = new SurvivalGameGUI(playerName, item, step);
                    game.setVisible(true);
                    ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("/UIManager/images/icon.png"));
                    Image image = iconaFrame.getImage();
                    game.setIconImage(image);
                    revalidate();
                    repaint();
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Inserisci un nome giocatore valido", "Attenzione!", JOptionPane.ERROR_MESSAGE);
                }
            }

            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        // -------------------------- Seconda pagina --------------------------

        ImageIcon IconBanner2 = new ImageIcon(getClass().getResource("/UIManager/images/banner.png"));
        IconBanner2 = new ImageIcon(IconBanner2.getImage().getScaledInstance(250, 64, Image.SCALE_SMOOTH));
        JLabel LabelBanner2 = new JLabel(IconBanner2);
        int banner2X = 620;
        int banner2Y = 110;
        JPanel PanelBanner2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelBanner2.setSize(IconBanner2.getIconWidth(), IconBanner2.getIconHeight());
        PanelBanner2.setOpaque(false);
        PanelBanner2.add(LabelBanner2);
        PanelBanner2.setBounds(banner2X, banner2Y, 250,64);

        JLabel textCustom = new JLabel("<html>CUSTOM GAME</html>");
        textCustom.setFont(new Font("Arial", Font.BOLD, 15));
        textCustom.setForeground(new Color(0,0,0,255));
        textCustom.setBounds(685, 115, 130, 54);

        JLabel customGameLabel = new JLabel("<html><p align='justify'>Partita personalizzata, consigliata per chi ha gia' provato il gioco normale.<br>Numero passi:<br><br>Numero item:</p></html>");
        customGameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        customGameLabel.setForeground(new Color(0,0,0,255));
        customGameLabel.setBounds(580, 60, 300, 500);

        stepField = new JTextField();
        stepField.setBounds(580, 335, 150, 23);
        stepField.setFont(new Font("Arial", Font.ITALIC, 20));
        stepField.setForeground(new Color(0,0,0,255));
        stepField.setBorder(null);
        stepField.setBackground(new Color(231,213,179,255));
        stepField.setText("...");
        stepField.requestFocusInWindow();
        stepField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stepField.setText("");
            }

            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        itemField = new JTextField();
        itemField.setBounds(580, 380, 150, 23);
        itemField.setFont(new Font("Arial", Font.ITALIC, 20));
        itemField.setForeground(new Color(0,0,0,255));
        itemField.setBorder(null);
        itemField.setBackground(new Color(231,213,179,255));
        itemField.setText("...");
        itemField.requestFocusInWindow();
        itemField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                itemField.setText("");
            }

            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getDefaultCursor());
            }
        });

        ImageIcon IconButton2 = new ImageIcon(getClass().getResource("/UIManager/images/customButtonStart.png"));
        IconButton2 = new ImageIcon(IconButton2.getImage().getScaledInstance(120, 60, Image.SCALE_SMOOTH));
        JLabel LabelButton2 = new JLabel(IconButton2);
        int button2X = 680;
        int button2Y = 500;
        JPanel PanelButton2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelButton2.setSize(IconButton2.getIconWidth(), IconButton2.getIconHeight());
        PanelButton2.setOpaque(false);
        PanelButton2.add(LabelButton2);
        PanelButton2.setBounds(button2X, button2Y, 120,60);
        PanelButton2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (!playerNameField.getText().isEmpty() && ctrlName) {
                    playerName = playerNameField.getText();
                    try {
                        int step = Integer.parseInt(stepField.getText());
                        int item = Integer.parseInt(itemField.getText());
                        if (step < 0 || item < 0) {
                            JOptionPane.showMessageDialog(null, "Inserisci solo numeri validi!", "Attenzione!", JOptionPane.ERROR_MESSAGE);
                        }
                        else {
                            game = new SurvivalGameGUI(playerName, item, step);
                        }
                    }
                    catch (NumberFormatException ex) {
                        // Se l'utente ha inserito una stringa non convertibile in intero
                        JOptionPane.showMessageDialog(null, "Inserisci solo numeri validi!", "Attenzione!", JOptionPane.ERROR_MESSAGE);
                    }
                    game.setVisible(true);
                    ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("/UIManager/images/icon.png"));
                    Image image = iconaFrame.getImage();
                    game.setIconImage(image);
                    revalidate();
                    repaint();
                    dispose();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Inserisci un nome giocatore valido", "Attenzione!", JOptionPane.ERROR_MESSAGE);
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
        layeredPane.add(PanelON, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelOFF, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelBanner, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelBanner2, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(musica, JLayeredPane.MODAL_LAYER);
        layeredPane.add(text, JLayeredPane.MODAL_LAYER);
        layeredPane.add(textCustom, JLayeredPane.MODAL_LAYER);
        layeredPane.add(playerNameLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(customGameLabel, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(playerNameField, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(stepField, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(itemField, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelCross, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelButton, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelButton2, JLayeredPane.PALETTE_LAYER);
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
