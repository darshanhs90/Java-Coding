package Jan2021Leetcode;

public class _0657RobotReturnToOrigin {

	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
		System.out.println(judgeCircle("LL"));
		System.out.println(judgeCircle("RRDD"));
		System.out.println(judgeCircle("LDRRLRUULR"));
	}

	public static boolean judgeCircle(String moves) {
		int x = 0, y = 0;
		for (int i = 0; i < moves.length(); i++) {
			char c = moves.charAt(i);
			if (c == 'U') {
				x += 1;
			} else if (c == 'L') {
				y += 1;
			} else if (c == 'D') {
				x -= 1;
			} else {
				y -= 1;
			}
		}

		return x == 0 && y == 0;
	}

}
