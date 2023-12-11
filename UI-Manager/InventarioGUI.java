import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InventarioGUI  extends JFrame implements KeyListener {
    private JLayeredPane layeredPane;

    public InventarioGUI(int mele, int stivali, int spade, int coppe, int anelli) {
        setTitle("Inventario");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setBackground(new Color(0,0,0,0));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        addKeyListener(this);
        setFocusable(true);

        JLabel itemLabel1 = new JLabel("<html>" + mele + "<br><br><br><br>" + stivali + "<br><br><br><br>" + spade + "</html>");
        itemLabel1.setFont(new Font("Arial", Font.BOLD, 24));
        itemLabel1.setForeground(Color.WHITE); // Colore del testo
        itemLabel1.setBounds(115, 35, getWidth(), getHeight());

        JLabel itemLabel2 = new JLabel("<html>" + coppe + "<br><br><br><br>" + anelli + "</html>");
        itemLabel2.setFont(new Font("Arial", Font.BOLD, 24));
        itemLabel2.setForeground(Color.WHITE); // Colore del testo
        itemLabel2.setBounds(225, -20, getWidth(), getHeight());

        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("backgroundInventory.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setSize(getSize());

        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        ImageIcon IconMela = new ImageIcon(getClass().getResource("mela.png"));
        IconMela = new ImageIcon(IconMela.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel LabelMela = new JLabel(IconMela);
        int X = 50;
        int melaY = 50;
        JPanel PanelMela = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelMela.setSize(IconMela.getIconWidth(), IconMela.getIconHeight());
        PanelMela.setOpaque(false);
        PanelMela.add(LabelMela);

        ImageIcon IconStivali = new ImageIcon(getClass().getResource("stivali.png"));
        IconStivali = new ImageIcon(IconStivali.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel LabelStivali = new JLabel(IconStivali);
        int stivaliY = 175;
        JPanel PanelStivali = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelStivali.setSize(IconStivali.getIconWidth(), IconStivali.getIconHeight());
        PanelStivali.setOpaque(false);
        PanelStivali.add(LabelStivali);

        ImageIcon IconSpada = new ImageIcon(getClass().getResource("spada.png"));
        IconSpada = new ImageIcon(IconSpada.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel LabelSpada = new JLabel(IconSpada);
        int spadaY = 285;
        JPanel PanelSpada = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelSpada.setSize(IconSpada.getIconWidth(), IconSpada.getIconHeight());
        PanelSpada.setOpaque(false);
        PanelSpada.add(LabelSpada);

        ImageIcon IconCoppa = new ImageIcon(getClass().getResource("coppa.png"));
        IconCoppa = new ImageIcon(IconCoppa.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel LabelCoppa = new JLabel(IconCoppa);
        int coppaX = 162;
        int coppaY = 50;
        JPanel PanelCoppa = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelCoppa.setSize(IconCoppa.getIconWidth(), IconCoppa.getIconHeight());
        PanelCoppa.setOpaque(false);
        PanelCoppa.add(LabelCoppa);

        ImageIcon IconAnello = new ImageIcon(getClass().getResource("anello.png"));
        IconAnello = new ImageIcon(IconAnello.getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        JLabel LabelAnello = new JLabel(IconAnello);
        int anelloX = 162;
        int anelloY = 175;
        JPanel PanelAnello = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        PanelAnello.setSize(IconAnello.getIconWidth(), IconAnello.getIconHeight());
        PanelAnello.setOpaque(false);
        PanelAnello.add(LabelAnello);

        PanelMela.setBounds(X, melaY, 64,64);
        PanelStivali.setBounds(X, stivaliY, 64,64);
        PanelSpada.setBounds(X, spadaY, 64,64);
        PanelCoppa.setBounds(coppaX, coppaY, 64,64);
        PanelAnello.setBounds(anelloX, anelloY, 64,64);
        layeredPane.add(itemLabel1, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(itemLabel2, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelMela, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelStivali, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelSpada, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelCoppa, JLayeredPane.PALETTE_LAYER);
        layeredPane.add(PanelAnello, JLayeredPane.PALETTE_LAYER);
        add(layeredPane);
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_I) {
            revalidate();
            repaint();
            dispose();
        }
    }

    public void keyReleased(KeyEvent e) {
    }
}
