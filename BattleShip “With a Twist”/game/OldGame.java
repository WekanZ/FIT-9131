import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Weikan
 * @version 3.4
 */
public class OldGame 
{
	private ShipList playerShips;
	private ShipList computerShips;
	
	/**
	 * This is a default constructor
	 */
	public OldGame()
	{
		this.playerShips = new ShipList();
		this.computerShips = new ShipList();
	}
	
	/**
	 * This is a non-default constructor
	 * @param (ShipList)playerShips
	 * @param (ShipList)computerShips
	 */
	public OldGame(ShipList playerShips, 
				ShipList computerShips)
	{
		this.playerShips = playerShips;
		this.computerShips = computerShips;
	}

	/**
	 * This method replace the "~" to "0" in the map
	 * @param (String[][])map
	 * @param (ShipList)ships
	 */
	private void addShipToMap(String[][] map, 
							  ShipList ships)
	{
		for (int index = 0; index < playerShips.getLength(); index++)
			map[ships.getShip(index).getXPos()][ships.getShip(index).getYPos()] = "0";
	}
	
	/**
	 * This method decide the HP of ships depending on setting
	 * @param (boolean)multipleHit
	 */
	private void adjustState(boolean multipleHit)
	{
		if (!multipleHit)
		{
			for(int index = 0; index < playerShips.getLength(); index++)
			{
				playerShips.getShip(index).setNoOfHitsNeeded(1);
				computerShips.getShip(index).setNoOfHitsNeeded(1);
			}
		}
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
//			System.out.println("\nUnfortunately, there is not enough room to put ships!");
//			System.out.println("Please change the setting and start again!");
//			this.toContinue();
//			System.exit(0);
		}
		return noOfShips;
	}
	
	/**
	 * This method check the validation of the setting file
	 * @param (ArrayList<String>)setting
	 */
	private void checkSetting(ArrayList<String> setting)
	{
		try 
		{
			int size = Integer.valueOf(setting.get(0).trim());
			boolean multipleHit = Boolean.valueOf(setting.get(1).trim());
			boolean visible = Boolean.valueOf(setting.get(2).trim());
			int noOfShips = Integer.valueOf(setting.get(3).trim());
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
	 * @param (String[][])mapP1
	 * @return (boolean)true/false
	 */
	private boolean computerAct(String[][] mapP1)
	{
		System.out.println("\nComputer to make a guess");
		int x = CoordinateGenerator.creatRandomNumber(0, mapP1.length - 1);
		System.out.println("Computer x guess:" + x);
		int y = CoordinateGenerator.creatRandomNumber(0, mapP1.length - 1);
		System.out.println("Computer y guess:" + y);
		if (mapP1[x][y] == "0" ||
			mapP1[x][y] == "D")
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
						mapP1[x][y] = "X";
						System.out.println("Unfortunately, Player Ship " + playerShips.getShip(index).getShipName() + " has been destroyed!");
					}
					else
						mapP1[x][y] = "D";
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
	 * @param (String[][])mapP1
	 * @param (String[][])mapCom
	 * @param (boolean)visible
	 */
	private void displayGrid(String[][] mapP1, 
							String[][] mapCom,
							boolean visible)
	{
		System.out.println("Player Grid");
		this.displayMap(mapP1);
		System.out.println("----------------------------");
		System.out.println("Computer Grid");
		this.displayMap(mapCom, visible);
	}
	
	/**
	 * This method display the grid in the screen
	 * @param (String[][])map
	 */
	private void displayMap(String[][] map)
	{
		for (int y = 0; y < map.length; y++)
		{
			for (int x = 0; x < map.length; x++)
				System.out.print(map[x][y]);
			System.out.print("\n");
		}
	}
	
	/**
	 * This method display the grid in the screen
	 * @param (String[][])map
	 * @param (boolean)visible
	 */
	private void displayMap(String[][] map,
						   boolean visible)
	{
		if (visible)
		{
			for (int y = 0; y < map.length; y++)
			{
				for (int x = 0; x < map.length; x++)
					System.out.print(map[x][y]);
				System.out.print("\n");
			}
		}
		else
		{
			for (int y = 0; y < map.length; y++)
			{
				for (int x = 0; x < map.length; x++)
				{
					if (map[x][y] == "0")
						System.out.print("~");
					else
						System.out.print(map[x][y]);
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
		System.out.println("Multiple hits allowed per ships set as " + multipleHit);
		if (visible)
			System.out.println("Computer ships visible: ON");
		else
			System.out.println("Computer ships visible: OFF");
	}
	
	/**
	 * This method display the welcome message
	 */
	public void displayWelcome() 
	{
		System.out.println("\f+===============================================================================+");
		System.out.println("|                                                                               |");
		System.out.println("|                Welcom to the Battleship Game -- With a Twist!!                |");
		System.out.println("|                                                                               |");
		System.out.println("+===============================================================================+");
	}
	
	/**
	 * This method start the battle
	 * @param (String[][])mapP1
	 * @param (String[][])mapCom
	 * @throws IOException 
	 */
	private void fight(String[][] mapP1, 
					   String[][] mapCom,
					   boolean visible) throws IOException
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
			this.displayGrid(mapP1, mapCom, visible);
			boolean hitCom = this.playerAct(mapCom);
			boolean hitP1 = this.computerAct(mapP1);
			if (hitCom)
				scoreP1 += 10;
			if (hitP1)
				scoreCom += 10;
			this.gameOver(scoreP1, scoreCom);
			this.toContinue();
		}
	}
	
	/**
	 * This method check whether the game will end
	 * @param (int)scoreP1
	 * @param (int)scoreCom
	 * @throws IOException
	 */
	public void gameOver(int scoreP1,
						 int scoreCom) throws IOException 
	{
		if (playerShips.checkNoOfShips() == 0 ||
			computerShips.checkNoOfShips() == 0)
			{
				System.out.println("\f");
				System.out.println("GAME OVER" + "\n");
				String winner = this.whoWin();
				OldFileIO.output(winner, scoreP1, scoreCom);
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
	 * @param (String[][])mapP1
	 * @param (String[][])mapCom
	 */
	private void initializeMap(String[][] mapP1, 
							  String[][] mapCom)
	{
		for (int x = 0; x < mapP1.length; x++)
		{
			for (int y = 0; y < mapP1.length; y++)
			{
				mapP1[x][y] = "~";
				mapCom[x][y] = "~";
			}
		}
	}
	
	/**
	 * This method start the game
	 * @throws IOException
	 */
	public void play() throws IOException 
	{
		this.displayWelcome();
		ArrayList<String> setting = OldFileIO.input();
		this.checkSetting(setting);
		int size = Integer.valueOf(setting.get(0).trim());
		boolean multipleHit = Boolean.valueOf(setting.get(1).trim());
		boolean visible = Boolean.valueOf(setting.get(2).trim());
		int noOfShips = Integer.valueOf(setting.get(3).trim());
		String mapP1[][] = new String[size][size];
		String mapCom[][] = new String[size][size];
		this.displaySetting(size, noOfShips, multipleHit, visible);
		noOfShips = this.checkNoOfShips(noOfShips, size);
		this.toContinue();
		this.setupP1(size, noOfShips);
		this.setupCom(size, noOfShips);
		this.initializeMap(mapP1, mapCom);
		this.addShipToMap(mapP1, playerShips);
		this.addShipToMap(mapCom, computerShips);
		this.adjustState(multipleHit);
		this.fight(mapP1, mapCom, visible);
	}
	
	/**
	 * This method
	 * @param mapCom
	 * @return
	 */
	private boolean playerAct(String[][] mapCom)
	{
		System.out.println("\nPlayer to make a guess");
		int x = Input.inputInt("Ship x Position (0 - " + (mapCom.length - 1) + "):");
		x = Validation.inRange(0, mapCom.length - 1, x);
		int y = Input.inputInt("Ship y Position (0 - " + (mapCom.length - 1) + "):");
		y = Validation.inRange(0, mapCom.length - 1, y);
		if (mapCom[x][y] == "0" ||
			mapCom[x][y] == "D")
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
						mapCom[x][y] = "X";
						System.out.println("Unfortunately, Computer Ship " + (index + 1) + " has been destroyed!");
					}
					else
						mapCom[x][y] = "D";
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
	 * This method
	 * @param computerShips the computerShips to set
	 */
	public void setComputerShips(ShipList computerShips) 
	{
		this.computerShips = computerShips;
	}
	
	/**
	 * This method
	 * @param playerShips
	 */
	public void setPlayerShips(ShipList playerShips) 
	{
		this.playerShips = playerShips;
	}
	
	/**
	 * This method
	 * @param size
	 * @param noOfShips
	 */
	private void setupCom(int size, 
						 int noOfShips) 
	{
		for (int index = 0; index < noOfShips; index++)
		{
			int randomX = CoordinateGenerator.creatRandomNumber(0, size - 1);
			int randomY = CoordinateGenerator.creatRandomNumber(0, size - 1);
			int randomStrength = CoordinateGenerator.creatRandomNumber(1, 5);
			computerShips.addShip("Computer Ship " + index, randomX, randomY, 0, randomStrength);
		}
	}

	/**
	 * This method
	 * @param size
	 * @param noOfShips
	 */
	private void setupP1(int size, 
					    int noOfShips) 
	{
		System.out.println("Loading player settings:");
		for (int index = 0; index < noOfShips; index++)
		{
			System.out.println("Please enter the details for the " + (index + 1) + " ship:");
			playerShips.addShip();
			playerShips.getShip(index).setShipName(Input.input("Ship Name:"));
			for (int num = 0; num + 1 < playerShips.getLength(); num++)
			{
				if (playerShips.getShip(index).getShipName().equals(playerShips.getShip(num).getShipName()))
				{
					playerShips.getShip(index).setShipName(Input.input("You cannot use same name, please enter a new name:"));
					num = -1;
				}
			}
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
			playerShips.getShip(index).setNoOfHitsNeeded();
			System.out.println("\nSet successfully!" + "\n" + "\n" + "Ship " + (index + 1) + " details:");
			playerShips.getShip(index).display();
			this.toContinue();
		}
	}

	/**
	 * This method
	 */
	private void toContinue()
	{
		System.out.println("Press Enter to continue");
		Scanner input = new Scanner(System.in);
		input.nextLine();
		System.out.println('\u000C');
	}

	/**
	 * This method
	 * @param exit
	 */
	private void toContinue(String exit)
	{
		System.out.println("Press Enter to " + exit);
		Scanner input = new Scanner(System.in);
		input.nextLine();
		System.out.println('\u000C');
	}
	
	/**
	 * This method check who is winner
	 * @param (int)scoreP1
	 * @param (int)scoreCom
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
