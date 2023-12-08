package utils;
import java.util.ArrayList;
import java.util.List;
import Item.Item;
//NICA
// Definizione della classe giocatore
public class Player {

    protected int pesoMax = 100;
    protected int stepRimanenti = 50;
    protected int pesoAttuale = 0;
    protected int valoreOgg = 0;
    protected List<Item> backpack = new ArrayList<>();

    public boolean canMove() {
        boolean canMove = false;
        if(stepRimanenti > 0 && pesoAttuale <= pesoMax) canMove = true;
        return canMove;
    }

    public void movimento() {
        stepRimanenti--;
    }

    public String collectItem(Item item) {
        if (pesoAttuale + item.getPeso() <= pesoMax) {
            backpack.add(item);
            pesoAttuale += item.getPeso();
            valoreOgg += item.getValore();
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
}