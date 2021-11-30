package sample;
/** Player defines the player of the game.
  *
  * <p> Player enters a name of their choice and will have initial 200,000 cash. Their 
  * cash may be deducted or added based on the action card they've picked. </p>
  *
  * <p> For the whole game, they will choose between college path or career path as 
  * their initial life path, but for phase 1 we'll automatically assign them a 
  * career.</p>
  *
  */
public class Player
{
  // variable declaration
  private int cash, loan, turnOrder, curPos, children, lifepath;
  
  private CareerCard careerCard;
  
  private SalaryCard salaryCard;
  
  private HouseCard houseCard;

  private boolean spouse, degree, retire, turn;

  private String name;

  public Player(String name, int cash)
  {
    this.name = name;
    this.cash = cash;
  }

  /** initializes the player.
    * @param name name of the player
    * @param turnOrder turn order of the player
    */
  public Player (String name, int turnOrder, int lifepath)
  {
    this.name = name;
    if(lifepath == 1) //career path
    {
      cash = 200000;
      loan = 0;
    }
    else if(lifepath == 2) //college path
    {
      cash = 200000;
      loan = 40000;
      degree = true;
    }
    this.turnOrder = turnOrder;
    if (this.turnOrder == 1)
      turn = true;
    else turn = false;
    this.lifepath = lifepath;
  }


  /** returns the current cash balance of the player.
    * @return cash of the player
    */
  public int getCash () {
    return cash;
  }


  /** returns the current debt of the player.
    * @return amount of debt of the player
    */
  public int getLoan () {
    return loan;
  }


  /** returns the name of the player.
    * @return name of the player
    */
  public String getName () {
    return name;
  }
  

  /** returns the turn order of the player (ex. first, second).
    * @return turn order of the player
    */
  public int getTurnOrder () {
    return turnOrder;
  }


  /** returns if the player has a degree.
    * @return degree of the player
    */
  /*public boolean getDegree () {
    return degree;
  }
  */
  /** returns if player has a spouse.
   * @return spouse of player
   */
  /*
  public boolean getSpouse () { return spouse; }
  */
  /** returns the career card on hand of the player.
    * @return career card on hand of the player 
    */
  public CareerCard getCareerCard () {
    return careerCard;
  }

  /** returns the salary card on hand of the player.
    * @return salary card on hand of the player 
    */
  public SalaryCard getSalaryCard ()
  {
    return salaryCard;
  }

  /** returns the current position of the player.
    * @return current position of the player
    */
  public int getCurPos ()
  {
    return curPos;
  }

  public boolean getDegree() { return degree; }
  
  /** checks if the Player is married.
    * @return true if married; otherwise, false
    */
  public boolean isMarried ()
  {
    return spouse != false;
  }

  /** checks if the Player is retired.
    * @return true if retired; otherwise, false
    */
  public boolean isRetired ()
  {
    return retire != false;
  }

  /** checks if the Player has children.
    * @return true if Player has children; otherwise, false
    */
  public boolean hasChildren ()
  {
    return children != 0;
  }

  /** checks if the Player has a house.
    * @return true if Player has a house; otherwise, false
    */
  public boolean hasHouse ()
  {
    return houseCard != null;
  }

  /** returns the house card on hand of the player.
    * @return house card on hand  of the player
    */
  public HouseCard getHouse ()
  {
    return houseCard;
  }

  /** returns the current number of children of the player.
    * @return amount of children of player
    */
  public int getChildren ()
  {
    return children;
  }

  /** returns the lifepath value of the player.
    * @return lifepath value
    */
  public int getLifePath()
  {
    return lifepath;
  }
  
  /** sets or edits the house card on the player on hand.
    * @param h house card to be put in the player
    */
  public void setHouseCard(HouseCard h)
  {
    houseCard = h;
  }

  /** sets or edits the career card on the player on hand.
    * @param c career card to be put in the player
    */
  public void setCareerCard(CareerCard c)
  {
    careerCard = c;
  }

  /** sets or edits the salary card on the player on hand.
    * @param s salary card to be put in the player
    */
  public void setSalaryCard(SalaryCard s)
  {
    salaryCard = s;
  }

  /** sets the current position of the player.
    * @param curPos current position of the player
    */
  public void setCurPos(int curPos)
  {
    this.curPos = curPos;
  }

  /** sets the lifepath value of the player.
    * @param lifepath lifepath value
    */
  public void setLifepath (int lifepath)
  {
    this.lifepath = lifepath;
  }
  /** returns if it is currently the player's turn.
    * @return returns true if it is the player's turn
    */
  public boolean isTurn () { 
    return turn;
  }


  /** checks if the player has a debt.
    * @return returns true if loan is not null 
    */
  public boolean hasLoan () {
    return loan != 0;
  }


  /** checks if player has a degree.
    * @return returns true if degree of player is not false
    */
  public boolean hasDegree () {
    return degree != false;
  }


  /** checks if player has a career.
    * @return returns false if player does not have a career  * card
    */
  public boolean hasCareer () {
    return careerCard != null;
  }




  /** sets or edits the current cash balance of player.
    * @param cash the new amount of cash of the player
    */
  public void setCash (int cash) {
    this.cash = cash;
  }


  /** deducts the cash balance of player when he has debt.
    */
  public void payLoan () {
    cash = cash - loan;
    loan = 0;
  }


  /** sets or edits the turn of player.
    * @param turn new condition of the player if it's his/her * turn
    */
  public void setTurn(boolean turn)
  {
    this.turn = turn;
  }

  /** sets the amount of children of the player.
    * @param children number of children
    */
  public void setChildren (int children)
  {
    this.children = children;
  }

  /** sets the loan of the player.
    * @param loan loan amount of player
    */
  public void setLoan (int loan)
  {
    this.loan = loan;
  }

  public void setSpouse(boolean spouse)
  {
    this.spouse = spouse;
  }

  public void setRetire(boolean retire) { this.retire = retire; }
  @Override

  /** checks if player in object is the same as this player.
    * @param obj object to be compared to this player
    */
  public boolean equals (Object obj) {
    if (obj == null)
      return false;
    Player p = (Player) obj;
    return p.name.equalsIgnoreCase (this.name);
  }
}