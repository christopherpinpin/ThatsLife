package sample;
import java.util.*;

/** ActionCard defines an Action Card object.
  *
  * <p> Each action card has a description of how it will affect the player who drew 
  * it and an amount that will indicate how much money will be added or deducted to 
  * the player. </p>
  *
  * <p> Action cards will have 4 main methods: collect from bank, collect from player, * pay the bank, and pay the player. Collect from bank will add an amount to the cash * of the player, while pay the bank will deduct an amount to the player's cash. Some * of the action cards may include a method that will pay an amount to all players or * collect an amount from all players, and for some it will be pay and collect to or * from the player of their choosing. </p>
  */


public class ActionCard {

  private String description;
  private int amount;
  private int kind;
  /** Six kinds of cards
    * 1 = collectFromBank
    * 2 = payTheBank
    * 3 = payThePlayer
    * 4 = collectFromPlayer
    * 5 = payAllPlayer
    * 6 = collectAllPlayer
    */

/** instantiates an ActionCard.
  * @param description description of the action card
  * @param amount amount indicated on the card
  * @param kind indicator what action to be done when card is 
  * picked
  */
  public ActionCard (String description, int amount, int kind) 
  {
    this.description = description;
    this.amount = amount;
    this.kind = kind;
  }

/** returns the description on the action card.
  * @return description on the card
  */
  public String getDescription () {
    return description;
  }

  
/** returns the amount indicated on the action card.
  * @return amount indicated on the card
  */
  public int getAmount () {
    return amount;
  }

/** returns the kind of action card.
  * @return the kind of card
  */
  public int getKind() {
    return kind;
  }

/** sets the cash of player.
  * @param p player who will collect money from the bank
  */
  public void collectFromBank (Player p) {
    p.setCash (p.getCash() + amount);
  }

/** sets the cash of two players.
  * @param fromPlayer player who will lose cash
  * @param toPlayer player who will receive cash
  */
  public void collectFromPlayer (Player fromPlayer, Player toPlayer) {
    fromPlayer.setCash (fromPlayer.getCash() - amount);
    toPlayer.setCash (toPlayer.getCash() + amount);
  }


/** collects cash from all players.
  * @param p player that will receive cash
  * @param all arrayList of player that will send cash
  */
  public void collectAll (Player p, ArrayList<Player> all) {
    for(int i=0; i< all.size(); i++){
      if(!(p.equals (all.get(i)))) {
        p.setCash(p.getCash() + amount);
        all.get(i).setCash(all.get(i).getCash() - amount);
      }
    }
  }

/** sets the cash of player.
  * @param p player who will pay the bank
  */
  public void payTheBank (Player p) {
    p.setCash (p.getCash() - amount);
  }

/** sets the cash of two players.
  * @param fromPlayer player that will send cash
  * @param toPlayer player that will receive cash
  */
  public void payPlayer (Player fromPlayer, Player toPlayer){
    fromPlayer.setCash (fromPlayer.getCash() - amount);
    toPlayer.setCash (toPlayer.getCash() + amount);
  }

/** player will send cash to all players.
  * @param p player that will send cash
  * @param all players that will receive cash
  */
  public void payAll (Player p, ArrayList<Player> all) {
    for(int i=0; i< all.size(); i++) {
      if(!(p.equals (all.get(i)))) {
        p.setCash(p.getCash() - amount);
        all.get(i).setCash(all.get(i).getCash() + amount);
      }
    }
  }
}