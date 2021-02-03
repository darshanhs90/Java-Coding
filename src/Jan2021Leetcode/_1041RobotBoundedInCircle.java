package Jan2021Leetcode;

public class _1041RobotBoundedInCircle {
	public static void main(String[] args) {
		System.out.println(isRobotBounded("GGLLGG"));
		System.out.println(isRobotBounded("GG"));
		System.out.println(isRobotBounded("GL"));
	}

	public static boolean isRobotBounded(String instructions) {
		int x = 0, y = 0;
		int dirs[][] = new int[][] { new int[] { 1, 0 }, new int[] { 0, 1 }, new int[] { -1, 0 }, new int[] { 0, -1 } };

		int currDir = 0;

		for (int i = 0; i < instructions.length(); i++) {
			char c = instructions.charAt(i);
			if (c == 'G') {
				x += dirs[currDir][0];
				y += dirs[currDir][1];
			} else if (c == 'R') {
				currDir = (currDir + 1) % 4;
			} else {
				currDir = (currDir + 3) % 4;
			}
		}

		return x == 0 && y == 0 || currDir != 0;
	}

}
