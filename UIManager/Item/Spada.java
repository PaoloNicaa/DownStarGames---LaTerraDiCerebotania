package UIManager.Item;

public class Spada extends Item {
    public Spada() {
        super("Spada", "Brown", 100, 15);
    }

    @Override
    public Item spawnItem () {
        Item spada = new Spada();
        return spada;
    }
}
