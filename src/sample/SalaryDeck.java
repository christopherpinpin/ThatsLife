package sample;
import java.util.*;

/** SalaryDeck defines a stack of salary cards
  *
  * <p> The SalaryDeck will instantiate an array list of salary
  * cards.
  *
  */

public class SalaryDeck 
{
  private ArrayList<SalaryCard> salaryCards;
  private int counter;

  /**  generates the salary cards and shuffle it.
    */
  public SalaryDeck() 
  {
    salaryCards = new ArrayList<>();
    counter = 10;

    for (int i = 1; i < 11; i++)
      salaryCards.add(new SalaryCard(i*10000, i*1000));

    Collections.shuffle(salaryCards);
  }

  public ArrayList<SalaryCard> getSalaryCards ()
  {
    return salaryCards;
  }

  /** player picks up a salary card.
    * @return return a salary card
    */
  public SalaryCard pickFromSalaryDeck() 
  {
    if (counter == 0)
    {
      counter = 10;
      reshuffle();
    }
    counter--;
    return salaryCards.get(counter);
  }

  /**
   * returns the salary card with the input salary
   * @param salary salary to be found
   * @return salary card with salary input
   */
  public SalaryCard findSalary(int salary)
  {
    int index = -1;

    for (int i = 0; i < salaryCards.size(); i++)
    {
      if (salary == salaryCards.get(i).getSalary())
      {
        index = i;
      }
    }

    return salaryCards.get(index);
  }

  /**
   * reshuffles salary cards in the deck
   */
  public void reshuffle() { Collections.shuffle(salaryCards); }
}