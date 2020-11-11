package Leetcode2020Nov;

public class _0657RobotReturnToOrigin {

	public static void main(String[] args) {
		System.out.println(judgeCircle("UD"));
		System.out.println(judgeCircle("LL"));
		System.out.println(judgeCircle("RRDD"));
		System.out.println(judgeCircle("LDRRLRUULR"));
	}

	public static boolean judgeCircle(String moves) {
		int xIndex = 0;
		int yIndex = 0;
		for (int i = 0; i < moves.length(); i++) {
			char c = moves.charAt(i);
			if (c == 'U') {
				yIndex++;
			} else if (c == 'D') {
				yIndex--;
			} else if (c == 'L') {
				xIndex--;
			} else {
				xIndex++;
			}
		}
		return xIndex == 0 && yIndex == 0;
	}
}
