import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import UIManager.SurvivalGameGUI;
import UIManager.utils.PopUp;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // InvokeLater serve per gli aggiornamenti alla gui costanti
            SurvivalGameGUI game = new SurvivalGameGUI();
            ImageIcon iconaFrame = new ImageIcon(SurvivalGameGUI.class.getResource("/UIManager/images/icon.png"));
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
