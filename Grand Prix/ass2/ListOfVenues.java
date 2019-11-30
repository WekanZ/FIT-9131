package ass2;

import java.util.ArrayList;

public class ListOfVenues {
	private ArrayList<Venue> venues;
	
	public ListOfVenues() {
		this.venues = new ArrayList<>();
	}

	/**
	 * @param venues
	 */
	public ListOfVenues(ArrayList<Venue> venues) {
		this.venues = venues;
	}

	public ArrayList<Venue> getVenues() {
		return venues;
	}

	public void addVenue(String name, int laps, int time, double rain) {
		venues.add(new Venue(name,laps,time,rain));
	}
	
	public void setVenues(ArrayList<Venue> venues) {
		this.venues = venues;
	}

	public Venue getVenue(int i){
		return venues.get(i);
	}
	
	public void show() {
		for(int i = 0; i < venues.size(); i++) {
			System.out.println("No." + i + ": " + venues.get(i).getVenueName());
		}
	}

	public ListOfVenues copy() {
		ArrayList<Venue> list = new ArrayList<>();
		for(Venue a : venues) {
			list.add(a);
		}
		return new ListOfVenues(list);
	}
}
