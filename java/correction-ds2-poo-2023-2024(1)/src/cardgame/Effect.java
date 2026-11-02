package cardgame;

/**
 * an effect of an ActionCard applied when card is plaid
 */
public interface Effect {

   /**
    * apply the effect
    * @param player the player who fires  this effect
    */
   void apply(Player player);

}
