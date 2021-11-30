package sample;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/** ActionDeck defines a stack of Action Cards.
  *
  * <p> An action deck will instantiate an array list of action 
  * cards. </p>
  *
  * <p> It will replenish and reshuffle the array list of action
  * cards when all action cards are drawn. </p>
  */

public class ActionDeck
{
  private static ArrayList <ActionCard> actionCards;
  private int counter;
  private static final int NUMACTIONCARDS = 50;
  /**
    * generates then shuffles the stack of action cards.
    */
  public ActionDeck () 
  {
    actionCards = new ArrayList<> ();
    counter = 0;

    int rand;
    
    for (int i=0; i < NUMACTIONCARDS*0.40; i++) {
      rand = ThreadLocalRandom.current().nextInt(0, 6);
      if (rand == 0)
        actionCards.add(new ActionCard("Tax Refund", 10000, 1));
      else if (rand == 1)
        actionCards.add(new ActionCard("Sell An Item", 2500, 1));
      else if (rand == 2)
        actionCards.add(new ActionCard("Bonus Payday", 5000, 1));
      else if (rand == 3)
        actionCards.add(new ActionCard("Setup School", 7500, 1));
      else if (rand == 4)
        actionCards.add(new ActionCard("Write A Book", 2500, 1));
      else
        actionCards.add(new ActionCard("Win A Competition", 3500, 1));
      counter++;
    }

    for (int i=0; i < NUMACTIONCARDS*0.40; i++) {
      rand = ThreadLocalRandom.current().nextInt(0, 5);
      if (rand == 0)
        actionCards.add(new ActionCard("Buy An Item", 3500, 2));
      else if (rand == 1)
        actionCards.add(new ActionCard("Visit A Place", 5000, 2));
      else if (rand == 2)
        actionCards.add(new ActionCard("Hiking", 3500, 2));
      else if (rand == 3)
        actionCards.add(new ActionCard("Watch A Show", 3500, 2));
      else 
        actionCards.add(new ActionCard("Traffic Violation", 3500, 2));
        counter++;
    }

    for (int i=0; i < NUMACTIONCARDS*0.10; i++) {
      rand = ThreadLocalRandom.current().nextInt(0, 2);
      if (rand == 0)
        actionCards.add(new ActionCard("Lawsuit", 5000, 3));
      else 
        actionCards.add(new ActionCard("Christmas Bonus", 2000, 5));
      counter++;
    }

    while (counter != NUMACTIONCARDS)
    {
      rand = ThreadLocalRandom.current().nextInt(0, 2);
      if (rand == 0)
        actionCards.add(new ActionCard("File a Lawsuit", 7500, 4));
      else 
        actionCards.add(new ActionCard("It's Your Birthday", 2000, 6));
      counter++;
    }

    Collections.shuffle(actionCards);
  }


  /** returns an arrayList of action cards.
    * @return arraylist of action cards on the deck
    */
  public ArrayList<ActionCard> getActionCards()
  {
    return actionCards;
  }


  /** returns the card picked from the action deck.
    * @return action card on top of the deck
    */
  public ActionCard pickFromActionDeck() 
  {
    if (counter == 0) {
      reshuffle();
      counter = 50;
    }
    counter--;
    return actionCards.get(counter);
  }
  

  /** reshuffle action deck
    */
  public void reshuffle() {
    Collections.shuffle(actionCards);
  }
}
