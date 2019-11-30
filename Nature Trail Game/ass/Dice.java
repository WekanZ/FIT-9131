package ass;

import java.util.Random;

public class Dice {
	// instance variables - replace the example below with your own
	private int maximumValue;
	private int minimumValue;

	/**
	 * Constructor for objects of class Dice
	 */
	public Dice() {
		maximumValue = 4;
		minimumValue = 1;
	}

	public Dice(int maximumValue, int minimumValue) {
		this.maximumValue = maximumValue;
		this.minimumValue = minimumValue;
	}

	public int generateDiceNumber() {
		Random randomDice;
		randomDice = new Random();
		int diceNumber = randomDice.nextInt() + 1; // [0,n)
		return diceNumber;
	}
	
	public int generateDiceNumber(int max, int min) {
		Random randomDice;
		randomDice = new Random();
		int diceNumber = randomDice.nextInt(max - min + 1) + min; // [0,n)
		return diceNumber;
	}

	public int getMaximumValue() {
		return maximumValue;
	}

	public int getMinimumValue() {
		return minimumValue;
	}

	public void setMaximumValue() {
		this.maximumValue = maximumValue;
	}

	public void setMinimumValue() {
		this.minimumValue = minimumValue;
	}

}
