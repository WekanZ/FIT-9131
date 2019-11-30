
/**
 * Tile class to store the value and the score for each tile
 *
 * 
 * @8 Sep 2019 
 */
public class Tile
{ private int value;
  private int score;
  
  /**
   * Default constructor for objects of Tile class 
   */
  public Tile()
  { 
    value = 0;
    score = 0;
  }
   
  /**
     * Non Default Constructor for objects of Tile class
     * 
     * @param newValue int to define the new value of tiles
     * @param newScore int to define the new score of tiles 
     */ 
    public Tile(int newValue, int newScore)
  { 
    	value = newValue;
    	score = newScore;
  }
  
  //Accessor method to get the score 
  public int getScore()
  { 
      return score;
  }
  
  //Mutator method to set score 
  public void setScore(int newScore)
  { 
      score = newScore;
  }
  
  //Accessor method to get the value
  public int getValue()
  {
    return value;
  } 
  
  //Mutator method to set value
  public void setValue(int newValue)
  {
    value = newValue;
  }
 }