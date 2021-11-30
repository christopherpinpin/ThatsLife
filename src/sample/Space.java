package sample;
/** Super class of all the spaces
  * <p> Space class will represent each spaces on the board varying in description and color </p>
  */

public class Space 
{
  private String description;

  /** initializes space for the board
    * @param description description that will be indicated on the space
    */
  public Space (String description) 
  {
    this.description = description;
  }

  /** returns the description indicated on the space
    * @return returns the description indicated on the space
    */
  public String getDescription ()
  {
    return description;
  }
}