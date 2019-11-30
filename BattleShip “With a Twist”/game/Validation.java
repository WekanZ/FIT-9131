import java.util.Scanner;

/**
 * This class check the validation of value
 * @author Weikan
 * @version 4.4
 */
public class Validation 
{
	/**
	 * This is a default constructor
	 */
	public Validation()
	{
	}
	
	/**
	 * This method check the range of value
	 * @param (int)min
	 * @param (int)max
	 * @param (int)input
	 * @return (int)input
	 */
	public static int inRange(int min, 
							  int max, 
							  int input)
	{
		while (input < min ||
			   input > max)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a number between " + min + " and " + max + " :");
			while (!(sc.hasNextInt()))
			{
				System.out.println("Please enter an integer:");
				sc = new Scanner(System.in);		
			}
			input = sc.nextInt();
		}
		return input;
	}
	
	/**
	 * This method check if text is blank
	 * @param (String)text
	 * @return (boolean)true/false
	 */
	public static boolean isBlank(String text)
	{
		return text.trim().length() == 0;
	}
	
	/**
	 * @param (String)num
	 * @return (boolean)true/false
	 */
	private static boolean isInteger(String num) 
	{
		try 
		{
			Integer.valueOf(num);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
