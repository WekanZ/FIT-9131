package ass2;

import java.util.ArrayList;
import java.util.Random;

public class ListOfDrivers {
	private ArrayList<Driver> drivers;

	
	public ListOfDrivers() {
		this.drivers = new ArrayList<Driver>();
	}
	
	/**
	 * @param drivers
	 */
	public ListOfDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}

	public void addDriver(String name, int ranking, String skill) {
		drivers.add(new Driver(name,ranking,skill,true,0,0));
	}
	
	public ArrayList<Driver> getDrivers() {
		return drivers;
	}

	public Driver getDriver(int i) {
		return drivers.get(i);
	}

	public void setDrivers(ArrayList<Driver> drivers) {
		this.drivers = drivers;
	}

	public void resetCar() {
		for(int i = 0; i < drivers.size(); i++) {
			drivers.get(i).setEligibleToRace(true);
			drivers.get(i).setAccumulatedTime(0);
		}
	}

	public void rankByTime() {
		for (int i = 0; i < drivers.size(); i++) {
			for (int j = i + 1; j < drivers.size(); j++) {
				if(drivers.get(i).getAccumulatedTime() > drivers.get(j).getAccumulatedTime()
						|| (drivers.get(i).getAccumulatedTime() == drivers.get(j).getAccumulatedTime()
								&& new Random().nextBoolean())) {
					Driver driver = drivers.get(i);
					drivers.set(i,drivers.get(j));
					drivers.set(j,driver);
				}
			}
		}
	}
	
	public void rankByScore() {
		for (int i = 0; i < drivers.size(); i++) {
			for (int j = i + 1; j < drivers.size(); j++) {
				if(drivers.get(i).getAccumulatedScore() > drivers.get(j).getAccumulatedScore()
						|| (drivers.get(i).getAccumulatedScore() == drivers.get(j).getAccumulatedScore()
								&& new Random().nextBoolean())) {
					Driver driver = drivers.get(i);
					drivers.set(i,drivers.get(j));
					drivers.set(j,driver);
				}
			}
		}
	}

	public void setRanking() {
		for (int i = 0; i < drivers.size(); i++) {
			drivers.get(i).setRanking(i + 1);
		}
	}

	public void setPoint() {
		drivers.get(0).addPoint(8);
		drivers.get(1).addPoint(5);
		drivers.get(2).addPoint(3);
		drivers.get(3).addPoint(1);
	}

	public void show() {
		for(int i = 0; i < drivers.size(); i++) {
			System.out.println("No" + (i+1) + "----" + drivers.get(i).getName());
		}
	}
	
	
}
