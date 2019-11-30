

import java.util.*;
/**
 * Player Class which stores player details for the game
 *
 * 
 * @8 Sep 2019
 */

public class Player
{  
    //Declare class fileds 
    private String name;
    private int score;
    private Tile[] tile;
    private Tile lastTilePlayed;
    private int roundsWon;


    /**
     * Default Constructor for objects of class Player
     */
    public Player()
    {
        name = "";
        score = 0;
        tile = new Tile[5];
        this.addTile();
        lastTilePlayed = null;
        roundsWon = 0;
    }
 
    /**
     * Non Default Constructor for objects of class Player
     * 
     * @param newName String to define the new name for the players
     * @param newScore int to define the new score of the players
     * @param newTile Array to define the objects in Tile for the players
     * @param newLastTilePlayed Array to define the last tile played by the players
     * @param newRoundsWon int to define the number of rounds each player has won
     */
    public Player(String newName, int newScore, Tile[] newtile, Tile newLastTilePlayed, int newRoundsWon)
    { name = newName;
        score = 0;
        tile = new Tile[5];
        lastTilePlayed = newLastTilePlayed;
        roundsWon = newRoundsWon;
    }

    public void addTile()
    {
        tile[0] = new Tile(1,5);
        tile[1] = new Tile(2,4);
        tile[2] = new Tile(3,3);
        tile[3] = new Tile(5,2);
        tile[4] = new Tile(7,1);
    }

    public void display()
    {
    	System.out.print("{ ");
    	for(int i = 0; i < 5; i++) 
    	{
    		if (tile[i] != null)
    		{
    			System.out.print(tile[i].getValue());
    			System.out.print(" ");
    		}
    	}
    	System.out.println("}");
    }
    
    /**
     * Accessor Method to get the score of the player
     * 
     * @return A single int which contains the score of the player
     */
    public int getScore()
    {
        return score;
    }

    /**
     * Mutator Method to set the score of the players 
     * 
     * @param newScore int to define the new score of the players
     */
    public void setScore(int newScore)
    {
        score = newScore;
    }

    /**
     * Accessor Method to get the name of the player
     * 
     * @return A single string which contains the name of the player
     */
    public String getName()
    {
        return name;
    }

    /**
     * Mutator Method to set the name of the players
     * 
     * @param newName String to define the new name of the players
     */
    public void setName(String newName)
    {
        name = newName;
    }

    //Accessor method to get tile 
    /**
     * Accessor Method to get the tile choosed by the player
     * 
     * @return A single object in the Array  which contains the tile chosen by the player
     */
    public Tile[] getTile()
    { 
        return tile;
    }

    /**
     * Mutator Method to set the tile for the player 
     * 
     * @param newTile Array to define the new tile for the players 
     */
    public void setTile(Tile[] newTile)
    { 
        tile = newTile;
    }

    /**
     * Accessor Method to get the number of rounds won by the player
     * 
     * @return A single int which contains the number of rounds won by the player
     */
    public int getRoundsWon()
    { 
        return roundsWon;
    }

    /**
     * Mutator Method to set the rounds won by the player
     * 
     * @param newRoundsWon int to define the new number of rounds won by the player
     */
    public void setRoundsWon(int newRoundsWon)
    { 
        roundsWon = newRoundsWon;
    }

    /**
     * Accessor Method to get the last tile played by the player
     * 
     * @return A single Array which contains the last tile played by the player
     */
    public Tile getLastTilePlayed()
    {
        return lastTilePlayed;
    }

    /**
     * Mutator Method to set the last tile played by the player
     * 
     * @param newLastTilePlayed Array to define the new last tile played by the player
     */
    public void setLastTilePlayed(Tile newLastTilePlayed)
    {
        lastTilePlayed = newLastTilePlayed;
    }

    public int getHumanInput()
    {
        Scanner console = new Scanner(System.in);
        int humanInput = console.nextInt();
        return humanInput;
    }
}
