
/**
 * RNG class to generate a random number 
 *
 * 
 * @8 Sep 2019 
 */
public class RNG
{
    // Declaration of fields
    private int maximumValue;
    private int minimumValue;
    
    /**
     * Default Constructor for objects of class RNG
     */
    public RNG()
    {
      maximumValue = 0;
      minimumValue = 0;
    }
    

    /**
     * Non Default Constructor for objects of class RNG
     * 
     * @param newMaximumValue int to define the new maximum number generated 
     * @param newMinimumValue int to define the new minimum number generated 
     */ 
    public RNG(int newMaximumValue, int newMinimumValue)
    { 
      maximumValue = newMaximumValue;
      minimumValue = newMinimumValue;
    }
    
    //Accessor method to get maximum value 
    /**
     * Accessor Method to get the maximum number generated 
     * 
     * @return A single int which contains the maximum number generated 
     */
    public int getMaximumValue()
    { 
      return maximumValue;
    }
    

    /**
     * Accessor Method to get the minimum number generated 
     * 
     * @return A single int which contains the minimum number generated 
     */
    public int getMinimumValue()
    { 
      return minimumValue;
    }
    

    /**
     * Mutator Method to set the maximum number generated 
     * 
     * @param newScore int to define the new maximum number generated 
     */
    public void setMaximumValue(int newMaximumValue)
    { 
      maximumValue = newMaximumValue;
    }
    

    /**
     * Mutator Method to set the minimum number generated 
     * 
     * @param newScore int to define the new minimum number generated 
     */
    public void setMinimumValue(int newMinimumValue)
    {
      minimumValue = newMinimumValue;
    }


    /**
     * Method to generate a random number 
     * 
     * @param newMaximumValue int to define the new maximum number generated 
     * @param newMinimumValue int to define the new minimum number generated  
     */
    public int generateRN(int maximumValue, int minimumValue)
    {
      int number = ((int)(Math.random() * (maximumValue - minimumValue + 1)) + minimumValue);
      return number;
    }
}
