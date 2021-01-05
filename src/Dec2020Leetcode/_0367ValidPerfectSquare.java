package Dec2020Leetcode;

public class _0367ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16));
		System.out.println(isPerfectSquare(15));
	}

	public static boolean isPerfectSquare(int num) {
		if (num < 2) {
			return true;
		}
		long left = 0, right = num / 2;
		while (left <= right) {
			long mid = (left + right) / 2;
			if (mid * mid == num)
				return true;
			if (mid * mid > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return false;
	}

}
