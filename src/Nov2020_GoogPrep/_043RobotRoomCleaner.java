package Nov2020_GoogPrep;

import java.util.HashSet;

public class _043RobotRoomCleaner {
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

	public static void main(String[] args) {

	}

	static int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void cleanRoom(Robot robot) {
		HashSet<String> visited = new HashSet<String>();
		backtrack(robot, visited, 0, 0, 0);
	}

	public static void backtrack(Robot robot, HashSet<String> visited, int x, int y, int direction) {
		String path = x + "-" + y;
		if (visited.contains(path))
			return;
		visited.add(path);
		robot.clean();

		for (int i = 0; i < 4; i++) {
			if (robot.move()) {
				int newX = x + directions[direction][0];
				int newY = y + directions[direction][1];
				backtrack(robot, visited, newX, newY, direction);
				robot.turnLeft();
				robot.turnLeft();
				robot.move();
				robot.turnLeft();
				robot.turnLeft();
			}
			robot.turnRight();
			direction = (direction + 1) % 4;
		}
	}

}
