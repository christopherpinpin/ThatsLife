package sample;

/** GreenSpace defines a GreenSpace object and extends space
  *
  * <p> When a player steps on a green space, it triggers either the
  * pay raise or pay day method. </p>
  */

public class GreenSpace extends Space
{
  private int amount;
  
  /** initializes a GreenSpace object with a description.
    * @param description description of GreenSpace
    */
  public GreenSpace (String description)
  {
    super(description);
  }

  /** overloads the GreenSpace constructor to initialize it with amount.
    * @param description description of GreenSpace
    * @param amount amount of the GreenSpace for the pay raise
    */
  public GreenSpace(String description, int amount)
  {
    super(description);
    this.amount = amount;
  }

  /** increases the cash of the player depends on his salary.
    * @param p the player whose cash will be increased
    */
  public void payDay (Player p)
  {
    p.setCash(p.getSalaryCard().getSalary() + p.getCash());
  }

  /** increases the salary of the player or the cash of the player.
    * @param p the player whose salary or cash will be increased
    */
  public void payRaise (Player p)
  {
    int maxRaise = p.getCareerCard().getFINALMAXRAISE();
    int count = p.getSalaryCard().getPayRaiseCtr();
    if(count<maxRaise)
    {
      SalaryCard salaryCard = p.getSalaryCard();
      salaryCard.setSalary(salaryCard.getSalary() + amount);
      salaryCard.addPayRaiseValue(salaryCard.getPayRaiseValue() + amount);
      salaryCard.setTaxDue(salaryCard.getTaxDue() + 2000);
      p.getSalaryCard().setPayRaiseCtr(count+1);
    }
    payDay(p);
  }

  /**
   * returns the amount indicated on the space
   * @return amount indicated on the space
   */
  public int getAmount()
  {
    return amount;
  }
}