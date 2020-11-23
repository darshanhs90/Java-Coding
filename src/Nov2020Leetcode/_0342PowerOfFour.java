package Nov2020Leetcode;

public class _0342PowerOfFour {

	public static void main(String[] args) {
		System.out.println(isPowerOfFour(16));
		System.out.println(isPowerOfFour(5));
	}

	public static boolean isPowerOfFour(int num) {
		if (num < 1)
			return false;
		else if (num == 1)
			return true;
		int val = 1;
		while (val < num) {
			val *= 4;
		}
		return val == num;
	}
}
