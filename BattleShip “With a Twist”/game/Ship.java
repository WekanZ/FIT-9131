import java.util.Random;
import java.util.Scanner;

/**
 * This class store details of ship
 * @author Weikan
 * @version 4.4
 */
public class Ship 
{
	private String shipName;
	private int xPos;
	private int yPos;
	private int noOfHitsMade;
	private int noOfHitsNeeded;
	
	/**
	 * This is a default constructor
	 */
	public Ship()
	{
		this.shipName = "123";
		this.xPos = 0;
		this.yPos = 0;
		this.noOfHitsMade = 0;
		this.noOfHitsNeeded = 1;
	}
	
	/**
	 * This is a non-default constructor
	 * @param (String)shipName the ship's name
	 * @param (int)xPos the ship's x position
	 * @param (int)yPos the ship's y position
	 * @param (int)noOfHitsMade how many time that ship has been hitted
	 * @param (int)noOfHitsNeeded how many hits are needed to destroy the ship 
	 */
	public Ship(String shipName, 
				int xPos, 
				int yPos, 
				int noOfHitsMade, 
				int noOfHitsNeeded) 
	{
		if(shipName.trim().length() < 3 || 
		   shipName.trim().length() > 15 ||
		   xPos < 0 ||
		   yPos < 0 ||
		   noOfHitsMade < 0 ||
		   noOfHitsNeeded < 1)
		{
			this.shipName = "123";
			this.xPos = 0;
			this.yPos = 0;
			this.noOfHitsMade = 0;
			this.noOfHitsNeeded = 1;
		}
		else
		{
			this.shipName = shipName;
			this.xPos = xPos;
			this.yPos = yPos;
			this.noOfHitsMade = noOfHitsMade;
			this.noOfHitsNeeded = noOfHitsNeeded;
		}
	}

	/**
	 * This method increases the noOfHitsMade
	 */
	public void addNoOfHitsMade()
	{
		noOfHitsMade++;
	}
	
	/**
	 * This method display the ship's details 
	 */
	public void display()
	{
		System.out.println(" Ship Name: " + shipName);
		System.out.println(" Current Position: (" + xPos + "," + yPos + ")");
		System.out.println(" Hull Strength: " + noOfHitsNeeded);
	}

	/**
	 * This method get noOfHitsMade
	 * @return (int)noOfHitsMade
	 */
	public int getNoOfHitsMade() 
	{
		return noOfHitsMade;
	}
	
	/**
	 * This method get noOfHitsNeeded
	 * @return (int)noOfHitsNeeded
	 */
	public int getNoOfHitsNeeded() 
	{
		return noOfHitsNeeded;
	}

	/**
	 * This method get the ship's name
	 * @return (String)shipName
	 */
	public String getShipName() 
	{
		return shipName;
	}

	/**
	 * This method get x position
	 * @return (int)xPos
	 */
	public int getXPos() 
	{
		return xPos;
	}

	/**
	 * This method get y position
	 * @return (int)yPos
	 */
	public int getYPos() 
	{
		return yPos;
	}

	/**
	 * This method display message and return the user input
	 * @param (String)text the message you want to display
	 * @return (String)input
	 */
	public String input(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		String input = sc.nextLine();
		return input;
	}

	/**
	 * This method return the user input as integer
	 * @return (int)input
	 */
	public int inputInt()
	{
		Scanner sc = new Scanner(System.in);
		while (!(sc.hasNextInt()))
		{
			System.out.println("Please enter an integer:");
			sc = new Scanner(System.in);		
		}
		int input = sc.nextInt();			
		return input;
	}
	
	/**
	 * This method display message and return the user input as integer
	 * @param (String)text the message you want to display
	 * @return (int)input
	 */
	public int inputInt(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		while (!(sc.hasNextInt()))
		{
			System.out.println("Please enter an integer:");
			sc = new Scanner(System.in);		
		}
		int input = sc.nextInt();			
		return input;
	}
	
	/**
	 * This method set the value of noOfHitsMade
	 * @param (int)noOfHitsMade the noOfHitsMade to set
	 */
	public void setNoOfHitsMade(int noOfHitsMade) 
	{
		while (noOfHitsMade < 0)
		{
			noOfHitsMade = inputInt("The number cannot be negative, please enter again:");
		}
		this.noOfHitsMade = noOfHitsMade;
	}

	/**
	 * This method set the value of noOfHitsNeeded by generating a random number
	 */
	public void setNoOfHitsNeeded() 
	{
		Random random = new Random();
		this.noOfHitsNeeded = random.nextInt(5) + 1;
	}
	
	/**
	 * This method set the value of noOfHitsNeeded
	 * @param (int)noOfHitsNeeded the noOfHitsNeeded to set
	 */
	public void setNoOfHitsNeeded(int noOfHitsNeeded) 
	{
		while (noOfHitsNeeded < 1)
		{
			noOfHitsNeeded = inputInt("The number must above 0, please enter again:");
		}
		this.noOfHitsNeeded = noOfHitsNeeded;
	}

	/**
	 * This method set the ship's name
	 * @param (String)shipName the shipName to set
	 */
	public void setShipName(String shipName) 
	{
		Scanner input = new Scanner(System.in);
		while (shipName.trim().length() < 3 || shipName.trim().length() > 15)
		{
			shipName = input("Ship name must be between 3 and 15 characters long" + "\n" + "Please enter again:");
		}
		this.shipName = shipName;
	}

	/**
	 * This method set the x position
	 * @param (int)xPos the xPos to set
	 */
	public void setXPos(int xPos) 
	{
		while (xPos < 0)
		{
			xPos = inputInt("The number cannot be negative, please enter again:");
		}
		this.xPos = xPos;
	}
	
	/**
	 * This method set the x position in limited range
	 * @param (int)xPos
	 * @param (int)size
	 */
	public void setXPos(int xPos, 
						int size) 
	{
		while (xPos < 0 || xPos >= size)
		{
			xPos = inputInt("Wrong number, please enter a number between 0 and " + (size - 1) + " :");
		}
		this.xPos = xPos;
	}
	
	/**
	 * This method set the y position
	 * @param (int)yPos the yPos to set
	 */
	public void setYPos(int yPos) 
	{
		while (yPos < 0)
		{
			yPos = inputInt("The number cannot be negative, please enter again:");
		}
		this.yPos = yPos;
	}
	
	/**
	 * This method set the y position in limited range
	 * @param (int)yPos
	 * @param (int)size
	 */
	public void setYPos(int yPos, 
						int size) 
	{
		while (yPos < 0 || yPos >= size)
		{
			yPos = inputInt("Wrong number, please enter a number between 0 and " + (size - 1) + " :");
		}
		this.yPos = yPos;
	}
	
}
