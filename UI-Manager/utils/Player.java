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

// Definizione della classe giocatore
public class Player {

    protected int pesoMax = 100;
    protected int stepRimanenti = 50;
    protected int pesoAttuale = 0;
    protected int valoreOgg = 0;
    protected List<Item> backpack = new ArrayList<>();
    private int x;
    private int y;
    private Item ultimoItemRaccolto;

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public boolean canMove() {
        return stepRimanenti > 0 && pesoAttuale <= pesoMax;
    }

    public void movimento() {
        stepRimanenti--;
    }

    public String collectItem(Item item) {
        if (pesoAttuale + item.getPeso() <= pesoMax) {
            backpack.add(item);
            pesoAttuale += item.getPeso();
            valoreOgg += item.getValore();
            ultimoItemRaccolto = item;
            return "L'oggetto " + item.getName() + " e' stato aggiunto all'inventario!";
        }
        else {
            return "L'oggetto " + item.getName() + " non può essere aggiunto allo zaino perché supera il peso massimo";
        }
    }

    public int getCollectedValue() {
        return valoreOgg;
    }

    public int getPesoMax() {
        return this.pesoMax;
        }
    
    public int getStepRimanenti() {
        return this.stepRimanenti;
    }
    
    public int getPesoAttuale() {
        return this.pesoAttuale;
    }
    
    public int getValoreOgg() {
        return this.valoreOgg;
    }
    
    public List<Item> getBackpack() {
        return this.backpack;
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
    
    // Metodo per creare item su mappa
    public void spawnOgg(ImageIcon[] itemIcon, JLabel[] itemLabel, JPanel[] itemPanel, JLayeredPane layeredPane, Item obj, int i) {
        itemIcon[i] = new ImageIcon(itemIcon[i].getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        itemLabel[i] = new JLabel(itemIcon[i]);
        itemPanel[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        itemPanel[i].setOpaque(false);
        itemPanel[i].add(itemLabel[i]);
        itemPanel[i].setBounds(obj.rndX(), obj.rndY(), 64, 64);
        layeredPane.add(itemPanel[i], JLayeredPane.PALETTE_LAYER);
    }

    // Metodo per calcolare la distanza tra due punti
    private double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
    
    
    // Metodo per trovare l'item più vicino al giocatore
    public Item findClosestItem(List<Item> itemLista) {
        double minDistance = Double.MAX_VALUE;
        Item closestItem = null;
    
        for (Item currentItem : itemLista) { 
            double distance = calculateDistance(getX(), getY(), currentItem.rndX(), currentItem.rndY());
            if (distance < minDistance) {
                minDistance = distance;
                closestItem = currentItem;
            }
        }
    
        return closestItem;
    }
}