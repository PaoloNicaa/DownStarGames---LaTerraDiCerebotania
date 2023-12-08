package Item;
import java.awt.*;
import java.util.Random;
//NICA

public abstract class Item {
    private String name;
    private int x;
    private int y; 
    private int peso;
    private int valore;
    private String tipoRarita;
    Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); //Metodo di java awt per prendere la risoluzione dello schermo

    public Item(String name, String tipoRarita, int valore, int peso) {
        this.name = name;
        this.tipoRarita = tipoRarita;
        this.valore = valore;
        this.peso = peso;
    }

    public int getPeso() {
       return this.peso;
    }
      
    public int getValore() {
       return this.valore;
    }

    public String getName() {
        return this.name;
    }

    public String getRarita() {
        return this.tipoRarita;
    }

    public void setX() {
        Random random = new Random();
        this.x = random.nextInt(10, (int)size.getWidth() - 10);
    } 

    public void setY() {
        Random random = new Random();
        this.y = random.nextInt(10, (int)size.getHeight() - 10);
    }

    public int rndItem() {
        Random random = new Random();
        int rnd = random.nextInt(0,4);
        return rnd;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    
    public Item spawnItem (int x, int y) {
        setX();
        setY();
        int rndItem = rndItem();
        if (rndItem == 0) {
            Item mela = new Mela();
            return mela;
        }
        else if (rndItem == 1) {
            Item stivali = new Stivali();
            return stivali;
        }
        else if (rndItem == 2) {
            Item spada = new Spada();
            return spada;
        }
        else if (rndItem == 3) {
            Item coppa = new Coppa();
            return coppa;
        }
        else if (rndItem == 4) {
            Item anello = new Anello();
            return anello;
        }
        else return null;
    }
}