package UIManager.audio;

import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class AudioLoop {
    private static Clip clip;
    private static boolean paused;

    public AudioLoop() {
        try {
            // Carica il suono da file
            URL soundURL = getClass().getResource("/UIManager/audio/loopSoundInGame.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundURL);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Inizializza come non in pausa
            paused = false;
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void togglePause() {
        if (clip != null) {
            if (paused) {
                // Riprendi la riproduzione dal punto in cui era stata messa in pausa
                clip.start();
            } else {
                // Metti in pausa la riproduzione
                clip.stop();
            }
            // Inverti lo stato di pausa
            paused = !paused;
        }
    }

    // Restituisce lo stato corrente della pausa
    public boolean isPaused() {
        return paused;
    }
}
