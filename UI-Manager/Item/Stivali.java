package Item;

public class Stivali extends Item {
    public Stivali() {
        super("Stivali", "Diamond", 10, 0);
    }

    @Override
    public Item spawnItem () {
        Item stivali = new Stivali();
        return stivali;
    }
}
