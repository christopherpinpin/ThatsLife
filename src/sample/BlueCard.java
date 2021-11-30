package sample;

/** BlueCard defines a blue card.
  *
  * <p>The deck contaitns 7 blue cards and each has a unique description and a matching career. </p>
  *
  * <p>If the picked card matches the player’s current career, he collects 15000 from the bank. Otherwise, he pays the 
  * player with that career, or if no player has that career, he pays the Bank.</p>
  *
  * <p>The amount indicated in the card may depend on the player's salary card or can be generated randomly with a 
  * specific formula.</p>
  */
public class BlueCard
{
  private String description;
  private int amount;
  private String career;


  /** creates a blue card based on the inputted description, matching career, and amount.
    * @param description description indicated on the blue card
    * @param career matching career of the description
    * @param amount amount to be initialized on the blue card
    */
  public BlueCard (String description, String career, int amount) {
    this.description = description;
    this.career = career;
    this.amount = amount;
  }

  /** overloads the constructor BlueCard to create cards without amount.
    * @param description description indicated on the blue card
    * @param career matching career of the description
    */
  public BlueCard (String description, String career) 
  {
    this.description = description;
    this.career = career;
  }

  /** returns the description indicated on the blue card.
    * @return the description on the card
    */
  public String getDescription () {
    return description;
  }

  /** returns the amount indicated on the card.
    * @return amount indicated on the card
    */
  public int getAmount () {
    return amount;
  }
  
  /** sets the amount of the blue card since it sometimes based on the player.
    * @param amount the new amount on the card
    */
  public void setAmount(int amount){
    this.amount = amount;
  }

  /** returns the matching career of the description indicated on the card.
    * @return the matching career of the card
    */
  public String getCareer () {
    return career;
  }


  /** returns the career of the player entered.
    * @param p player to be checked
    * @return the career of the player
    */
  public String checkCareer (Player p) {
    return p.getCareerCard().getCareer();
  }
}