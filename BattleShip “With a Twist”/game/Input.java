import java.util.Scanner;

/**
 * This class receives input from user
 * @author Weikan
 * @version 4.4
 */
public class Input 
{
	/**
	 * This is a default constructor
	 */
	public Input()
	{
	}
	
	/**
	 * This method return the user input as String
	 * @return (String)input
	 */
	public static String input()
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}
	
	/**
	 * This method display message and return the user input as String
	 * @param (String)text
	 * @return (String)input
	 */
	public static String input(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		String input = sc.nextLine();
		return input;
	}

	/**
	 * This method return the user input as double
	 * @return (double)input
	 */
	public static double inputDouble()
	{
		Scanner sc = new Scanner(System.in);
		while (!(sc.hasNextDouble()))
		{
			System.out.println("Please enter a number:");
			sc = new Scanner(System.in);		
		}
		double input = sc.nextDouble();			
		return input;
	}
	
	/**
	 * This method display message and return the user input as double
	 * @param (String)text
	 * @return (double)input
	 */
	public static double inputDouble(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		while (!(sc.hasNextDouble()))
		{
			System.out.println("Please enter a number:");
			sc = new Scanner(System.in);		
		}
		double input = sc.nextDouble();			
		return input;
	}
	
	/**
	 * This method return the user input as integer
	 * @return (int)input
	 */
	public static int inputInt()
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
	 * @param (String)text
	 * @return (int)input
	 */
	public static int inputInt(String text)
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
}
