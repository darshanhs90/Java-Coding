package May2021Leetcode;

import java.util.HashSet;

public class _0489RobotRoomCleaner {

	public static void main(String[] args) {
	}

	static interface Robot {
		// Returns true if the cell in front is open and robot moves into the cell.
		// Returns false if the cell in front is blocked and robot stays in the current
		// cell.
		public boolean move();

		// Robot will stay in the same cell after calling turnLeft/turnRight.
		// Each turn will be 90 degrees.
		public void turnLeft();

		public void turnRight();

		// Clean the current cell.
		public void clean();
	}

	public static void cleanRoom(Robot robot) {
		cleanRoom(0, 0, 0, robot, new HashSet<String>());
	}

	public static void returnBack(Robot robot) {
		robot.turnRight();
		robot.turnRight();
		robot.move();
		robot.turnRight();
		robot.turnRight();
	}

	public static void cleanRoom(int x, int y, int dir, Robot robot, HashSet<String> visited) {
		if (visited.contains(x + "/" + y))
			return;
		visited.add(x + "/" + y);
		robot.clean();
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 } };

		for (int i = 0; i < dirs.length; i++) {
			int newDir = (dir + i) % 4;
			int newX = x + dirs[newDir][0];
			int newY = y + dirs[newDir][1];

			if (!visited.contains(newX + "/" + newY) && robot.move()) {
				cleanRoom(newX, newY, newDir, robot, visited);
				returnBack(robot);
			}
			robot.turnRight();
		}
	}

}
