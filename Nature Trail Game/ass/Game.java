package ass;

import java.util.Scanner;
import java.util.Random;

public class Game {
	// instance variables - replace the example below with your own
	private int trailLength;
	private Trail natureTrail;
	private Player playerOne;
	private Player playerTwo;
	Scanner scanner = new Scanner(System.in);
	private Dice dice = new Dice();

	public static void main(String[] args) {
		Game game = new Game();
		game.playGame();
	}
	
	/**
	 * Constructor for objects of class Game
	 */
	public Game() {
		trailLength = 0;
		natureTrail = new Trail();
		playerOne = new Player();
		playerTwo = new Player();
	}

	public Game(int trailLength, Trail natureTrail, Player playerOne, Player playerTwo) {
		this.trailLength = trailLength;
		this.natureTrail = natureTrail;
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.dice = new Dice();
		this.scanner = new Scanner(System.in);
	}

//	public void computerPlayer(int diceNumberOfComputerPlayer) {
//		System.out.println("");
//		System.out.println("");
//		System.out.println("");
//		System.out.println("=================Game Start=================");
//		System.out.println(playerTwo.getName() + "Start");
//		this.playerTwo = moveAndProcess(diceNumberOfComputerPlayer, this.playerTwo);
//	}

	public void displayMessage() { // Display a welcome message on the screen
		{
			System.out.println("Welcome to the Nature Trail Game!");
			System.out.println("Please enter the trail length,between 10-20: ");
			String a = this.scanner.nextLine();
			if (Integer.valueOf(a) >= 10 && Integer.valueOf(a) <= 20) {// request
				this.trailLength = Integer.valueOf(a);
			} else {
				System.out.println("Invalid Input！Please enter a number between 10-20");
				displayMessage();
			}
		}
	}

	public Trail getNatureTrail() {
		return natureTrail;
	}

	public Player getplayerOne() {
		return playerOne;
	}

	public Player getplayerTwo() {
		return playerTwo;
	}

	public int getTrailLength() {
		return trailLength;
	}

	private void hasAnimal(Player player) {
		int i = dice.generateDiceNumber(10, 1);
		switch(i) {
		case 1:
			System.out.println("meet koala, +10");
			player.setScore(player.getScore() + 10);
			break;
		case 2:
			System.out.println("meet emu, +7");
			player.setScore(player.getScore() + 7);
			break;
		case 3:
			System.out.println("meet wombart, +5");
			player.setScore(player.getScore() + 5);
			break;
		case 4:
			System.out.println("meet kangaroo, +2");
			player.setScore(player.getScore() + 2);
			break;
		case 5:
			System.out.println("meet spider, -5");
			player.setScore(player.getScore() - 5);
			break;
		default:
			System.out.println("no animal");
		}
	}
	
//	public Player moveAndProcess(int diceNumber, Player player) {
//		int points = 0;
//		boolean sign = this.random.nextBoolean();
//		if (sign == true) {
//			int sightingsNum = this.random.nextInt(5);
//			points = this.sightings[sightingsNum];
//		}
//		player.setScore(player.getScore() + points);
//		if (this.playerOne.equals(player)) {
//			this.setCurrentPlayerMaxPosition(this.getCurrentPlayerMaxPosition() + diceNumber);
//		} else if (this.playerTwo.equals(player)) {
//			this.setCurrentPlayerMaxPosition(this.getCurrentPlayerMaxPosition() + diceNumber);
//		}
////		this.trail.displayFeatureInformation();
//		for (int i = 0; i <= 3; i++) {
//			int featurePosition = this.trail.getFeatures()[i].getFeaturePosition();
////			if (this.getCurrentPlayerMaxPosition() == featurePosition) {
////				this.setCurrentPlayerMaxPosition(
////						this.getCurrentPlayerMaxPosition() + this.trail.getFeatures()[i].getSpacePenalty());
////
////				if (this.getCurrentPlayerMaxPosition() < 1) {
////					this.setCurrentPlayerMaxPosition(1);
////				} else if (this.getCurrentPlayerMaxPosition() >= this.getTrailLength()) {
////					this.setCurrentPlayerMaxPosition(this.getTrailLength());
////					player.setScore(player.getScore() + 10);
////				}
////			}
//		}
//		return player;
//	}

	private void playGame() {
		displayMessage();
		setUserName();
		playerTwo.setName("Computer");
		natureTrail.trailNatureFeatures(trailLength);
		int a = dice.generateDiceNumber(4,1);
		int b = dice.generateDiceNumber(4,1);
		while(a == b) {
			System.out.println("。。。");
			a = dice.generateDiceNumber(4,1);
			b = dice.generateDiceNumber(4,1);
		}
		if(a>b) {
			System.out.println("wanjiaxian");
		}else {
			System.out.println("pc xian");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("=================Game Start=================");
		while(playerOne.getPosition() < trailLength-1
				&& playerTwo.getPosition() < trailLength-1) {
			if (a > b) {
				action(playerOne);
				if(playerOne.getPosition() >= trailLength - 1) {
					System.out.println(playerOne.getName() + "到终点了！");
					playerOne.setScore(playerOne.getScore() + 10);
					break;
				}
				action(playerTwo);
				showCurrentPosition();
			}else {
				action(playerTwo);
				if(playerTwo.getPosition() >= trailLength - 1) {
					System.out.println(playerTwo.getName() + "到终点了！");
					playerTwo.setScore(playerTwo.getScore() + 10);
					break;
				}
				action(playerOne);
				showCurrentPosition();
			}
			scanner.nextLine();
		}
		finish();
	}
	
	private void finish() {
		if(playerOne.getScore() > playerTwo.getScore()) {
			System.out.println("玩家赢");
		}else if(playerOne.getScore() < playerTwo.getScore()) {
			System.out.println("电脑赢");
		}else {
			System.out.println("平局");
		}
}

	private void action(Player player) {
		System.out.println(player.getName() + " start");
		move(player);
		hasNatureFeature(player);
		hasAnimal(player);
}

	private void hasNatureFeature(Player player) {
		for(int i = 0; i < 4; i++) {
			if(natureTrail.getFeatures()[i].getFeaturePosition() == player.getPosition()) {
				System.out.println("you see the " + natureTrail.getFeatures()[i].getFeatureType());
				System.out.println("you move " + natureTrail.getFeatures()[i].getSpacePenalty() + " steps");
				player.setPosition(player.getPosition() + natureTrail.getFeatures()[i].getSpacePenalty());
			}
		}
	}

	private void move(Player player) {
		int number = dice.generateDiceNumber(4, 1);
		System.out.println("you.....number");
		player.setPosition(player.getPosition() + number);
		System.out.println("position:" + player.getPosition());
	}

	private void showCurrentPosition() {
		for(int i = 0; i < trailLength;i++) {
			if(i == 0) {
				System.out.print("S ");
			}else if(i == trailLength - 1) {
				System.out.println("F ");
			}else if(i == playerOne.getPosition()&&
					i == playerTwo.getPosition()) {
				System.out.print("HC ");
			}else if(i == playerOne.getPosition()) {
				System.out.print("H ");
			}else if(i == playerTwo.getPosition()) {
				System.out.print("C ");
			}else {
				System.out.print("_ ");
			}
		}
}

	public void setNatureTrail(Trail natureTrail) {
		this.natureTrail = natureTrail;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerOne = playerTwo;
	}

	public void setTrailLength(int trailLength) {
		this.trailLength = trailLength;
	}

	public void setUserName()// 3.request the human player to enter their name.
	{
		System.out.println("Please Enter Your Name which is between 1-6 characters: ");
		String n = this.scanner.nextLine();
		if (n.trim().isEmpty()) {
			System.out.println("Your Name is Empty.Press enter");
			setUserName();
		} else {
			if (n.length() > 6) {
				System.out.println("Your Name is More Than 6 Characters");
				System.out.println("Please Press Enter to Input Your Name Again");
				setUserName();
			} else {
				if (n.startsWith(" ") || n.endsWith(" ")) {
					System.out.println("Begin and End with space character is not allowed: ");
					setUserName();
				} else {
					playerOne.setName(n);
					System.out.println("Welcome, " + playerOne.getName());
				}
			}
		}

	}

//	public void userPlayer(int diceNumberOfUserPlayer)// 4.roll the dice
//	{
//		
//		System.out.println(playerOne.getName() + ", please Press Enter to Roll the Dice");
//		this.scanner.nextLine();
//		this.playerOne = moveAndProcess(diceNumberOfUserPlayer, this.playerOne);
//	}
}
