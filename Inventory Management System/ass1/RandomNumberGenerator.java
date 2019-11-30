package ass1;
/**
 * @author  Weikan Zhou
 * @version 3.7
 */
import java.util.Random;
public class RandomNumberGenerator {
	private int minmumValue;
	private int maximumValue;

	public RandomNumberGenerator() 
	{
		this.minmumValue = 0;
		this.maximumValue = 0;
	}
	
	public RandomNumberGenerator(int minmumValue, 
									int maximumValue) 
	{
		this.minmumValue = minmumValue;
		this.maximumValue = maximumValue;
	}

	public void displayRandomNumberGenerator()
	{
		System.out.println("Minmum value: " + getMinmumValue() + "Maximum value: " + getMaximumValue());
	}

	public int getMaximumValue() 
	{
		return maximumValue;
	}
	
	public int getMinmumValue() 
	{
		return minmumValue;
	}
	
	public int randomNum(int min, 
							int max)
	{
		Random random = new Random();
		int r = min + random.nextInt(max - min);
		return r;
	}

	public void setMaximumValue(int maximumValue) 
	{
		this.maximumValue = maximumValue;
	}
	
	public void setMinmumValue(int minmumValue)
	{
		this.minmumValue = minmumValue;
	}
}
