package Dec2020Leetcode;

public class _1041RobotBoundedInCircle {
	public static void main(String[] args) {
		System.out.println(isRobotBounded("GGLLGG"));
		System.out.println(isRobotBounded("GG"));
		System.out.println(isRobotBounded("GL"));
	}

	public static boolean isRobotBounded(String instructions) {
		int dirs[][] = new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 }, new int[] { -1, 0 }, new int[] { 0, -1 } };

		int dir = 0;
		// dir = 1 -> right
		// dir = 2 -> down
		// dir = 3 -> left
		int currX = 0, currY = 0;
		for (int i = 0; i < instructions.length(); i++) {
			char c = instructions.charAt(i);
			if (c == 'L') {
				dir = (dir + 3) % 4;
			} else if (c == 'R') {
				dir = (dir + 1) % 4;
			} else {
				currX += dirs[dir][0];
				currY += dirs[dir][1];
			}
		}

		return dir != 0 || (currX == 0 && currY == 0);
	}

}
