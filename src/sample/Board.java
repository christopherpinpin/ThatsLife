package sample;
import java.util.*;
import java.lang.*;
import java.util.concurrent.ThreadLocalRandom;

/** Board defines a Board Object composed of players, spaces and decks.
  * 
  * <p> The board will instantiate the players, spaces and decks. </p>
  *
  * <p> It creates the players who will participate in the game That's Life. 
  * It also updates the player turn. </p>
  *
  * <p> It will display the action cards that was generated and the players
  * who will play the game. </p>
  *
  * <p> At the end of the game, the board will determine who won among the
  * number of players. The player with the highest cash wins the game. </p>
  */

public class Board
{
  private ArrayList<Player> players;
  private Space[] spaces;

  private HouseDeck houseCardDeck;
  private SalaryDeck salaryCardDeck;
  private BlueDeck blueCardDeck;
  private ActionDeck actionCardDeck;
  private CareerDeck careerCardDeck;

  private int curPlayerTurn;
  private int numPlayer;
  
  /** instantiates the Board object which is composed of players, spaces
    * and decks.
    */
  public Board () {
    players = new ArrayList<> ();
    spaces = new Space[256];
    actionCardDeck = new ActionDeck();
    careerCardDeck = new CareerDeck();
    salaryCardDeck = new SalaryDeck();
    blueCardDeck = new BlueDeck();
    houseCardDeck = new HouseDeck();
    curPlayerTurn = 0;
    numPlayer = 2;

    //Start
    spaces [0] = new MagentaSpace ("Start");

    //Career Path (odd)
    spaces [1] = new GreenSpace ("Pay Day!");
    spaces [2] = new OrangeSpace ("Draw an Action Card!");
    spaces [3] = new OrangeSpace ("Draw an Action Card!");
    spaces [4] = new MagentaSpace ("Get Married!");
    spaces [5] = new OrangeSpace ("Draw an Action Card!");
    spaces [6] = new OrangeSpace ("Draw an Action Card!");

    //College Path (even)
    spaces [7] = new OrangeSpace ("Draw an Action Card!");
    spaces [8] = new OrangeSpace ("Draw an Action Card!");
    spaces [9] = new OrangeSpace ("Draw an Action Card!"); 
    spaces [10] = new OrangeSpace ("Draw an Action Card!");
    spaces [11] = new OrangeSpace ("Draw an Action Card!");
    spaces [12] = new MagentaSpace ("College Career Choice!");

    //1st Merge
    spaces [13] = new GreenSpace ("Pay Raise!", 2000);
    spaces [14] = new OrangeSpace ("Draw an Action Card!");
    spaces [15] = new OrangeSpace ("Draw an Action Card!");
    spaces [16] = new GreenSpace ("Pay Day!");
    spaces [17] = new OrangeSpace ("Draw an Action Card!");
    spaces [18] = new GreenSpace ("Pay Raise!", 2500);
    spaces [19] = new OrangeSpace ("Draw an Action Card!");
    spaces [20] = new OrangeSpace ("Draw an Action Card!");

    //1st Junction
    spaces [21] = new MagentaSpace ("Which Path?");

    //Continue (even)
    spaces [22] = new OrangeSpace ("Draw an Action Card!");
    spaces [23] = new GreenSpace ("Pay Day!");
    spaces [24] = new GreenSpace ("Pay Raise!", 3500);
    spaces [25] = new BlueSpace ("Draw a Blue Card!");
    spaces [26] = new OrangeSpace ("Draw an Action Card!");
    spaces [27] = new OrangeSpace ("Draw an Action Card!");

    //Change Career Path
    spaces [28] = new BlueSpace ("Draw a Blue Card!");
    spaces [29] = new OrangeSpace ("Draw an Action Card!");
    spaces [30] = new MagentaSpace ("Job Search!");
    spaces [31] = new GreenSpace ("Pay Day!");
    spaces [32] = new OrangeSpace ("Draw an Action Card!");
    spaces [33] = new OrangeSpace ("Draw an Action Card!");

    //2nd Merge
    spaces [34] = new GreenSpace ("Pay Raise!", 3500);
    spaces [35] = new OrangeSpace ("Draw an Action Card!");
    spaces [36] = new GreenSpace ("Pay Day!");
    spaces [37] = new BlueSpace ("Draw a Blue Card!");
    spaces [38] = new OrangeSpace ("Draw an Action Card!");
    spaces [39] = new OrangeSpace ("Draw an Action Card!");
    spaces [40] = new GreenSpace ("Pay Day!");
    spaces [41] = new BlueSpace ("Draw a Blue Card!");
    spaces [42] = new OrangeSpace ("Draw an Action Card!");
    spaces [43] = new OrangeSpace ("Draw an Action Card!");

    //2nd junction
    spaces [44] = new MagentaSpace ("Which Path?");

    //Continue
    spaces [45] = new GreenSpace ("Pay Day!");
    spaces [46] = new GreenSpace ("Pay Raise!", 4000);
    spaces [47] = new OrangeSpace ("Draw an Action Card!");
    spaces [48] = new BlueSpace ("Draw a Blue Card!");
    spaces [49] = new GreenSpace ("Pay Raise!", 5000);
    spaces [50] = new OrangeSpace ("Draw an Action Card!");
    spaces [51] = new GreenSpace ("Pay Day!");
    spaces [52] = new OrangeSpace ("Draw an Action Card!");
    spaces [53] = new OrangeSpace ("Draw an Action Card!");

    //Start a Family Path
    spaces [54] = new GreenSpace ("Pay Day!");
    spaces [55] = new BlueSpace ("Draw a Blue Card!");
    spaces [56] = new MagentaSpace ("Get Married!");
    spaces [57] = new OrangeSpace ("Draw an Action Card!");
    spaces [58] = new GreenSpace ("Pay Day!");
    spaces [59] = new MagentaSpace ("Buy a House!");
    spaces [60] = new OrangeSpace ("Draw an Action Card!");
    spaces [61] = new MagentaSpace ("Have Baby or Have Twins?");
    spaces [62] = new GreenSpace ("Pay Day!");
    
    //3rd Merge
    spaces [63] = new GreenSpace ("Pay Day!");
    spaces [64] = new OrangeSpace ("Draw an Action Card!");
    spaces [65] = new OrangeSpace ("Draw an Action Card!");
    spaces [66] = new GreenSpace ("Pay Day!");
    spaces [67] = new OrangeSpace ("Draw an Action Card!");
    spaces [68] = new RetirementSpace ("You are Retired!");
  }

  public int getNumPlayer()
  {
    return numPlayer;
  }

  public void setNumPlayer(int numPlayer)
  {
    this.numPlayer = numPlayer;
  }
  /** returns the array list of players.
    * @return players the participants of the game
    */
  public ArrayList<Player> getPlayerArr () 
  {
    return players;
  }

  /** return the action deck.
    * @return actionCardDeck composed of action cards to be picked up by the * players
    */
  public ActionDeck getActionCardDeck()
  {
    return actionCardDeck;
  }

  /** return careerCard deck.
    * @return careerCardDeck composed of career cards that will later
    * determine the career of a player
    */
  public CareerDeck getCareerCardDeck()
  {
    return careerCardDeck;
  }

  /** return houseCard deck
    * @return houseCardDeck composed of house cards that will be bought by the players
    */
  public HouseDeck getHouseCardDeck() { return houseCardDeck; }

  /** return salaryCard deck.
    * @return salaryCardDeck composed of salary cards
    */
  public SalaryDeck getSalaryCardDeck() { return salaryCardDeck; }

  /** return blue card deck
    * @return blueCardDeck composed of blue cards
    */
  public BlueDeck getBlueCardDeck() { return blueCardDeck; }

  /** returns the spaces on the board
    * @return spaces composed of the different spaces with different description
    */
  public Space[] getSpaces() { return spaces; }

  /**
   * returns the index of the player who's current turn
   * @return curPlayerTurn is the index of the player in current turn
   */
  public int getCurPlayerTurn() { return curPlayerTurn; }

  /**
   * returns if the the name is already among the created players
   * @param pName the name to be checked
   * @return true if name is already among the created players
   */
  public boolean isNameChosen(String pName)
  {
    int count = 0;

    for(int k=0; k < getPlayerArr().size(); k++)
    {
      if (getPlayerArr().get(k).getName().equalsIgnoreCase(pName))
        count++;
    }

    if (count > 0)
      return true;
    else return false;
  }

  /**
   * checks if the input name is empty or less than 4 characters
   * @param pName the name to be checked
   * @return true if the input name is empty or less than 4 characters
   */
  public boolean isNameShortOrNull(String pName)
  {
    int count = 0;

    if (pName.isEmpty() || pName.length() < 4)
      count++;

    if (count > 0)
      return true;
    else return false;
  }
  
  /** returns the index of the player currently playing.
    * @return index index of the player
    */
  public int indexOfCurPlayerTurn ()
  {
    int index=-1;
    for(int i=0; i < players.size(); i++)
    {
      if(players.get(i).isTurn())
        index=i;
    }

    return index;
  }

  /**
    * updates current player turn.
    */
  public void nextPlayerTurn ()
  {
    do
    {
      curPlayerTurn = (curPlayerTurn + 1) % players.size();
    } while (players.get(curPlayerTurn).isRetired());
    updatePlayerTurn();
  }


  /**
    * sets the turn value of each player.
    */
  public void updatePlayerTurn ()
  {
    for(int i=0; i < players.size(); i++)
    {
      if(i == curPlayerTurn)
        players.get(i).setTurn(true);
      else
        players.get(i).setTurn(false);
    }
  }

  /**
   * checks if all the players in the game is retired
   * @return number of players that are retired
   */
  public int isAllRetired()
  {
    int ctr=0;
    
    for(int i=0; i < players.size(); i++)
    {
      if(players.get(i).isRetired())
        ctr++;
    }

    return ctr;
  }
  
  /**
    * display the cash of the players.
    */
  public void displayCash()
  {
    for(int i=0; i < players.size(); i++)
    {
      System.out.println("PLAYER " + players.get(i).getName() + "\nCASH: P" + players.get(i).getCash() + "\n");
    }
  }

  /**
    * displays the winner of the game.
    */
  public ArrayList<Player> gameWinner ()
  {
    int max = 0;
    int index=-1;
    ArrayList<Player> endGamePlayers = new ArrayList<>();


    System.out.println("THAT'S LIFE GAME WINNER");
    for(int k=1; k <= players.size(); k++)
    {
      max = players.get(k-1).getCash();
      for(int i=0; i < players.size(); i++)
      {
        if(players.get(i).getCash() > max)
        {
          max = players.get(i).getCash();
        }
      }

      for(int i=0; i < players.size(); i++)
      {
        if(players.get(i).getCash() == max)
        {
          index=i;
        }
      }
      endGamePlayers.add(new Player(players.get(index).getName(), max));
      players.get(index).setCash(0);

      System.out.println("#" + k + " - " + players.get(index).getName() + "\nCASH: P" + max);
    }
    return endGamePlayers;
  }
  /** player triggers the roll dice method to move.
    * @return returns the randomized value of the dice
    */
  public int rollDice ()
  {
    return ThreadLocalRandom.current().nextInt(1,11);
  }

  /**
    * after rolling the dice, the player's current position
    * is updated.
    */
  public void updateCurPos (int dice, Player curPlayer)
  {
    int curPos = curPlayer.getCurPos();
    int lifepath = curPlayer.getLifePath();

    if (curPos == 4 || curPos == 12 || curPos == 21 || curPos == 30 || curPos == 44 ||
    curPos == 56 || curPos == 59 || curPos == 61)
    {
      if (lifepath == 1 && curPos == 21 )
        curPlayer.setCurPos(curPos + 7);
      else if (lifepath == 1 && curPos == 44)
        curPlayer.setCurPos(curPos + 10);
      else curPlayer.setCurPos(curPos + 1);
      dice -= 1;
    }
    for (int i = 0; i < dice; i++)
    {
      curPos = curPlayer.getCurPos();
      if (curPos == 4 || curPos == 12 || curPos == 21 || curPos == 30 || curPos == 44 ||
              curPos == 56 || curPos == 59 || curPos == 61 || curPos == 68)
        i = dice + 1;
      else if ((curPos == 0 && lifepath == 2) || (curPos == 6 && lifepath == 1) ||
              (curPos == 21 && lifepath == 1) || (curPos == 27 && lifepath == 2))
        curPlayer.setCurPos(curPos + 7);
      else if ((curPos == 44 && lifepath == 1) || (curPos == 53 && lifepath == 2))
        curPlayer.setCurPos(curPos + 10);
      else curPlayer.setCurPos(curPos + 1);
    }
  }
}