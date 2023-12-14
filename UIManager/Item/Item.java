package UIManager.Item;

import java.awt.*;
import java.util.Random;

public abstract class Item {
    private String name;
    private int peso;
    private int valore;
    private String tipoRarita;
    private int x, y;

    public Item(String name, String tipoRarita, int valore, int peso) {
        this.name = name;
        this.tipoRarita = tipoRarita;
        this.valore = valore;
        this.peso = peso;
    }

    public int getPeso() {
       return peso;
    }
      
    public int getValore() {
       return valore;
    }

    public String getName() {
        return name;
    }

    public String getRarita() {
        return tipoRarita;
    }

    public int rndX() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        Random random = new Random();
        x = random.nextInt(((int)size.getWidth()));
        if (x > (size.getWidth() - 64)) { // Controllo per evitare che gli item si generino al di fuori della mappa
            x -= 64;
        }
        return x;
    } 

    public int rndY() {
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        Random random = new Random();
        y = random.nextInt(((int)size.getHeight()));
        if (y > (size.getHeight() - 80)) { // Controllo per evitare che gli item si generino al di fuori della mappa e io riesca comunque a raccoglierli
            y -= 80;
        }
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Item otherItem = (Item) obj;
        // Confronto degli attributi rilevanti per determinare l'uguaglianza
        // Modifica questi confronti in base alla struttura specifica della tua classe Item.
        return this.getItemX() == otherItem.getItemX() &&
               this.getItemY() == otherItem.getItemY();
    }

    public int getItemX() {
        return x;
    }

    public int getItemY() {
        return y;
    }

    public Item spawnItem () {
        return null;
    }
}