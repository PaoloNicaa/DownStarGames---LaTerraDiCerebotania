package UIManager.utils;
import UIManager.Item.Item;

import java.awt.FlowLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Player {
    
    protected int stepRimanenti = 100;
    protected int valoreOgg = 0;
    protected List<Item> backpack = new ArrayList<>();
    protected int x;
    protected int y;
    protected int i = 0;
    protected int numItem = 1;
    protected Item closestItem;
    protected int valoreInventory = 0;

    //---------------------------------- SETTERS & GETTERS ---------------------------------- //
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
        return stepRimanenti > 0;
    }

    public void movimento() {
        stepRimanenti--;
    }
    
    public int getStepRimanenti() {
        return stepRimanenti;
    }
    
    public int getValoreTot() {
        return valoreOgg;
    }
    
    public List<Item> getBackpack() {
        return backpack;
    }
    
    public void setStepRimanenti(int stepRimanenti) {
        this.stepRimanenti = stepRimanenti;
    }
    
    public void setValoreTot(int valoreOgg) {
        this.valoreOgg += valoreOgg;
    }

    public void setValoreInventory(Item item){
        this.valoreInventory += item.getValore();
    }

    public int getValoreInventory(){
        return valoreInventory;
    }

    public void setBackpack(List<Item> backpack) {
        this.backpack = backpack;
    }

    // ---------------------------------- METODI PER LA GESTIONE DEGLI ITEM ---------------------------------- //
    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public int getNumItem() {
        return numItem;
    }

    public void spawnOgg(ImageIcon[] itemIcon, JLabel[] itemLabel, JPanel[] itemPanel, JLayeredPane layeredPane, Item obj, int i) {
        itemIcon[i] = new ImageIcon(itemIcon[i].getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
        itemLabel[i] = new JLabel(itemIcon[i]);
        itemPanel[i] = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        itemPanel[i].setOpaque(false);
        itemPanel[i].add(itemLabel[i]);
        itemPanel[i].setBounds(obj.rndX(), obj.rndY(), 64, 64);
        layeredPane.add(itemPanel[i], JLayeredPane.PALETTE_LAYER);
        setValoreTot(obj.getValore());
    }

    public void removeItem(JPanel[] itemPanel, JLayeredPane layeredPane, int x, int y) {
        for (int i = 0; i < itemPanel.length-1; i++) {
            if (itemPanel[i].getX() == x && itemPanel[i].getY() == y) {
                layeredPane.remove(itemPanel[i]);
            }
        }
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
    