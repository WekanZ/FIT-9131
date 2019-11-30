package ass2;

import java.util.Random;

public class RNG {
	private int minimumValue;
	private int maximumValue;
	
	public RNG() {
		
	}
	
	/**
	 * @param minimumValue
	 * @param maximumValue
	 */
	public RNG(int minimumValue, int maximumValue) {
		this.minimumValue = minimumValue;
		this.maximumValue = maximumValue;
	}

	public int getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(int minimumValue) {
		this.minimumValue = minimumValue;
	}

	public int getMaximumValue() {
		return maximumValue;
	}

	public void setMaximumValue(int maximumValue) {
		this.maximumValue = maximumValue;
	}
	
	public static int createInt(int m, int n) {
		Random ran = new Random();
		return ran.nextInt(m - n + 1) + n;
	}
	
	public static double creatDouble() {
		return Math.random();
	}
}
