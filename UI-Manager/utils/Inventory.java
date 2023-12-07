package utils;
//NICA

import java.util.ArrayList;
import java.util.List;

import Item.Item;

public class Inventory {
    private List<Item> items;
    private static final int MAX_WEIGHT = 100;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void addItem(Item item) {
        if (getTotalWeight() + item.getWeight() <= MAX_WEIGHT) {
            items.add(item);
        } else {
            String output = "L'oggetto " + item.getName() + " non può essere aggiunto allo zaino perché supera il peso massimo";  //JTextArea
        }
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (Item item : items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public int getTotalValue() {
        int totalValue = 0;
        for (Item item : items) {
            totalValue += item.getValue();
        }
        return totalValue;
    }
}
