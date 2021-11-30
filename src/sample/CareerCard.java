package sample;
/** CareerCard defines the career of a player.
  *
  * <p> Each career card has a career, degree, maxraise, minraise and the generated
  * final max raise. It will be assigned to the player later in the game. </p>
  *
  * <p> It will also check the player's career and degree if the player has a career 
  * or a degree. </p>
  */
public class CareerCard
{
  private String career;
  private boolean degree;
  private boolean pick;
  
  private final int MAXRAISE;
  private final int MINRAISE;
  private final int FINALMAXRAISE;

  /** initializes the career card based on the given parameters
    * @param career name of the career
    * @param degree if career requires degree then true
    * @param MAXRAISE maximum multiplier of raises
    * @param MINRAISE minimum multiplier of raises
    * @param FINALMAXRAISE final raise multiplier
    */
  public CareerCard (String career, boolean degree, int MAXRAISE, int MINRAISE, int FINALMAXRAISE) {
    this.career = career;
    this.degree = degree;
    this.MAXRAISE = MAXRAISE;
    this.MINRAISE = MINRAISE;
    this.FINALMAXRAISE = FINALMAXRAISE;
    pick = false;
  }

  /** returns the career name stated on the CareerCard
    * @return career of the player
    */
  public String getCareer() {
    return career;
  }


  /** indicates if this career requires a degree
    * @return boolean degree (true if it requires)
    */
  public boolean getDegree() {
    return degree;
  }


  /** returns the status of the card if it was already picked
    * @return pick status of the card if already picked
    */
  public boolean getPick(){
    return pick;
  } 

  /** returns the final multiplier after randomizing from     * the range of [MINRAISE, MAXRAISE]
    * @return final multiplier of raise
    */
  public int getFINALMAXRAISE() {
    return FINALMAXRAISE;
  }

  /** updates the status of the card.
    * @param pick status of the card
    */
  public void setPick (boolean pick) {
    this.pick = pick;
  }

}