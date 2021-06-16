package June2021AppleLeetcode;

public class _0353DesignSnakeGame {

	public static void main(String[] args) {
		SnakeGame snakeGame = new SnakeGame(3, 2, new int[][] { new int[] { 1, 2 }, new int[] { 0, 1 } });

		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("U"));

		snakeGame = new SnakeGame(2, 2, new int[][] { new int[] { 0, 1 } });
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("D"));

		snakeGame = new SnakeGame(3, 3, new int[][] { new int[] { 2, 0 }, new int[] { 0, 0 }, new int[] { 0, 2 },
				new int[] { 0, 1 }, new int[] { 2, 2 }, new int[] { 0, 1 } });
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("U"));

		snakeGame = new SnakeGame(3, 3,
				new int[][] { new int[] { 2, 0 }, new int[] { 0, 0 }, new int[] { 0, 2 }, new int[] { 2, 2 } });
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("D"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("R"));
		System.out.println(snakeGame.move("U"));
		System.out.println(snakeGame.move("L"));
		System.out.println(snakeGame.move("D"));
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class SnakeGame {

		/**
		 * Initialize your data structure here.
		 * 
		 * @param width  - screen width
		 * @param height - screen height
		 * @param food   - A list of food positions E.g food = [[1,1], [1,0]] means the
		 *               first food is positioned at [1,1], the second is at [1,0].
		 */
		public SnakeGame(int width, int height, int[][] food) {
		}

		/**
		 * Moves the snake.
		 * 
		 * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
		 * @return The game's score after the move. Return -1 if game over. Game over
		 *         when snake crosses the screen boundary or bites its body.
		 */
		public int move(String direction) {

		}

	}

}
