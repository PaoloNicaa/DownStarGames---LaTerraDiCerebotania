import UIManager.PlayerNameGUI;
import UIManager.SurvivalGameGUI;
import UIManager.utils.PopUp;
import UIManager.audio.AudioLoop;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // InvokeLater serve per gli aggiornamenti alla gui costanti
        
            Random random = new Random();
            int popup = random.nextInt(5); 
            if(popup == 1) { // 1 possibilita su 5 di far partire il gioco senza pubblicita
                new PopUp(); // Easter egg
            }
                PlayerNameGUI playerNameGUI = new PlayerNameGUI();
                playerNameGUI.setVisible(true);
    
                ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("/UIManager/images/icon.png"));
                Image image = iconaFrame.getImage();
                playerNameGUI.setIconImage(image);
    
                new Thread(() -> { // Thread per gestire l'audio
                    try {
                        new AudioLoop();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }).start();
        });
    }
}
