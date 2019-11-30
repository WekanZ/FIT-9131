import java.util.Random;

/**
 * This class contains methods about random number.
 * @author Weikan
 * @version 4.4
 */
public class CoordinateGenerator 
{
	private int minimumValue;
	private int maximumValue;
	
	/**
	 * This is a default constructor
	 */
	public CoordinateGenerator()
	{
		this.minimumValue = 0;
		this.maximumValue = 0;
	}
	
	/**
	 * This is a non-default constructor
	 * @param (int)minimumValue
	 * @param (int)maximumValue
	 */
	public CoordinateGenerator(int minimumValue, 
							   int maximumValue) 
	{
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
	}

	/**
	 * This method generate a random number between min and max
	 * @param (int)min
	 * @param (int)max
	 * @return (int)randomNumber
	 */
	public static int creatRandomNumber(int min, 
								 		int max)
	{
		Random random = new Random();
		int randomNumber = min + random.nextInt(max - min + 1);
		return randomNumber;
	}
	
	/**
	 * This method get maximumValue
	 * @return (int)maximumValue
	 */
	public int getMaximumValue() 
	{
		return maximumValue;
	}

	/**
	 * This method get minimumValue
	 * @return (int)minimumValue
	 */
	public int getMinimumValue() 
	{
		return minimumValue;
	}

	/**
	 * This method set maximumValue
	 * @param (int)maximumValue
	 */
	public void setMaximumValue(int maximumValue) 
	{
		this.maximumValue = maximumValue;
	}

	/**
	 * This method set minimumValue
	 * @param (int)minimumValue
	 */
	public void setMinimumValue(int minimumValue) 
	{
		this.minimumValue = minimumValue;
	}
}
