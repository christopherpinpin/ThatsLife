package sample;
/** Salary Card defines a Salary Card object.
  *
  * <p> Salary card contains the salary and taxdue of a player </p>
  *
  */

public class SalaryCard 
{
  private int salary, taxDue, payRaiseCtr, payRaiseValue;
  private boolean pick;

  /** instantiates a Salary Card.
    * @param salary salary of the player
    * @param taxDue taxdue of the player
    */
  public SalaryCard (int salary, int taxDue) 
  {
    this.salary = salary;
    this.taxDue = taxDue;
    payRaiseValue = 0;
    payRaiseCtr = 0;

  }

  /** returns the salary indicated on the card.
    * @return return the salary amount
    */
  public int getSalary () {
    return salary;
  }

  /** returns the taxDue indicated on the card.
    * @return return the taxdue
    */
  public int getTaxDue () {
    return taxDue;
  }

  /** return the status of the card.
    * @return return the status of the card
    */
  public boolean getPick () {
    return pick;
  }

  /** updates the status of the card.
    * @param pick status of the card
    */
  public void setPick (boolean pick) {
    this.pick = pick;
  }

  /** updates the salary of salary card.
    * @param amount amount to be updated to salary
    */
  public void setSalary(int amount)
  {
    salary = amount;
  }

  /** updates the tax due of salary card.
    * @param amount amount to be updated to tax due
    */
  public void setTaxDue (int amount)
  {
    taxDue = amount;
  }

  /** gets the pay raise counter of salary card.
    * @return payRaiseCtr counter of pay raise 
    */
  public int getPayRaiseCtr()
  {
    return payRaiseCtr;
  }

  /** gets the pay raise value of salary card.
    * @return payRaiseValue value of pay raise 
    */
  public int getPayRaiseValue()
  {
    return payRaiseValue;
  }

  /** updates the pay raise counter of salary card.
    * @param ctr counter to be updated to pay raise counter
    */
  public void setPayRaiseCtr(int ctr)
  {
    payRaiseCtr = ctr;
  }

  /** updates the pay raise value
    */
  public void addPayRaiseValue(int amount)
  {
    payRaiseValue = amount;
  }
}