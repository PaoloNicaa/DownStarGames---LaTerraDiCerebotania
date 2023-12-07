package utils;
import java.util.ArrayList;
import java.util.List;
import Item.Item;

// Definizione della classe giocatore
public class Player {
    private int maxWeight = 100;
    private int remainingSteps = 50;
    private int currentWeight = 0;
    private int collectedValue = 0;
    private List<Item> backpack = new ArrayList<>();

    public boolean canMove() {
        return remainingSteps > 0 && currentWeight <= maxWeight;
    }

    public void move() {
        remainingSteps--;
        
    }

    public void collectItem(Item item) {
        if (currentWeight + item.getWeight() <= maxWeight) {
            backpack.add(item);
            currentWeight += item.getWeight();
            collectedValue += item.getValue();
        }
    }

    public int getCollectedValue() {
        return collectedValue;
    }
}