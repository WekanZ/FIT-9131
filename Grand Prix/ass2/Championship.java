package ass2;

import java.util.ArrayList;

public class Championship {
	public static void main(String[] args) {
		Championship cham = new Championship();
		cham.start();
	}
	private ListOfDrivers drivers;
	
	private ListOfVenues venues;

	/**
	 * 
	 */
	public Championship() {
		drivers = new ListOfDrivers();
		venues = new ListOfVenues();
	}
	
	/**
	 * @param drivers
	 * @param venues
	 */
	public Championship(ListOfDrivers drivers, ListOfVenues venues) {
		this.drivers = drivers;
		this.venues = venues;
	}
	
	private boolean[] changeTire() {
		boolean change[] = new boolean[drivers.getDrivers().size()];
		for (int i = 0; i < drivers.getDrivers().size(); i++) {
			if (RNG.creatDouble() < 0.5) {
				change[i] = true;
			}else {
				change[i] = false;
			}
		}
		return change;
	}

	private void eachRace(String name, int lap, int time, double rain) {
		drivers.resetCar();
		
		boolean changeTire[] = changeTire();
		for(int i = 0; i < drivers.getDrivers().size();i++) {
			if(changeTire[i]) {
				drivers.getDriver(i).addTime(10);
			}
		}
		for (int i = 0; i < lap; i++) {
			System.out.println("this is lap " + (i+1));
			boolean isRain = isRain(rain);
			for(int j = 0; j < drivers.getDrivers().size();j++) {
				if (drivers.getDriver(j).isEligibleToRace()) {
					double accidentChance = RNG.creatDouble();
					drivers.getDriver(j).addTime(time);
					drivers.getDriver(j).accident(accidentChance);
					drivers.getDriver(j).skill(i);
					if(isRain && i > 0 && changeTire[j]) {
						drivers.getDriver(j).addTime(-5);
					}
				}else {
					System.out.println(drivers.getDriver(j).getName() + " broken");
				}
			}
			drivers.rankByTime();
			System.out.println("the first is " + drivers.getDriver(0).getName());
			Input.toContinue();
		}
		drivers.setRanking();
		drivers.setPoint();
	}
	
	private void endGame() {
		drivers.rankByScore();
		System.out.println("\nRace is over!");
		System.out.println("The champion is " + drivers.getDriver(0).getName());
		drivers.show();
	}
	
	public ListOfDrivers getDrivers() {
		return drivers;
	}

	public ListOfVenues getVenues() {
		return venues;
	}

	private void initializeDriver() {
		try {
			ArrayList<String> info = FileIO.input("drivers.txt");
			for(int i = 0; i < info.size(); i++) {
				String msg[] = info.get(i).split(",");
				this.drivers.addDriver(msg[0],Integer.valueOf(msg[1]),msg[2]);;
			}
		} catch(Exception e) {
			e.getMessage();
		}
	}

	private void initializeVenue() {
		try {
			ArrayList<String> info = FileIO.input("venues.txt");
			for(int i = 0; i < info.size(); i++) {
				String msg[] = info.get(i).split(",");
				this.venues.addVenue(msg[0], 
						Integer.valueOf(msg[1]), 
						Integer.valueOf(msg[2]), 
						Double.valueOf(msg[3]));
			}
		} catch(Exception e) {
			e.getMessage();
		}
	}

	private boolean isRain(double rain) {
		double num = RNG.creatDouble();
		if(num < rain) {
			return true;
		}else {
			return false;
		}
	}

	private void race(int endNum, ListOfVenues choiceList) {
		int round = 1;
		while(round <= endNum) {
			System.out.println("here are all the venues:");
			for(int i = 0; i < choiceList.getVenues().size(); i++) {
				System.out.println("No." + (i+1) + ": " + choiceList.getVenues().get(i).getVenueName());
			}
			int index = Input.inputInt("please enter a number") - 1;
			while (index < 0 || index > choiceList.getVenues().size() - 1) {
				System.out.println("please enter a number between 1 and " + choiceList.getVenues().size());
				index = Input.inputInt("please enter a number") - 1;
			}
			String name = choiceList.getVenues().get(index).getVenueName();
			int lap = choiceList.getVenues().get(index).getNoOfLaps();
			int time = choiceList.getVenues().get(index).getAverageLapTime();
			double rain = choiceList.getVenues().get(index).getChanceOfRain();
			System.out.println("you choose " + name);
			this.eachRace(name,lap,time,rain);
			drivers.show();
			choiceList.getVenues().remove(index);
			round++;
			Input.toContinue();
		}
	}

	public void setDrivers(ListOfDrivers drivers) {
		this.drivers = drivers;
	}

	public void setVenues(ListOfVenues venues) {
		this.venues = venues;
	}

	public void start() {
		int endNum = Input.inputInt("Please enter the number of venues");
		while (endNum > 5 || endNum < 3 ) {
			System.out.println("please enter number between 3 and 5");
			endNum = Input.inputInt("Please enter the number of venues");
		}
		this.initializeDriver();
		this.initializeVenue();
		ListOfVenues choiceList = venues.copy();
		this.race(endNum, choiceList);
		this.endGame();
	}
	
}
