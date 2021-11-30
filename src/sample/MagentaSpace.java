package sample;
import java.util.ArrayList;

/** MagentaSpace defines a MagentaSpace object and extends space
  * <p> When a player lands on this space, it will do the method according to the description indicated on the space </p>
  *
  */

public class MagentaSpace extends Space
{

  /** initializes a MagentaSpace
    * @param description indicates the description on the space 
    */
  public MagentaSpace (String description)
  {
    super(description);
  }

  /** player will pick 2 career cards and 2 salary cards and the player will choose one from those cards
    * @param p current player that will do method
    * @param careerChoice chosen career card
    * @param salaryChoice chosen salary card
    */
  public void collegeCareerChoice (Player p, CareerCard careerChoice, SalaryCard salaryChoice)
  {
    p.setCareerCard(careerChoice);
    careerChoice.setPick(true);
    p.setSalaryCard(salaryChoice);
    salaryChoice.setPick(true);
  }


  /** player will pick one career card and one salary card and choose between current and picked cards
    * @param p current player that will do method
    * @param careerChoice chosen career card
    * @param salaryChoice chosen salary card
    */
  public void jobSearch (Player p, CareerCard careerChoice, SalaryCard salaryChoice)
  {
    p.setCareerCard(careerChoice);
    careerChoice.setPick(true);
    p.setSalaryCard(salaryChoice);
    salaryChoice.setPick(true);
  }


  /** player will choose house from the house deck
    * @param p player that will do method
    * @param houseChoice chosen house card 
    */
  public void buyAHouse (Player p, HouseCard houseChoice)
  {
    p.setCash(p.getCash() - houseChoice.getPrice());
    p.setHouseCard(houseChoice);
  }


  /** player will get married and collect cash from players
    * @param p player that got married
    * @param all array list of players in game 
    */
  public void getMarried (Player p, ArrayList<Player> all, int dice)
  {
    if (dice%2 == 1)
    {
      for(int i=0; i< all.size(); i++){
        if(!(p.equals (all.get(i)))) {
          p.setCash(p.getCash() + 5000);
          all.get(i).setCash(all.get(i).getCash() - 5000);
        }
      }  
    }
    
    else
    {
      for(int i=0; i< all.size(); i++){
        if(!(p.equals (all.get(i)))) {
          p.setCash(p.getCash() + 10000);
          all.get(i).setCash(all.get(i).getCash() - 10000);
        }
      }  
    }
    p.setSpouse(true);
  }


  /** player will have children receive cash from players 
    * @param p player now with child 
    * @param all all players in game 
    */
  public void haveChildren (Player p, ArrayList<Player> all, int rand)
  {
      if (rand == 0)
        p.setChildren(p.getChildren() + 1);  
      else p.setChildren(p.getChildren() + 2);

      for(int i=0; i< all.size(); i++){
        if(!(p.equals (all.get(i)))) {
          p.setCash(p.getCash() + 5000*(p.getChildren()));
          all.get(i).setCash(all.get(i).getCash() - 5000*(p.getChildren()));
        }
      }
  }
}