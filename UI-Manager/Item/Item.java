package Item;
import java.util.Random;
//NICA

public class Item {
   private String name;
   private int x;
   private int y; 
   private int peso;
   private int value;
   private String tipoRarita;
   private int rarity;

   public Item(String name, String tipoRarita) {
       this.name = name;
       this.tipoRarita = tipoRarita;
   }

   public void setPeso() {
       if (getRarity() == 3) {
           this.peso = 25;
       } else if (getRarity() == 4) {
           this.peso = 20;
       } else if (getRarity() == 5) {
           this.peso = 15;
       } else if (getRarity() == 6) {
           this.peso = 10;
       } else {
           this.peso = 0;
       }
   }

   public int getPeso() {
       return peso;
   }

   public void setValue(){
         if (getRarity() == 3) {
              this.value = 100;
         } else if (getRarity() == 4) {
              this.value = 75;
         } else if (getRarity() == 5) {
              this.value = 50;
         } else if (getRarity() == 6) {
              this.value = 25;
         } else {
              this.value = 0;
         }
   } 
      
   public int getValue() {
       return value;
   }

   public void setX() {
        Random random = new Random();
        this.x = random.nextInt(31);
   } 

    public void setY() {
        Random random = new Random();
        this.y = random.nextInt(31); 
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

   public void setRarity(int rarity) {
        if (tipoRarita.equals("Platinum")) {
           this.rarity = 3;
       } else if (tipoRarita.equals("Diamond")) {
           this.rarity = 4;
       } else if (tipoRarita.equals("Green")) {
           this.rarity = 5;
       } else if (tipoRarita.equals("Brown")) {
           this.rarity = 6;
       } else {
           this.rarity = 0;
       }
   }

   public int getRarity() {
       return rarity;
   }

    public String getName() {
         return name;
    }

    public Item spawnItem (int x, int y, int rarity, int weight, int value) {
        Item item = new Item(name, tipoRarita);
        item.setX();
        item.setY();
        item.setRarity(rarity);
        return item;
    }
}