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
    private int x;
    private int y;
    
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

    public boolean collectItem(Item item) { // Boolean cosi nel main controllo se il peso soddisfa i requisiti
        if (pesoAttuale + item.getPeso() <= pesoMax)
        {
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
    // Metodo per trovare l'item più vicino al giocatore
    public Item findClosestItem(List<Item> itemLista, int maxDistance ) {
        int minDistance = maxDistance;
        Item closestItem = null;
    
        for (Item currentItem : itemLista)
        { 
            int distance = (int) calculateDistance(getX(), getY(), currentItem.getItemX(), currentItem.getItemY());
            System.out.println("x e y di CurrentItem: " + currentItem.getItemX() + " " + currentItem.getItemY()); // Controllo per la console
            if (distance < minDistance)
            {
                minDistance = distance;
                closestItem = currentItem;
            }

            if(minDistance > maxDistance)
            {
                return null;
            }
        }
        return closestItem;
    }
}