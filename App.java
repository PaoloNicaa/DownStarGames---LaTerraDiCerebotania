import javax.swing.*;
import java.awt.*;
import java.util.Random;
import UIManager.PlayerNameGUI;
import UIManager.SurvivalGameGUI;
import UIManager.utils.PopUp;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // InvokeLater serve per gli aggiornamenti alla gui costanti
            PlayerNameGUI playerNameGUI = new PlayerNameGUI();
            playerNameGUI.setVisible(true);
            
            ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("/UIManager/images/icon.png"));
            Image image = iconaFrame.getImage();
            playerNameGUI.setIconImage(image);


            Random random = new Random();
            int popup = random.nextInt(5); // 1 possibilita su 5 per far partire la pubblicita di grubhub
            if (popup == 1) {
                new PopUp();
            }
        });
    }
}
