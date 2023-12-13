package UIManager.utils;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class PopUp {

    private final String videoPath;

    public PopUp() {
        String nomeFile = "ad.mp4";
        String directoryCorrente = System.getProperty("user.dir"); // Path della directory di lavoro corrente
        directoryCorrente += "/UIManager/utils/"; // Aggiunta sottocartella utils
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
