
import java.util.Random;
import java.util.Scanner;

public class Demo {
	private static boolean action(int[][] map) {
		boolean regret = false;
		boolean wrongInput = false;
		do {
			String direction = input();
			switch (direction) {
			case "a":
				left(map);
				wrongInput = false;
				break;
			case "d":
				right(map);
				wrongInput = false;
				break;
			case "w":
				up(map);
				wrongInput = false;
				break;
			case "s":
				down(map);
				wrongInput = false;
				break;
			case "q":
				System.out.println("Bye");
				System.exit(0);
			case "e":
				regret = true;
				wrongInput = false;
				break;
			default:
				System.out.println("wrong action");
				wrongInput = true;
			}
		} while (wrongInput);
		return regret;
	}

	private static int[][] addNum(int[][] map) {
		int x = randomNum(0, 3);
		int y = randomNum(0, 3);
		while (map[y][x] != 0) {
			x = randomNum(0, 3);
			y = randomNum(0, 3);
		}
		map[y][x] = randomChoice();
		return map;
	}

	private static void colorPrint(int num) {
		if (num == 2048) {
			System.out.printf("\u001b[0m|\u001b[38;5;9m%4d", num);
		} else if (num == 1024) {
			System.out.printf("\u001b[0m|\u001b[38;5;190m%4d", num);
		} else if (num == 512) {
			System.out.printf("\u001b[0m|\u001b[38;5;129m%4d", num);
		} else if (num == 256) {
			System.out.printf("\u001b[0m|\u001b[38;5;93m%4d", num);
		} else if (num == 128) {
			System.out.printf("\u001b[0m|\u001b[38;5;51m%4d", num);
		} else if (num == 64) {
			System.out.printf("\u001b[0m|\u001b[38;5;45m%4d", num);
		} else if (num == 32) {
			System.out.printf("\u001b[0m|\u001b[38;5;226m%4d", num);
		} else if (num == 16) {
			System.out.printf("\u001b[0m|\u001b[38;5;14m%4d", num);
		} else if (num == 8) {
			System.out.printf("\u001b[0m|\u001b[38;5;13m%4d", num);
		} else if (num == 4) {
			System.out.printf("\u001b[0m|\u001b[38;5;12m%4d", num);
		} else if (num == 2) {
			System.out.printf("\u001b[0m|\u001b[38;5;10m%4d", num);
		} else {
			System.out.printf("\u001b[0m|%4d", num);
		}
	}

	private static boolean cont(int[][] map) {
		boolean con = false;
		for (int[] row : map) {
			for (int num : row) {
				if (num == 0) {
					con = true;
				}
				if (num > 1024) {
					return false;
				}
			}
		}
		return con;
	}

	private static int[][] copy(int[][] map) {
		int copy[][] = new int[map.length][map.length];
		for (int i = 0; i < map.length;i++) {
			for(int j = 0; j < map.length;j++) {
				copy[i][j] = map[i][j];
			}
		}
		return copy;
	}

	private static void display(int[][] map) {
		System.out.println("+----+----+----+----+");
		for (int[] nums : map) {
			for (int num : nums) {
				colorPrint(num);
			}
			System.out.println("\u001b[0m|\n+----+----+----+----+");
		}
	}

	private static void down(int[][] map) {
		for (int x = 0; x < map.length; x++) {
			// remove 0
			for (int i = 0; i < map.length - 1; i++) {
				for (int y = map.length - 1; y > 0; y--) {
					if (map[y][x] == 0) {
						int temp = map[y][x];
						map[y][x] = map[y - 1][x];
						map[y - 1][x] = temp;
					}
				}
			}
			// merge
			for (int y = map.length - 1; y > 0; y--) {
				if (map[y][x] == map[y - 1][x]) {
					map[y][x] = map[y][x] + map[y - 1][x];
					map[y - 1][x] = 0;
				}
			}
			// remove 0 again
			for (int i = 0; i < map.length - 1; i++) {
				for (int y = map.length - 1; y > 0; y--) {
					if (map[y][x] == 0) {
						int temp = map[y][x];
						map[y][x] = map[y - 1][x];
						map[y - 1][x] = temp;
					}
				}
			}
		}
	}

	private static void gameover(int[][] map) {
		boolean win = false;
		for (int[] row : map) {
			for (int num : row) {
				if (num > 1024) {
					win = true;
				}
			}
		}
		display(map);
		if (win) {
			System.out.println("You win!");
		} else {
			System.out.println("You lose");
		}
	}

	private static String input() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("choose a direction");
		return sc.nextLine();
	}

	private static void left(int[][] map) {
		for (int y = 0; y < map.length; y++) {
			// remove 0
			for (int i = 0; i < map.length - 1; i++) {
				for (int x = 0; x < map.length - 1; x++) {
					if (map[y][x] == 0) {
						int temp = map[y][x];
						map[y][x] = map[y][x + 1];
						map[y][x + 1] = temp;
					}
				}
			}
			// merge
			for (int x = 0; x < map.length - 1; x++) {
				if (map[y][x] == map[y][x + 1]) {
					map[y][x] = map[y][x] + map[y][x + 1];
					map[y][x + 1] = 0;
				}
			}
			// remove 0 again
			for (int i = 0; i < map.length - 1; i++) {
				for (int x = 0; x < map.length - 1; x++) {
					if (map[y][x] == 0) {
						int temp = map[y][x];
						map[y][x] = map[y][x + 1];
						map[y][x + 1] = temp;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int map[][] = new int[4][4];
		int oldMap[][] = new int[4][4];
		int lastMap[][] = new int[4][4];
		boolean regret = false;
		while (cont(map)) {
			if(!regret) {
				map = addNum(map);
			}
			oldMap = copy(map);
			display(map);
			regret = action(map);
			if(regret) {
				map = copy(lastMap);
			}else{
				lastMap = copy(oldMap);
			}
		}
		gameover(map);
	}

	private static int randomChoice() {
		int choices[] = { 2, 4, 8 };
		return choices[randomNum(0, 2)];
	}

	private static int randomNum(int min, int max) {
		Random ran = new Random();
		return ran.nextInt(max - min + 1) + min;
	}

	private static void right(int[][] map) {
		for (int y = 0; y < map.length; y++) {
			// remove 0
			for (int i = 0; i < map.length - 1; i++) {
				for (int x = map.length - 1; x > 0; x--) {
					if (map[y][x] == 0) {
						int temp = map[y][x];
						map[y][x] = map[y][x - 1];
						map[y][x - 1] = temp;
					}
				}
			}
			// merge
			for (int x = map.length - 1; x > 0; x--) {
				if (map[y][x] == map[y][x - 1]) {
					map[y][x] = map[y][x] + map[y][x - 1];
					map[y][x - 1] = 0;
				}
			}
			// remove 0 again
			for (int i = 0; i < map.length - 1; i++) {
				for (int x = map.length - 1; x > 0; x--) {
					if (map[y][x] == 0) {
						int temp = map[y][x];
						map[y][x] = map[y][x - 1];
						map[y][x - 1] = temp;
					}
				}
			}
		}
	}

	private static void up(int[][] map) {
		for (int x = 0; x < map.length; x++) {
			// remove 0
			for (int i = 0; i < map.length - 1; i++) {
				for (int y = 0; y < map.length - 1; y++) {
					if (map[y][x] == 0) {
						int temp = map[y][x];
						map[y][x] = map[y + 1][x];
						map[y + 1][x] = temp;
					}
				}
			}
			// merge
			for (int y = 0; y < map.length - 1; y++) {
				if (map[y][x] == map[y + 1][x]) {
					map[y][x] = map[y][x] + map[y + 1][x];
					map[y + 1][x] = 0;
				}
			}
			// remove 0 again
			for (int i = 0; i < map.length - 1; i++) {
				for (int y = 0; y < map.length - 1; y++) {
					if (map[y][x] == 0) {
						int temp = map[y][x];
						map[y][x] = map[y + 1][x];
						map[y + 1][x] = temp;
					}
				}
			}
		}
	}
}
