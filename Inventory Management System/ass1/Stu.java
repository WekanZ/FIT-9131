package ass1;

import java.util.Random;
import java.util.Scanner;
public class Stu {

	public static void main(String[] args)
	{
		Products product = new Product();
		product.displayProduct();
	}
	public static int inputI()
	{
		Scanner sc = new Scanner(System.in);
		while (!(sc.hasNextInt()))
		{
			System.out.println("Please press 1 to 7:");
			sc = new Scanner(System.in);		
		}
		int input = sc.nextInt();			
		return input;
	}
	
	public static int inputI(String text)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		while (!(sc.hasNextInt()))
		{
			System.out.println("Please press 1 to 7:");
			sc = new Scanner(System.in);		
		}
		int input = sc.nextInt();			
		return input;
	}
	
}
