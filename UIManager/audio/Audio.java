package UIManager.audio;

import javax.sound.sampled.*;

//---------Classe per audio non in loop-------------//

public class Audio {
    
    String filePath;
    
    public static void playSound(String filePath) {
            try {
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(Audio.class.getResourceAsStream(filePath));
                Clip clip = AudioSystem.getClip();
                clip.open(audioInputStream);
                clip.start();
    
                // Attendi fino a quando il suono è riprodotto completamente
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.close();
                    }
                });
    
            } catch (UnsupportedAudioFileException | LineUnavailableException | java.io.IOException e) {
                e.printStackTrace();
            }
        }
}


