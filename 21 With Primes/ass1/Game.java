
import java.util.Scanner;
/**
 * Write a description of class Game here.
 *
 *  
 * @9 Sep 2019 
 */
public class Game
{
	public static void main(String[] args) {
		Game game  = new Game();
		game.startSystem();
	}
    public void startSystem()
    { 
    	
        Player player1 = new Player();
        Player player2 = new Player();
        while (true)
        {
        	displayMainMenu();
        	int option = inputInt();
            while(!checkRange(option,1,4))
            {
            	System.out.print("enter number between 1 and 4");
            	option = inputInt();
            }
            
            switch(option)
            {
                case 1: 
                	playerRegistration(player1, player2); 
                	break;
                case 2: 
                	startGame(player1, player2); 
                	break;
                case 3: 
                	viewHelpMenu(player1, player2);
                	break;
                case 4: 
                	System.exit(0);
                default: 
                	System.out.println("choose a number between 1 and 4");
                	option = inputInt();
            }
        }

    }

    public void toContinue()
    {
    	Scanner console = new Scanner(System.in);
    	System.out.println("\nPress enter to continue");
    	console.nextLine();
    }
    
    public int inputInt() 
    {
    	Scanner console = new Scanner(System.in);
    	int num = 0;
    	while(!console.hasNextInt())
    	{
    		System.out.println("Please type a number!");
    		console = new Scanner(System.in);
    	}
    	num = console.nextInt();
    	return num;
    }
    
    public boolean checkRange(int num, int min, int max)
    {
    	boolean inRange = false;
    	if((num <= max) && (num >= min))
    	{
    		inRange = true;
    	}
    	return inRange;
    }
    
//    public int validNumber(int minimum, int maximum)
//    { 
//        Scanner console = new Scanner(System.in);
//        int number = console.nextInt();
//        while (number < minimum || number >maximum)
//        {
//            System.out.print("enter number between" + maximum + "and" + minimum );
//            number = console.nextInt();
//        }
//        return number;
//    }

    public void displayMainMenu()
    {
        System.out.println(" ");
        System.out.println("Please select the following options");
        System.out.println("Option 1: register for new game");
        System.out.println("Option 2: start a new game");
        System.out.println("Option 3: view help menu");
        System.out.println("Option 4: exit game");
    }

    public void playerRegistration(Player player1, Player player2)
    {   
        if(player1.getName().length() != 0)
        {
        	System.out.println("You have already registered, press 2 to start game!");
        }
        else
        {
        	System.out.println("pls enter your name here");
        	Scanner console =  new Scanner(System.in);
        	String playerName = console.nextLine();
        	while(playerName.length() > 10 || playerName.length() < 3) 
        	{ 
        		System.out.println("pls enter 3 to 10 charactors only");
        		playerName = console.nextLine();
        	}  
        	player1.setName(playerName);
        	System.out.println("You have successfully registered, your user name is " + player1.getName());
        	player2.setName("Computer");
        }
    }

    public void startGame(Player player1, Player player2)
    {
        if (player1.getName().isEmpty())
        {
            System.out.println("pls register your user name first");
        }
        else
        {
            System.out.println("pls enter the number of rounds you wish to play");
            int rounds = inputInt();
            while(!checkRange(rounds,1,9))
            {
            	System.out.print("enter number between 1 and 9");
            	rounds = inputInt();
            }
            for (int round = 1; round <= rounds; round++)
            { 
            	System.out.println("");
                if (round != 1)
                {
                	System.out.println("Next new round is start!");
                }
                startRound(player1, player2);
            } 
            displayResults(player1, player2);
        }
    }

    
    
    public void startRound(Player player1, Player player2)
    { 
        player1.addTile();
        player2.addTile();
        player1.setScore(0);
        player2.setScore(0);
        int gameTotal = 0;
        int round = 1;
        boolean humanFirst = true;
        while (gameTotal < 21)
        {
        	System.out.println("\nThis is round " + round);
            if (humanFirst == true)
            { 
                System.out.println("Human plays first!");
            	gameTotal = humanTurn(gameTotal,player1);
            	toContinue();
                if(gameTotal < 21)
                { 
                    gameTotal = computerTurn(gameTotal, player2);
                }
            }
            else
            {
            	System.out.println("Computer plays first!");
                gameTotal = computerTurn(gameTotal,player2);
                toContinue();
                if(gameTotal < 21)
                {
                    gameTotal = humanTurn(gameTotal, player1);
                }
            } 
            round++;
            toContinue();
        }
        
        displayRoundInfo(player1, player2);
    }

    public boolean humanFirst()
    {
        int r = new RNG().generateRN(2,1);
        if (r == 1)
        { 
        	System.out.println("human player goes first");
            return true;
        }
        else 
        { 
            System.out.println("Computer player goes first");
            return false;
        }
    }

    public void displayRoundInfo(Player player1, Player player2)
    {
        System.out.println(" ");
        System.out.println("Round over");
        System.out.println("Final score is shown bellow:");
        if(player1.getTile()[3] != null)
        {
            System.out.println("human player did not used the tile with the value of 5");
            player1.setScore(player1.getScore()- 3);
        }

        if(player2.getTile()[3] != null)
        {
            System.out.println("computer player did not used the tile with the value of 5");
            player2.setScore(player2.getScore() - 3);
        }
        System.out.println("Human player's score is " + player1.getScore());
        System.out.println("Computer player's score is " + player2.getScore());
        if (player1.getScore() > player2.getScore())
        {
            player1.setRoundsWon(player1.getRoundsWon() + 1);
            System.out.println("Human player wins this round, total score +5");
            player1.setScore(player1.getScore() + 5);
            System.out.println("Now human player's score is " + player1.getScore());
        }
        else if (player1.getScore() < player2.getScore())
        {
            player2.setRoundsWon(player2.getRoundsWon() + 1);
            System.out.println("Computer player wins this round, total score +5");
            player2.setScore(player2.getScore() + 5);
            System.out.println("Now computer player's score is " + player2.getScore());
        }
        else
        {
        	System.out.println("Tied");
        }
        System.out.println(" ");

    }

    public int humanTurn(int gameTotal,Player player1)
    { 
    	System.out.println ("pls select a tile from below");
        player1.display();
        int value = inputInt();
        while(!validTileChosen(value, player1))
        {
            System.out.println("Invalid tile chosen, pls choose a tile from list bellow");
            player1.display();
            value = inputInt();
        }
        int score = 0; 
        int currentPoint = gameTotal + value;
        if ( currentPoint <=21)
        {
            for (int i = 0; i<5; i++)
            {
                if(player1.getTile()[i] != null && player1.getTile()[i].getValue()==value)
                { 
                    score = player1.getTile()[i].getScore();
                    player1.getTile()[i] = null;
                }
            }
            player1.setScore(player1.getScore() + score);
        }
        System.out.println("Human player play tile " + value);
        System.out.println("Human got score of " + score);
        System.out.println("Now the total score of Human is " + player1.getScore());
        System.out.println("Now the game total is " + currentPoint);
        return currentPoint;
    }

    public int computerTurn(int gameTotal, Player player2)
    {
        System.out.println("Now compter choose a tile from below:");
        player2.display();
    	RNG r = new RNG(7, 1);
        int value = r.generateRN(7,1);
        while (!validTileChosen(value, player2))
        {
//            System.out.println("Computer chooses " + value);
//            System.out.println("Invalid tile chosen. Try again: ");
            value = r.generateRN(7,1);
        }
        int score = 0;
        int currentPoint = gameTotal + value;
        if (currentPoint <= 21)
        {
            for (int i = 0; i < 5; i++)
            {
                if (player2.getTile()[i] != null && player2.getTile()[i].getValue() == value)
                {
                    score = player2.getTile()[i].getScore();
                    player2.getTile()[i] = null;
                }
            }
            player2.setScore(player2.getScore() + score);
        }
        System.out.println("Computer player plays tile " + value );
        System.out.println("Computer got score of " + score);
        System.out.println("Computer total score is " + player2.getScore());
        System.out.println("Game Total now is " + currentPoint);
        return currentPoint;
    }

    public boolean validTileChosen(int value, Player player1)
    {
    	boolean valid = false;
        for (int i = 0; i < 5; i++)
        {
            if (player1.getTile()[i] != null && player1.getTile()[i].getValue() == value)
            {
                valid = true;
            }
        }
        return valid;
    }

    public void displayResults(Player player1, Player player2)
    {
        System.out.println("Human player wins " + player1.getRoundsWon() + " rounds");
        System.out.println("Computer player wins " + player2.getRoundsWon() + " rounds");
        if(player1.getRoundsWon() > player2.getRoundsWon())
        {
        	System.out.println("Human player finally wins!");
        }
        else if(player1.getRoundsWon() < player2.getRoundsWon())
        {
        	System.out.println("Computer player finally wins!");
        }
        else
        {
        	System.out.println("Tied!");
        }
    }

    public void viewHelpMenu(Player player1, Player player2)
    {
        System.out.println("");
        System.out.println("");

    }

    public void endGame()
    {
        System.exit(0);
    }
}
