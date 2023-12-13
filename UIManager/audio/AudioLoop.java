package UIManager.audio;

import javax.sound.sampled.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.URL;

public class AudioLoop implements KeyListener {
    private Clip clip;
    private boolean paused;

    public AudioLoop(String filePath) {
        try {
            // Carica il suono da file
            URL soundURL = getClass().getResource(filePath);
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

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_M) {
            togglePause(); // Chiamerà il metodo per mettere in pausa/riprendere la musica
        }
    }

    private void togglePause() {
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

    // Implementazioni non utilizzate
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
