package UIManager.Item;

public class Anello extends Item {
    public Anello() {
        super("Anello", "Platinum", 500, 40);
    }

    @Override
    public Item spawnItem () {
        Item anello = new Anello();
        return anello;
    }
}
