package ass;

public class Player {
	// instance variables
	private String name;
	private int position;
	private int score;

	/**
	 * Constructor for objects of class Player
	 */

	public Player()// default constructor.
	{
		String name = "";
		int position = 0;
		int score = 0;
	}

	public Player(String newName, int newPosition, int newScore)// non default constuctor.
	{
		name = newName;
		position = newPosition;
		score = newScore;

	}

	public String displayPlayerStates() // return its state in the form of a String.
	{
		String states = name + position + score;
		return states;
	}

	// accessor
	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}

	public int getScore() {
		return score;
	}

	// mutator
	public void setName(String newName) {
		name = newName;
	}

	public void setPosition(int newPosition) {
		if(newPosition <= 0) {
			position = 0;
			System.out.println("回到原点");
		}else {
			position = newPosition;
		}
	}

	public void setScore(int newScore) {
		score = newScore;
	}
}
