package UIManager.Item;

public class Mela extends Item {
    public Mela() {
        super("Mela", "Brown", 50, 10);
    }

    @Override
    public Item spawnItem () {
        Item mela = new Mela();
        return mela;
    }
}
