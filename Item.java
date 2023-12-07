public class Item {
   private String name;
   private int weight;
   private int value;
   private Rarity rarity;

   public Item(String name, int weight, int value, Rarity rarity) {
       this.name = name;
       this.weight = weight;
       this.value = value;
       this.rarity = rarity;
   }

   public int getWeight() {
       return weight;
   }

   public int getValue() {
       return value;
   }

   public Rarity getRarity() {
       return rarity;
   }

    public String getName() {
         return name;
    }
}