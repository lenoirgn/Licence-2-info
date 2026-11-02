package cardgame;

public class ResourceCard extends Card {

   private static final int DEFAULT_COST = 1;

   private int nbWood;
   private int nbRocks;

   public ResourceCard(String description, int value, int wood, int rock) {
      super(description, value);
      this.nbWood = wood;
      this.nbRocks = rock;      
   }


   @Override
   public boolean canBePlayed(Player player) {
      return player.getGold() > 0;
   }

   public void collect(Player player) {
      player.addWood(this.nbWood);
      player.addRock(this.nbRocks);
   }

   public void play(Player player) {
      player.pay(ResourceCard.DEFAULT_COST);
      player.putCardOnTable(this);
   }
}
