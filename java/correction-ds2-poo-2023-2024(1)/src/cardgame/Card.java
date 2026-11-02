package cardgame;

public abstract class Card {

   private static final int DEFAULT_COST = 1;

   protected int value;
   protected int cost;
   protected String description;

   public Card(String description, int value) {
      this.description = description;
      this.value = value;
      this.cost = DEFAULT_COST;
   }

   public abstract boolean canBePlayed(Player player) ;

   public String getDescription() { 
      return this.description;
   }

   public int getValue() {
      return this.value;
   }

   public abstract void play(Player player);

}
