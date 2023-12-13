package UIManager.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PopUp {

    private final String videoPath;

    public PopUp() {
        String nomeFile = "ad.mp4";
        String directoryCorrente = System.getProperty("user.dir"); // Path della directory di lavoro corrente
<<<<<<< HEAD
        directoryCorrente += "/UIManager/utils/"; // Aggiunta sottocartella utils
=======
        directoryCorrente += "\\UIManager\\utils\\"; // Aggiunta sottocartella utils
>>>>>>> 14b50f8c1a70859b68eb76c63104d56329f5b33d
        File file = new File(directoryCorrente, nomeFile);
        String percorsoAssoluto = file.getAbsolutePath(); // Trasformo in stringa il totade del path
        this.videoPath = percorsoAssoluto;
        playVideo();
    }

    private void playVideo() {
        try {
            Desktop.getDesktop().open(new File(videoPath)); // Apertura del file da video player di windows
        } catch (IOException e) {
            e.printStackTrace(); // Print dell'errore in caso il file non venga trovato
        }
    }
}
