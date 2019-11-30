package ass2;

import java.util.Scanner;


public class Input {
	/**
	 * This is a default constructor
	 */
	public Input() {
		
	}

	public static void toContinue() {
		Scanner sc = new Scanner(System.in);
		System.out.println("press enter to continue");
		sc.nextLine();
	}

	/**
	 * This method return the user input as integer
	 * 
	 * @return (int)input
	 */
	public static int inputInt() {
		Scanner sc = new Scanner(System.in);
		while (!(sc.hasNextInt())) {
			System.out.println("Please enter an integer:");
			sc = new Scanner(System.in);
		}
		int input = sc.nextInt();
		return input;
	}

	/**
	 * This method display message and return the user input as integer
	 * 
	 * @param (String)text
	 * @return (int)input
	 */
	public static int inputInt(String text) {
		Scanner sc = new Scanner(System.in);
		System.out.println(text);
		while (!(sc.hasNextInt())) {
			System.out.println("Please enter an integer:");
			sc = new Scanner(System.in);
		}
		int input = sc.nextInt();
		return input;
	}
}
