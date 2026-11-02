package cardgame;

import java.util.*;

public class Player {

   private static final int INITIAL_GOLD = 5;
   private int gold;
   private int wood;
   private int rock;
   private List<Card> cardsInHand;
   private List<ResourceCard> cardsOnTable;

   public Player() {
      this.gold = INITIAL_GOLD;
      this.wood = 0;
      this.rock = 0;
      this.cardsOnTable = new ArrayList<>();
   }

   public int getGold() {
      return this.gold;
   }
   
   public int getWood() {
      return this.wood;
   }

   public int getRock() {
      return this.rock;
   }

   public void pay(int basicCost) {
      this.gold = this.gold - basicCost;
   }

   public int nbCardsOnTable() {
      return this.cardsOnTable.size();
   }

   public void addRock(int nbRock) {
      this.rock = this.rock + nbRock;
   }

   public void addWood(int nbWood) {
      this.wood = this.wood + nbWood;
   }
   
   public void collect() {
      for(ResourceCard card : this.cardsOnTable) {
         card.collect(this);
      }
   }

   public void payWood(int woodCost) {
      this.wood = this.wood - woodCost;
   }

   public void payRock(int rockCost) {
      this.rock = this.rock- rockCost;
   }

   public void putCardOnTable(ResourceCard resourceCard) {
      this.cardsOnTable.add(resourceCard);
   }

   public void addCardToHand(Card card) {
      this.cardsInHand.add(card);
   }
   public void play() {/* do something and play card*/}
}
