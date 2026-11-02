package cardgame;

public class ActionCard extends Card {

   protected Effect effect;

   public ActionCard(String description, int value, Effect effect) {
      super(description, value);   
      this.effect = effect;
   }

   @Override
   public boolean canBePlayed(Player player) {
      return player.nbCardsOnTable() > 0;
   }

   @Override
   public void play(Player player) {
      this.applyEffect(player);
   }

   protected void applyEffect(Player player) {
      this.effect.apply(player);
   }
  
}
