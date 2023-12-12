package utils;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import Item.Item;

//NICA

public class Player {
    
    protected int pesoMax = 100;
    protected int stepRimanenti = 50;
    protected int pesoAttuale = 0;
    protected int valoreOgg = 0;
    protected List<Item> backpack = new ArrayList<>();
    protected int x;
    protected int y;
    protected int i = 0;
    protected Item closestItem;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public boolean canMove() {
        return stepRimanenti > 0 && pesoAttuale <= pesoMax;
    }

    public void movimento() {
        stepRimanenti--;
    }

    public void spawnOgg(ImageIcon[] itemIcon, JLabel[] itemLabel, JPanel[] itemPanel, JLayeredPane layeredPane, Item obj, int i) {
        itemIcon[i] = new ImageIcon(itemIcon[i].getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        itemLabel[i] = new JLabel(itemIcon[i]);
        itemPanel[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        itemPanel[i].setOpaque(false);
        itemPanel[i].add(itemLabel[i]);
        itemPanel[i].setBounds(obj.rndX(), obj.rndY(), 64, 64);
        layeredPane.add(itemPanel[i], JLayeredPane.PALETTE_LAYER);
    }

    public void removeItem(JPanel[] itemPanel, JLayeredPane layeredPane, int x, int y) {
        for (int i = 0; i < 15; i++) {
            if (itemPanel[i].getX() == x && itemPanel[i].getY() == y) {
                layeredPane.remove(itemPanel[i]);
            }
        }
    }

    public boolean collectItem(Item item) { // Boolean cosi nel main controllo se il peso soddisfa i requisiti
        if (pesoAttuale + item.getPeso() <= pesoMax)
        {
            System.out.println("Contenuto dello zaino: " + getBackpack());
            backpack.add(item);
            pesoAttuale += item.getPeso();
            valoreOgg += item.getValore();
            return true;
        }
        else
        {
            return false; 
        }
    }

    public int getCollectedValue() {
        return valoreOgg;
    }

    public int getPesoMax() {
        return pesoMax;
        }
    
    public int getStepRimanenti() {
        return stepRimanenti;
    }
    
    public int getPesoAttuale() {
        return pesoAttuale;
    }
    
    public int getValoreOgg() {
        return valoreOgg;
    }
    
    public List<Item> getBackpack() {
        return backpack;
    }
    
    public void setPesoMax(int pesoMax) {
        this.pesoMax = pesoMax;
    }
    
    public void setStepRimanenti(int stepRimanenti) {
        this.stepRimanenti = stepRimanenti;
    }
    
    public void setPesoAttuale(int pesoAttuale) {
        this.pesoAttuale = pesoAttuale;
    }
    
    public void setValoreOgg(int valoreOgg) {
        this.valoreOgg = valoreOgg;
    }
    
    public void setBackpack(List<Item> backpack) {
        this.backpack = backpack;
    }
    // Metodo per calcolare la distanza tra due punti
    private double calculateDistance(int x1, int y1, int x2, int y2) {
        int distance = (int) Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        
        System.out.println("Distanza tra due punti: " + distance); // Controllo per la console
        
        return distance;
    }
    // Metodo per trovare l'oggetto per terra piu' vicino al player
    public Item findClosestItem(List<Item> items) {
        closestItem = null;
        double pickupRadius = 150.0; // Definisci il raggio di azione del player
        double distance = 0;
    
        for (Item item : items) {
            distance = calculateDistance(x, y, item.getItemX(), item.getItemY());
            i++;
            if (distance < pickupRadius) {
                closestItem = item;
                break;
            }
            else {
                i = 0;
            }
        }
        i = 0;
        return closestItem;
    }
}
    