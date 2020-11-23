package Nov2020Leetcode;

public class _0263UglyNumber {

	public static void main(String[] args) {
		System.out.println(isUgly(6));
		System.out.println(isUgly(8));
		System.out.println(isUgly(14));
		System.out.println(isUgly(0));
		System.out.println(isUgly(1));
	}

	public static boolean isUgly(int num) {
		if (num == 1)
			return true;
		else if (num <= 0)
			return false;
		while (num % 2 == 0) {
			num /= 2;
		}

		while (num % 3 == 0) {
			num /= 3;
		}

		while (num % 5 == 0) {
			num /= 5;
		}
		return num == 1;
	}
}
