package UIManager;
import UIManager.audio.Audio;
import UIManager.utils.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameOverGUI extends JFrame implements KeyListener{
    private JLayeredPane layeredPane;
    Player player;

    public GameOverGUI(Player player){
        setTitle("Game Over");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true); // Per togliere la barra sopra bianca
        setBackground(new Color(0,0,0,0)); // Sfondo gui trasparente
        setLocationRelativeTo(null); // Per farlo apparire al centro
        setResizable(false);
        addKeyListener(this);

        this.player=player;
        
        // ------------------Background------------------ //
        ImageIcon backgroundIcon = new ImageIcon(getClass().getResource("/UIManager/images/GameOver.png"));
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        
        if(backgroundIcon.getImage() == null) { // Debug
            System.out.println("Errore");
        }
        
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setSize(getSize());
        
        layeredPane = new JLayeredPane();
        layeredPane.setPreferredSize(getSize());
        layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

        JLabel scorLabel = new JLabel("<html>Score totalizzato: " + player.getValoreOgg() + "</html>");
        scorLabel.setFont(new Font("Arial", Font.BOLD, 24));
        scorLabel.setForeground(Color.WHITE); // Colore del testo
        scorLabel.setBounds(150, 150, getWidth(), getHeight());
       
        layeredPane.add(scorLabel, JLayeredPane.PALETTE_LAYER);
        add(layeredPane);
        
        setVisible(true);

        Audio.playSound("/UIManager/audio/gameOver.wav");
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_ESCAPE)
        {
            System.exit(0); // Uscita dal programma
        }
    }

    public void keyReleased(KeyEvent e) {
    }

}
