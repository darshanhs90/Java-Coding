package Jan2021Leetcode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

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
		int score;
		Deque<Pair> q;
		int width, height;
		int foodIndex;
		int[][] food;
		int currX, currY;

		/**
		 * Initialize your data structure here.
		 * 
		 * @param width  - screen width
		 * @param height - screen height
		 * @param food   - A list of food positions E.g food = [[1,1], [1,0]] means the
		 *               first food is positioned at [1,1], the second is at [1,0].
		 */
		public SnakeGame(int width, int height, int[][] food) {
			q = new LinkedList<Pair>();
			q.offer(new Pair(0, 0));
			score = 0;
			this.height = height;
			this.width = width;
			foodIndex = 0;
			this.food = food;
			currX = 0;
			currY = 0;
		}

		/**
		 * Moves the snake.
		 * 
		 * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
		 * @return The game's score after the move. Return -1 if game over. Game over
		 *         when snake crosses the screen boundary or bites its body.
		 */
		public int move(String direction) {
			if (direction.equals("U")) {
				if (currX - 1 < 0) {
					return -1;
				} else if (containsObject(q, currX - 1, currY)) {
					return -1;
				} else {
					if (foodIndex < food.length && food[foodIndex][0] == currX - 1 && food[foodIndex][1] == currY) {
						score += 1;
						foodIndex += 1;
					} else {
						q.poll();
					}
					q.offer(new Pair(currX - 1, currY));
					currX -= 1;
				}
			} else if (direction.equals("D")) {
				if (currX + 1 >= height) {
					return -1;
				} else if (containsObject(q, currX + 1, currY)) {
					return -1;
				} else {
					if (foodIndex < food.length && food[foodIndex][0] == currX + 1 && food[foodIndex][1] == currY) {
						score += 1;
						foodIndex += 1;
					} else {
						q.poll();
					}
					q.offer(new Pair(currX + 1, currY));
					currX += 1;
				}

			} else if (direction.equals("L")) {
				if (currY - 1 < 0) {
					return -1;
				} else if (containsObject(q, currX, currY - 1)) {
					return -1;
				} else {
					if (foodIndex < food.length && food[foodIndex][0] == currX && food[foodIndex][1] == currY - 1) {
						score += 1;
						foodIndex += 1;
					} else {
						q.poll();
					}
					q.offer(new Pair(currX, currY - 1));
					currY -= 1;
				}

			} else { // R
				if (currY + 1 >= width) {
					return -1;
				} else if (containsObject(q, currX, currY + 1)) {
					return -1;
				} else {
					if (foodIndex < food.length && food[foodIndex][0] == currX && food[foodIndex][1] == currY + 1) {
						score += 1;
						foodIndex += 1;
					} else {
						q.poll();
					}
					q.offer(new Pair(currX, currY + 1));
					currY += 1;
				}
			}
			return score;
		}

		public static boolean containsObject(Queue<Pair> q, int x, int y) {
			Iterator<Pair> iter = q.iterator();
			while (iter.hasNext()) {
				Pair p = iter.next();
				if (p.x == x && p.y == y) {
					if (q.peek() == p)
						return false;
					return true;
				}
			}
			return false;
		}
	}

}
