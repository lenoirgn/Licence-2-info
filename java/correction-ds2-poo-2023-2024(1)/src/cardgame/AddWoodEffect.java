package cardgame;

public class AddWoodEffect implements Effect {

   private int nbWoods;
   public AddWoodEffect(int nbWoods) {
      this.nbWoods = nbWoods;
   }

   @Override
   public void apply(Player player) {
      player.addWood(this.nbWoods);
   }
   
}
