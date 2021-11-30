package sample;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/** BlueDeck defines a stack of blue cards.
  *
  * <p>The deck contains 7 blue cards and each has a unique description and a matching career. </p>
  *
  * <p>If the picked card matches the player’s current career, he collects 15000 from the bank. Otherwise, he pays the 
  * player with that career, or if no player has that career, he pays the Bank.</p>
  *
  */

public class BlueDeck
{
  private ArrayList<BlueCard> blueCards;
  private int counter=0;
  
  /** generates a deck of blue cards
    */
  public BlueDeck () 
  {
    blueCards = new ArrayList<>();

    blueCards.add(new BlueCard("Lawsuit","Lawyer", ThreadLocalRandom.current().nextInt(5, 16)*10000));
    blueCards.add(new BlueCard("Salary Tax Due", "Accountant"));
    blueCards.add(new BlueCard("Tip the Server", "Server"));
    blueCards.add(new BlueCard("Ski Accident", "Doctor", 10000));
    blueCards.add(new BlueCard("Computer Repair", "Computer Consultant"));
    blueCards.add(new BlueCard("World Cup", "Athlete"));
    blueCards.add(new BlueCard("F1 Race", "Racecar Driver"));

    Collections.shuffle(blueCards);
  }

  /** return the card picked from the blue deck.
    * @return bluecard at the top of the deck
    */
  public BlueCard pickFromBlueDeck()
  {
    if (counter == 0) {
      reshuffle();
      counter = 7;
    }
    counter--;
    return blueCards.get(counter);
  }

  /** reshuffle blue deck
    */
  public void reshuffle() {
    Collections.shuffle(blueCards);
  }
}