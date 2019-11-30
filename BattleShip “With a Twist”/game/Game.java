import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class can operate the game
 * @author Weikan
 * @version 4.4
 */
public class Game 
{
	/**
	 * This is the main method
	 * @param (String[])args
	 */
	public static void main(String[] args) 
	{
		Game game = new Game();
		game.play();
	}
	
	private ShipList playerShips;
	private ShipList computerShips;
	
	/**
	 * This is a default constructor
	 */
	public Game()
	{
		this.playerShips = new ShipList();
		this.computerShips = new ShipList();
	}

	/**
	 * This is a non-default constructor
	 * @param (ShipList)playerShips
	 * @param (ShipList)computerShips
	 */
	public Game(ShipList playerShips, 
				ShipList computerShips)
	{
		this.playerShips = playerShips;
		this.computerShips = computerShips;
	}
	
	/**
	 * This method replace the "~" to "0" in the map
	 * @param (ArrayList<String>)map
	 * @param (ShipList)ships
	 * @param (int)size
	 */
	private void addShipToMap(ArrayList<String> map, 
							  ShipList ships,
							  int size)
	{
		for (int index = 0; index < playerShips.getLength(); index++)
			map.set(ships.getShip(index).getXPos() + ships.getShip(index).getYPos() * size, "0");
	}
	
	/**
	 * This method check if the grid is big enough to display ships
	 * @param (int)noOfShips
	 * @param (int)size
	 * @return (int)noOfShips
	 */
	private int checkNoOfShips(int noOfShips,
							   int size)
	{
		if (noOfShips > size * size)
		{
			System.out.print("Because your grid size is " + size + ", ");
			System.out.println("the maximum number of ships is " + (size * size));
			while(noOfShips > size * size ||
				  noOfShips < 1)
				noOfShips = Input.inputInt("Please reset the number of ships between " + 1 + " and " + (size * size) + " :");
			System.out.println("Reset successfully, the new number of ships is " + noOfShips);
		}
		return noOfShips;
	}
	
	/**
	 * This method check the validation of the setting file
	 * @param (ArrayList<String>)setting
	 */
	private void checkSetting(String[] setting)
	{
		try 
		{
			int size = Integer.valueOf(setting[0].trim());
			boolean multipleHit = Boolean.valueOf(setting[1].trim());
			boolean visible = Boolean.valueOf(setting[2].trim());
			int noOfShips = Integer.valueOf(setting[3].trim());
		}
		catch(Exception e)
		{
			System.out.println("Wrong setting in the file: gamesettings.txt");
			System.out.println("Please check your setting!");
			this.toContinue("exit");
			System.exit(0);
		}
	}
	
	/**
	 * This method is computer's attack action
	 * @param (ArrayList<String>)mapP1
	 * @param (int)size
	 * @return (boolean)true/false
	 */
	private boolean computerAct(ArrayList<String> mapP1,
								int size)
	{
		System.out.println("\nComputer to make a guess");
		int x = CoordinateGenerator.creatRandomNumber(0, size - 1);
		System.out.println("Computer x guess:" + x);
		int y = CoordinateGenerator.creatRandomNumber(0, size - 1);
		System.out.println("Computer y guess:" + y);
		if (mapP1.get(x + y * size).equals("0") ||
			mapP1.get(x + y * size).equals("D"))
		{
			System.out.println("COMPUTER HITTTTT!!!!");
			for (int index = 0; index < playerShips.getLength(); index++)
			{
				if (playerShips.getShip(index).getXPos() == x &&
					playerShips.getShip(index).getYPos() == y )
				{
					playerShips.getShip(index).addNoOfHitsMade();
					if (playerShips.getShip(index).getNoOfHitsMade() == playerShips.getShip(index).getNoOfHitsNeeded())
					{
						mapP1.set(x + y * size, "X");
						System.out.println("Unfortunately, Player Ship " + playerShips.getShip(index).getShipName() + " has been destroyed!");
					}
					else
						mapP1.set(x + y * size, "D");
					break;
				}
			}
			return true;
		}
		else
		{
			System.out.println("COMPUTER MISSSSSS!!!!");
			return false;
		}
	}
	
	/**
	 * This method display the grid in the screen
	 * @param (ArrayList<String>)mapP1
	 * @param (ArrayList<String>)mapCom
	 * @param (int)size
	 * @param (boolean)visible
	 */
	private void displayGrid(ArrayList<String> mapP1, 
							 ArrayList<String> mapCom,
							 int size,
							 boolean visible)
	{
		System.out.println("Player Grid");
		this.displayMap(mapP1, size);
		System.out.println("----------------------------");
		System.out.println("Computer Grid");
		this.displayMap(mapCom, size, visible);
	}
	
	/**
	 * This method display the grid in the screen
	 * @param (ArrayList<String>)map
	 * @param (int)size
	 */
	private void displayMap(ArrayList<String> map,
							int size)
	{
		for (int x = 0; x < size; x++)
		{
			for (int y = 0; y < size; y++)
				System.out.print(map.get(x * size + y));
			System.out.print("\n");
		}
	}

	/**
	 * This method display the grid in the screen
	 * @param (ArrayList<String>)map
	 * @param (int)size
	 * @param (boolean)visible
	 */
	private void displayMap(ArrayList<String> map,
							int size,
						    boolean visible)
	{
		if (visible)
		{
			for (int x = 0; x < size; x++)
			{
				for (int y = 0; y < size; y++)
					System.out.print(map.get(x * size + y));
				System.out.print("\n");
			}
		}
		else
		{
			for (int x = 0; x < size; x++)
			{
				for (int y = 0; y < size; y++)
				{
					if (map.get(x * size + y).equals("0"))
						System.out.print("~");
					else
						System.out.print(map.get(x * size + y));
				}
				System.out.print("\n");
			}
		}
	}
	
	/**
	 * This method display player's setting
	 * @param (int)size
	 * @param (int)shipNo
	 * @param (boolean)multipleHit
	 * @param (boolean)visible
	 */
	private void displaySetting(int size, 
							    int shipNo, 
							    boolean multipleHit, 
							    boolean visible)
	{
		System.out.println("The game will use the grid size defined in the setting file.");
		System.out.println("Playing grid size set as (" + size + " X " + size + ")");
		System.out.println("Maximum number of ships allowed as " + shipNo);
		if (multipleHit)
			System.out.println("Multiple hits allowed per ships: ON");
		else
			System.out.println("Multiple hits allowed per ships: OFF");
		if (visible)
			System.out.println("Computer ships visible: ON");
		else
			System.out.println("Computer ships visible: OFF");
	}
	
	/**
	 * This method display the welcome message
	 */
	private void displayWelcome() 
	{
		System.out.println("\u000c+===============================================================================+");
		System.out.println("|                                                                               |");
		System.out.println("|                Welcom to the Battleship Game -- With a Twist!!                |");
		System.out.println("|                                                                               |");
		System.out.println("+===============================================================================+");
	}
	
	/**
	 * This method start the battle
	 * @param (ArrayList<String>)mapP1
	 * @param (ArrayList<String>)mapCom
	 * @param (int)size
	 * @param (boolean)visible
	 */
	private void fight(ArrayList<String> mapP1, 
					   ArrayList<String> mapCom,
					   int size,
					   boolean visible)
	{
		System.out.println("\fLet the bettle begin!!!");
		this.toContinue();
		int scoreP1 = 0;
		int scoreCom = 0;
		for (int index = 1; index != 0; index++)
		{
			System.out.println("Beginning Round " + index);
			System.out.println("Player Score: " + scoreP1);
			System.out.println("Computer Score: " + scoreCom);
			if (!visible)
				System.out.println("ENEMY SHIPS ONLY SHOWN WHEN DEMO MODE IS ON!!!");
			this.displayGrid(mapP1, mapCom, size, visible);
			boolean hitCom = this.playerAct(mapCom, size);
			boolean hitP1 = this.computerAct(mapP1, size);
			if (hitCom)
				scoreP1 += 10;
			if (hitP1)
				scoreCom += 10;
			this.toContinue();
			this.gameOver(scoreP1, scoreCom);
		}
	}
	
	/**
	 * This method check whether the game will end
	 * @param (int)scoreP1
	 * @param (int)scoreCom
	 */
	private void gameOver(int scoreP1,
						 int scoreCom)
	{
		if (playerShips.checkNoOfShips() == 0 ||
			computerShips.checkNoOfShips() == 0)
		{
			System.out.println("\f");
			System.out.println("GAME OVER" + "\n");
			String winner = this.whoWin();
			try 
			{
				FileIO writer = new FileIO("gameoutcome.txt");
				writer.output(winner, scoreP1, scoreCom);
			} 
			catch (Exception e) 
			{
				e.getMessage();
			}
			System.out.println("Player Score: " + scoreP1);
			System.out.println("Computer Score: " + scoreCom);
			this.toContinue("exit");
			System.exit(0);
		}
	}
	
	/**
	 * This method get computerShips
	 * @return the computerShips
	 */
	public ShipList getComputerShips() 
	{
		return computerShips;
	}
	
	/**
	 * This method get playerShips
	 * @return the playerShips
	 */
	public ShipList getPlayerShips() 
	{
		return playerShips;
	}
	
	/**
	 * This method set the grid with "~"
	 * @param (ArrayList<String>)mapP1
	 * @param (ArrayList<String>)mapCom
	 * @param (int)size
	 */
	private void initializeMap(ArrayList<String> mapP1, 
							   ArrayList<String> mapCom,
							   int size)
	{
		for (int index = 0; index < size * size; index++)
		{
			mapP1.add("~");
			mapCom.add("~");
		}
	}
	
	/**
	 * This method start the game
	 */
	public void play()
	{
		this.displayWelcome();
		String[] setting = readSetting();
		this.checkSetting(setting);
		int size = Integer.valueOf(setting[0].trim());
		boolean multipleHit = Boolean.valueOf(setting[1].trim());
		boolean visible = Boolean.valueOf(setting[2].trim());
		int noOfShips = Integer.valueOf(setting[3].trim());
		ArrayList<String> mapP1 = new ArrayList<>();
		ArrayList<String> mapCom = new ArrayList<>();
		this.displaySetting(size, noOfShips, multipleHit, visible);
		noOfShips = this.checkNoOfShips(noOfShips, size);
		this.toContinue();
		this.setupP1(size, noOfShips, multipleHit);
		this.setupCom(size, noOfShips, multipleHit);
		this.initializeMap(mapP1, mapCom, size);
		this.addShipToMap(mapP1, playerShips, size);
		this.addShipToMap(mapCom, computerShips, size);
		this.fight(mapP1, mapCom, size, visible);
	}
	
	/**
	 * This method let user attack the computer
	 * @param (ArrayList<String>) mapCom
	 * @param (int)size
	 * @return (boolean)true/false
	 */
	private boolean playerAct(ArrayList<String> mapCom,
							  int size)
	{
		System.out.println("\nPlayer to make a guess");
		int x = Input.inputInt("Ship x Position (0 - " + (size - 1) + "):");
		x = Validation.inRange(0, size - 1, x);
		int y = Input.inputInt("Ship y Position (0 - " + (size - 1) + "):");
		y = Validation.inRange(0, size - 1, y);
		if (mapCom.get(x + y * size).equals("0") ||
			mapCom.get(x + y * size).equals("D"))
		{
			System.out.println("PLAYER HITTTTT!!!!");
			for (int index = 0; index < computerShips.getLength(); index++)
			{
				if (computerShips.getShip(index).getXPos() == x &&
					computerShips.getShip(index).getYPos() == y )
				{
					computerShips.getShip(index).addNoOfHitsMade();
					if (computerShips.getShip(index).getNoOfHitsMade() == computerShips.getShip(index).getNoOfHitsNeeded())
					{
						mapCom.set(x + y * size, "X");
						System.out.println("Unfortunately, Computer Ship " + (index + 1) + " has been destroyed!");
					}
					else
						mapCom.set(x + y * size, "D");
					break;
				}
			}
			return true;
		}
		else
		{
			System.out.println("PLAYER MISSSSSS!!!!");
			return false;
		}
	}
	
	/**
	 * This method read the setting from file
	 * @return (String[])reader.input()
	 */
	private String[] readSetting() 
	{
		try
		{
			FileIO reader = new FileIO("gamesettings.txt");
			return reader.input();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println("Press Enter to exit");
			new Scanner(System.in).nextLine();
			System.out.println('\u000C');
			System.exit(0);
			return null;
		}
	}
	
	/**
	 * This method set the value of computerShips
	 * @param (ShipList)computerShips
	 */
	public void setComputerShips(ShipList computerShips) 
	{
		this.computerShips = computerShips;
	}
	
	/**
	 * This method set the name of ships
	 * @param (int)index
	 */
	private void setPlayerName(int index)
	{
		playerShips.getShip(index).setShipName(Input.input("Ship Name:"));
		for (int num = 0; num + 1 < playerShips.getLength(); num++)
		{
			if (playerShips.getShip(index).getShipName().trim().equals(playerShips.getShip(num).getShipName().trim()))
			{
				playerShips.getShip(index).setShipName(Input.input("You cannot use same name, please enter a new name:"));
				num = -1;
			}
		}
	}

	/**
	 * This method set the position of ships
	 * @param (int)index
	 * @param (int)size
	 */
	private void setPlayerPos(int index,
							  int size)
	{
		playerShips.getShip(index).setXPos(Input.inputInt("Ship x Position (0 - " + (size - 1) + "):"), size);
		playerShips.getShip(index).setYPos(Input.inputInt("Ship y Position (0 - " + (size - 1) + "):"), size);
		for (int num = 0; num + 1 < playerShips.getLength(); num++)
		{
			if (playerShips.getShip(index).getXPos() == playerShips.getShip(num).getXPos() &&
				playerShips.getShip(index).getYPos() == playerShips.getShip(num).getYPos())
			{
				System.out.println("Your ships position cannot be same, pleas choose other position");
				playerShips.getShip(index).setXPos(Input.inputInt("Ship x Position (0 - " + (size - 1) + "):"), size);
				playerShips.getShip(index).setYPos(Input.inputInt("Ship y Position (0 - " + (size - 1) + "):"), size);
				num = -1;
			}
		}
	}
	
	/**
	 * This method set the value of playerShips
	 * @param (ShipList)playerShips
	 */
	public void setPlayerShips(ShipList playerShips) 
	{
		this.playerShips = playerShips;
	}
	
	/**
	 * This method setup computer ships
	 * @param (int)size
	 * @param (int)noOfShips
	 * @param (boolean)multipleHit
	 */
	private void setupCom(int size, 
						  int noOfShips,
						  boolean multipleHit) 
	{
		for (int index = 0; index < noOfShips; index++)
		{
			int randomX = CoordinateGenerator.creatRandomNumber(0, size - 1);
			int randomY = CoordinateGenerator.creatRandomNumber(0, size - 1);
			for (int number = 0; number < index; number++)
			{
				if (computerShips.getShip(number).getXPos() == randomX &&
					computerShips.getShip(number).getYPos() == randomY)
				{
					randomX = CoordinateGenerator.creatRandomNumber(0, size - 1);
					randomY = CoordinateGenerator.creatRandomNumber(0, size - 1);
					number = -1;
				}
			}
			int strength;
			if (multipleHit)
				strength = CoordinateGenerator.creatRandomNumber(1, 5);
			else
				strength = 1;
			computerShips.addShip("Computer Ship " + (index + 1), randomX, randomY, 0, strength);
		}
	}

	/**
	 * This method setup player ships
	 * @param (int)size
	 * @param (int)noOfShips
	 * @param (boolean)multipleHit
	 */
	private void setupP1(int size, 
					     int noOfShips,
					     boolean multipleHit) 
	{
		System.out.println("Loading player settings:");
		for (int index = 0; index < noOfShips; index++)
		{
			System.out.println("Please enter the details for the " + (index + 1) + " ship:");
			playerShips.addShip();
			this.setPlayerName(index);
			this.setPlayerPos(index, size);
			if (multipleHit)
				playerShips.getShip(index).setNoOfHitsNeeded();
			else
				playerShips.getShip(index).setNoOfHitsNeeded(1);
			System.out.println("\nSet successfully!" + "\n" + "\n" + "Ship " + (index + 1) + " details:");
			playerShips.getShip(index).display();
			this.toContinue();
		}
	}

	/**
	 * This method continue the program
	 */
	private void toContinue()
	{
		System.out.println("Press Enter to continue");
		new Scanner(System.in).nextLine();
		System.out.println('\u000C');
	}

	/**
	 * This method continue the program
	 * @param (String)text
	 */
	private void toContinue(String text)
	{
		System.out.println("Press Enter to " + text);
		new Scanner(System.in).nextLine();
		System.out.println('\u000C');
	}
	
	/**
	 * This method check who is winner
	 * @return (String)winner
	 */
	private String whoWin()
	{
		if (computerShips.checkNoOfShips() == 0)
		{
			System.out.println("Congratulation!!! Player Wins!!!");
			return "Player";
		}
		else
		{
			System.out.println("Congratulation!!! Player Loses!!!");
			return "Computer";
		}
	}
}
