package ass2;

import java.util.Random;

public class Driver {
	private String name;
	private int ranking;
	private String specialSkill;
	private boolean eligibleToRace;
	private int accumulatedScore;
	private int accumulatedTime;
	
	public Driver() {
		this.eligibleToRace = true;
	}
	
	/**
	 * @param name
	 * @param ranking
	 * @param specialSkill
	 * @param eligibleToRace
	 * @param accumulatedScore
	 * @param accumulatedTime
	 */
	public Driver(String name, int ranking, String specialSkill, boolean eligibleToRace, int accumulatedScore,
			int accumulatedTime) {
		this.name = name;
		this.ranking = ranking;
		this.specialSkill = specialSkill;
		this.eligibleToRace = eligibleToRace;
		this.accumulatedScore = accumulatedScore;
		this.accumulatedTime = accumulatedTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getSpecialSkill() {
		return specialSkill;
	}

	public void setSpecialSkill(String specialSkill) {
		this.specialSkill = specialSkill;
	}

	public boolean isEligibleToRace() {
		return eligibleToRace;
	}

	public void setEligibleToRace(boolean eligibleToRace) {
		this.eligibleToRace = eligibleToRace;
	}

	public int getAccumulatedScore() {
		return accumulatedScore;
	}

	public void setAccumulatedScore(int accumulatedScore) {
		this.accumulatedScore = accumulatedScore;
	}

	public int getAccumulatedTime() {
		return accumulatedTime;
	}

	public void setAccumulatedTime(int accumulatedTime) {
		this.accumulatedTime = accumulatedTime;
	}

	public void accident(double possibility) {
		if(possibility < 0.05) {
			this.accumulatedTime += 20;
			System.out.println("driver " + this.name + " time +20");
		}else if(possibility >=0.05 & possibility < 0.08) {
			this.accumulatedTime += 120;
			System.out.println("driver " + this.name + " time +120");
		}else if(possibility >=0.08 & possibility < 0.09) {
			this.eligibleToRace = false;
			System.out.println("driver " + this.name + "destroy");
		}
	}

	public void skill(int currentLap) {
		Random ran = new Random();
		switch (specialSkill) {
		case "Braking":
			accumulatedTime -= (ran.nextInt(8) + 1);
		case "Cornering":
			accumulatedTime -= (ran.nextInt(8) + 1);
		case "Overtaking":
			if ((currentLap + 1) % 3 == 0)
				accumulatedTime -= (ran.nextInt(11) + 10);
		}
	}

	public void addTime(int time) {
		this.accumulatedTime += time;
	}

	public void addPoint(int socre) {
		this.accumulatedScore += socre;
	}
	
	
}
