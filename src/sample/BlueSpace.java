package sample;
import java.util.*;

/** BlueSpace defines a Blue Space object and extends Space
  *
  * <p> When a player steps on a Blue Space, the player will draw
  * a card a blue card that may trigger the player to pay other players,
  * pay the bank, or collect from the bank </p>
  */

public class BlueSpace extends Space
{
  /** initializes a BlueSpace object with a description.
    * @param description description of the BlueSpace
    */
  public BlueSpace(String description)
  {
    super(description);
  }

  /** return index of the player with matching career.
    * @param p array list of player 
    * @return i index of the player
    */
  public int indexOfCareer(ArrayList<Player> p, String career)
  {
    int i;
    int index = -1;

    for(i=0; i < p.size(); i++)
    {
      if(checkCareer(p.get(i)).equals(career))
        index = i;
    }

    return index;
  }

  /** sets the cash of two players.
    * @param fromPlayer player that will send cash
    * @param toPlayer player that will receive cash
    */
  public void payPlayer (Player fromPlayer, Player toPlayer, int amount)
  {
    fromPlayer.setCash (fromPlayer.getCash() - amount);
    toPlayer.setCash (toPlayer.getCash() + amount);
  }

  /** sets the cash of player.
    * @param p player who will pay the bank
    */
  public void payBank (Player p, int amount) 
  {
    p.setCash (p.getCash() - amount);
  }
  
  /** sets the cash of player.
    * @param p player who will collect money from the bank
    */
  public void collectFromBank (Player p, int amount) 
  {
    p.setCash (p.getCash() + amount);
  }

  /** returns the career of the player entered.
    * @param p player to be checked
    * @return the career of the player
    */
  public String checkCareer (Player p) {
    return p.getCareerCard().getCareer();
  }
}