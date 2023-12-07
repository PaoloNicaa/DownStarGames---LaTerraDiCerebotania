//NODARI


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SurvivalGameGUI extends JFrame {

    public SurvivalGameGUI() {
        setTitle("Survival Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH); // Imposta la finestra a schermo intero
        setUndecorated(true); // Rimuove il bordo e le decorazioni della finestra

        // Aggiungi componenti, pannelli e altri elementi grafici qui

        setVisible(true); // Rendi la finestra visibile
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SurvivalGameGUI(); // Avvia l'applicazione creando un'istanza della finestra
            // Creazione di oggetti
            Item item1 = new Item("Item1", 20, 30, Rarity.BROWN);
            Item item2 = new Item("Item2", 10, 50, Rarity.GREEN);
            // Aggiungi più oggetti se necessario

            List<Item> itemsOnMap = new ArrayList<>();
            itemsOnMap.add(item1);
            itemsOnMap.add(item2);
            // Aggiungi più oggetti sulla mappa se necessario

            Player player = new Player();
            Random random = new Random();

            while (player.canMove()) {
                // Simulazione del movimento del giocatore
                player.move();

                // Controlla se l'oggetto è presente nella posizione del giocatore
                for (Item item : itemsOnMap) {
                    if (random.nextDouble() < 0.3) { // Probabilità di trovare un oggetto
                        player.collectItem(item);
                        itemsOnMap.remove(item); // Rimuovi l'oggetto dalla mappa dopo averlo raccolto
                        break;
                    }
                }
            }

            // Alla fine del gioco, mostra i valori raccolti dal giocatore
            System.out.println("Valore totale raccolto: " + player.getCollectedValue());

            // Calcola il valore massimo raccoglibile (escludendo il peso massimo dello zaino)
            int maxValue = 0;
            for (Item item : itemsOnMap) {
                maxValue += item.getValue();
            }
            System.out.println("Valore massimo raccoglibile: " + (maxValue + player.getCollectedValue()));
            });
    }
}
