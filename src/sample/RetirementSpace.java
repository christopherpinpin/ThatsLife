package sample;
import java.util.*;

/** RetirementSpace defines a RetirementSpace object and extends space.
  * <p> When a player lands on this space, the player retires and done with the game.</p>
  *
  */

public class RetirementSpace extends Space
{

  /** initializes retirement space.
    * @param description description of retirement space
    */
  public RetirementSpace (String description)
  {
    super(description);
  }

  /** the first three players to reach the retirement space will       * receive cash.
    * @param curP current player 
    * @param p array list of players
    */
  public void collectFromBank (Player curP, ArrayList<Player> p)
  {
    int count = 0;

    for (int i=0; i < p.size(); i++)
    {
      if (p.get(i).isRetired())
        count++;
    }

    if (count == 1)
      curP.setCash(curP.getCash() + 100000);
    else if (count == 2)
      curP.setCash(curP.getCash() + 50000);
    else if (count == 3)
      curP.setCash(curP.getCash() + 20000);
  }

  /** collect cash based on amount of children.
    * @param p current player
    */
  public void collectChildren (Player p) 
  { 
    if (p.hasChildren ())
    {
      p.setCash(p.getCash() + p.getChildren()*10000); 
      p.setChildren(0);
    }
      
  }

  /** collect cash based on value of house.
    * @param p current player
    */

  public void sellHouse (Player p)
  {
    if (p.hasHouse())
    {
      p.setCash(p.getCash() + p.getHouse().getPrice());
      p.setHouseCard (null);
    }
  }

  /** current player will pay all his loans.
    * @param p current player
    */
  public void repayBank (Player p)
  {
    if (p.hasLoan())
    {
      p.setCash(p.getCash() - (p.getLoan() + (p.getLoan()/20000)*5000));

      p.setLoan(0);
    }
  }
}