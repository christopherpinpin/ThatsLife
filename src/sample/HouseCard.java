package sample;
/** HouseCard defines a card with a type of house and price
  *
  * <p> Each house card has a unique description of the house and an amount indicated. </p>
  * 
  */

public class HouseCard 
{
  private String name;
  private int price;
  private boolean pick;

  /** creates a house card based on the name or description and price indicated.
    * @param name the description of the house
    * @param price the price of the house
    */
  public HouseCard (String name, int price) {
    this.name = name;
    this.price = price;
  }


  /** returns the description or name of the house
    * @return name or description indicated on the card
    */
  public String getName () {
    return name;
  }


  /** returns the price indicated on the card
    * @return the price indicated on the card
    */
  public int getPrice () {
    return price;
  }


  /** returns the status of the card
    * @return returns true if the card is already picked
    */
  public boolean getPick () {
    return pick;
  }


  /** sets the status of the card
    * @param pick status of the card if it is already picked
    */
  public void setPick (boolean pick) {
    this.pick = pick;
  }
}