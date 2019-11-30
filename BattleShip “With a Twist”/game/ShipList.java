import java.util.ArrayList;

/**
 * This class store group of ships
 * @author Weikan
 * @version 4.4
 */
public class ShipList 
{
	private ArrayList<Ship> ships;

	/**
	 * This is a default constructor
	 */
	public ShipList()
	{
		this.ships = new ArrayList<>();
	}
	
	/**
	 * This is a non-default constructor
	 * @param (ArrayList<Ship>)ships
	 */
	public ShipList(ArrayList<Ship> ships) 
	{
		this.ships = ships;
	}

	/**
	 * This method create a new ship in the list
	 */
	public void addShip()
	{
		ships.add(new Ship());
	}
	
	/**
	 * This method add a ship to the list
	 * @param (Ship)ship
	 */
	public void addShip(Ship ship)
	{
		ships.add(ship);
	}
	
	/**
	 * This method add a new ship to the list 
	 * @param (String)shipName
	 * @param (int)xPos
	 * @param (int)yPos
	 * @param (int)noOfHitsMade
	 * @param (int)noOfHitsNeeded
	 */
	public void addShip(String shipName, 
						int xPos, 
						int yPos, 
						int noOfHitsMade, 
						int noOfHitsNeeded)
	{
		Ship ship = new Ship(shipName, xPos, yPos, noOfHitsMade, noOfHitsNeeded);
		ships.add(ship);
	}
	
	/**
	 * This method check the number of ships that alive
	 * @return (int)number
	 */
	public int checkNoOfShips()
	{
		int number = 0;
		for (int index = 0; index < ships.size(); index++)
		{
			if (ships.get(index).getNoOfHitsMade() < ships.get(index).getNoOfHitsNeeded())
				number++;
		}
		return number;
	}
	
	public int getLength()
	{
		return ships.size();
	}
	
	/**
	 * This method get a certain ship from the list
	 * @param (int)index
	 * @return (Ship)ship
	 */
	public Ship getShip(int index)
	{
		return ships.get(index);
	}
	
	/**
	 * This method return the group of ships
	 * @return (ArrayList<Ship>)ships
	 */
	public ArrayList<Ship> getShips() 
	{
		return ships;
	}

	/**
	 * This method set the group of ships
	 * @param (ArrayList<Ship>) ships
	 */
	public void setShips(ArrayList<Ship> ships) 
	{
		this.ships = ships;
	}
}
