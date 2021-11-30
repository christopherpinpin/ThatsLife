package sample;
import java.util.concurrent.ThreadLocalRandom;
import java.util.*;

/** CareerDeck defines the stack of career cards.
  * 
  * <p> A career card will instantiate an array list of career cards. </p>
  *
  */


public class CareerDeck
{
  private ArrayList<CareerCard> careerCards;
  private int counter;

  /**
    * generates then shuffles the stack of career cards.
    */
  public CareerDeck ()
  {
    counter = 7;

    careerCards = new ArrayList <> ();

    careerCards.add(new CareerCard("Lawyer", true, 8, 5, ThreadLocalRandom.current().nextInt(5, 9)));

    careerCards.add(new CareerCard("Accountant", true, 7, 4, ThreadLocalRandom.current().nextInt(4, 8)));

    careerCards.add(new CareerCard("Computer Consultant", true, 7, 3, ThreadLocalRandom.current().nextInt(3, 8)));

    careerCards.add(new CareerCard("Doctor", true, 8, 5, ThreadLocalRandom.current().nextInt(5, 9)));

    careerCards.add(new CareerCard("Server", false, 4, 1, ThreadLocalRandom.current().nextInt(1, 5)));

    careerCards.add(new CareerCard("Racecar Driver", false, 8, 2,ThreadLocalRandom.current().nextInt(2, 9)));

    careerCards.add(new CareerCard("Athlete", false, 6, 1, ThreadLocalRandom.current().nextInt(1, 7)));

    Collections.shuffle(careerCards);
  }
  

  /** returns the career card on top of the deck 
    * @return career card on top of the deck
    */
  public CareerCard pickFromCareerDeck ()
  {
    if (counter == 0) {
      reshuffle();
      counter = 7;
    }
    counter--;
    return careerCards.get(counter);
  }


  /** returns the stack of career cards 
    * @return arraylist of career cards
    */
  public ArrayList<CareerCard> getCareerCards()
  {
    return careerCards;
  }

  public CareerCard findCareer(String careerName)
  {
    int index = -1;

    for(int i = 0; i < careerCards.size(); i++)
    {
      if (careerName.equalsIgnoreCase(careerCards.get(i).getCareer()))
      {
        index = i;
      }
    }

    return careerCards.get(index);
  }

  /**
   * shuffles the ArrayList of career cards
   */
  public void reshuffle() {
    Collections.shuffle(careerCards);
  }
}