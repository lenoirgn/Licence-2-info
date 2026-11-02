package cardgame;

public class SpecialCard extends ActionCard {

   protected int woodCost;
   protected int rockCost;

   public SpecialCard(String description, int value, Effect effect, int woodCost, int rockCost) {
      super(description, value, effect);
      this.woodCost = woodCost;
      this.rockCost = rockCost;
   }


   public boolean canBePlayed(Player player) {
      return super.canBePlayed(player) && player.getWood() > this.woodCost && player.getRock() > this.rockCost;
   }

   @Override
   public void play(Player player) {    
      super.play(player);
      player.payWood(this.woodCost);
      player.payRock(this.rockCost);
   }
 
   
}
