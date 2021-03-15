package Feb2021Leetcode;

public class _1041RobotBoundedInCircle {
	public static void main(String[] args) {
		System.out.println(isRobotBounded("GGLLGG"));
		System.out.println(isRobotBounded("GG"));
		System.out.println(isRobotBounded("GL"));
	}

	public static boolean isRobotBounded(String instructions) {
		int x = 0, y = 0;
		int[][] dirs = new int[][] { new int[] { 0, 1 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { -1, 0 } };
		int dir = 0;

		for (int i = 0; i < instructions.length(); i++) {
			char c = instructions.charAt(i);
			if (c == 'G') {
				x = x + dirs[dir][0];
				y = y + dirs[dir][1];
			} else if (c == 'L') {
				dir = (dir + 3) % 4;
			} else if (c == 'R') {
				dir = (dir + 1) % 4;
			}
		}

		return x == 0 && y == 0 || dir != 0;
	}

}
