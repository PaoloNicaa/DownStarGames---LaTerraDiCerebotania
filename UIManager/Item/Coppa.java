package UIManager.Item;

public class Coppa extends Item {
    public Coppa() {
        super("Coppa", "Diamond", 300, 25);
    }

    @Override
    public Item spawnItem () {
        Item coppa = new Coppa();
        return coppa;
    }

    @Override
    public int getValore() {
        return super.getValore();
    }
}
