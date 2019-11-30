package ass2;

public class Venue {
	private String venueName;
	private int noOfLaps;
	private int averageLapTime;
	private double chanceOfRain;
	
	public Venue() {
		
	}
	
	/**
	 * @param venueName
	 * @param noOfLaps
	 * @param averageLapTime
	 * @param chanceOfRain
	 */
	public Venue(String venueName, int noOfLaps, int averageLapTime, double chanceOfRain) {
		this.venueName = venueName;
		this.noOfLaps = noOfLaps;
		this.averageLapTime = averageLapTime;
		this.chanceOfRain = chanceOfRain;
	}

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public int getNoOfLaps() {
		return noOfLaps;
	}

	public void setNoOfLaps(int noOfLaps) {
		this.noOfLaps = noOfLaps;
	}

	public int getAverageLapTime() {
		return averageLapTime;
	}

	public void setAverageLapTime(int averageLapTime) {
		this.averageLapTime = averageLapTime;
	}

	public double getChanceOfRain() {
		return chanceOfRain;
	}

	public void setChanceOfRain(double chanceOfRain) {
		this.chanceOfRain = chanceOfRain;
	}
	
}
