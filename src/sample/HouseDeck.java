package sample;
import java.util.*;

/** HouseDeck defines a stack of House Cards.
  *
  * <p> A house deck will instantiate an array list of house
  * cards. </p>
  *
  * <p> When a player lands on the "Buy a House" space, they have the ability to choose a house card of their choosing by entering the description fixed on the card. </p>
  */

public class HouseDeck 
{
  private ArrayList <HouseCard> houseCards;
  private int counter;

  /** generates the stack of house cards
    */
  public HouseDeck () 
  {
    houseCards = new ArrayList<>();

    houseCards.add(new HouseCard("Mansion in Manila", 250000));
    houseCards.add(new HouseCard("Bungalow in Mandaluyong", 75000));
    houseCards.add(new HouseCard("RV Van", 50000));
    houseCards.add(new HouseCard("3-Story Townhouse in Laguna", 100000));
    houseCards.add(new HouseCard("Apartment in Taguig", 150000));
    houseCards.add(new HouseCard("Condominium in Pasay", 200000));
    houseCards.add(new HouseCard("Condominium in Makati", 200000));
    houseCards.add(new HouseCard("Mansion in Tagaytay", 300000));
    houseCards.add(new HouseCard("Beach house in Boracay", 500000));
    houseCards.add(new HouseCard("Bungalow in Palawan", 100000));
  }

  /**
   * returns the deck of house cards
   * @return deck or ArrayList of house cards
   */
  public ArrayList<HouseCard> getHouseCards ()
  {
    return houseCards;
  }

  /**
   * returns the house card with the house name input
   * @param house house name to be found
   * @return house card with input house name
   */
  public HouseCard findHouse(String house)
  {
    int index = -1;

    for (int i = 0; i < houseCards.size(); i++)
    {
      if (house.equalsIgnoreCase(houseCards.get(i).getName()))
      {
        index = i;
      }
    }

    return houseCards.get(index);
  }
}