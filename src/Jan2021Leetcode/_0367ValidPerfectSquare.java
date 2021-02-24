package Jan2021Leetcode;

public class _0367ValidPerfectSquare {

	public static void main(String[] args) {
		System.out.println(isPerfectSquare(16));
		System.out.println(isPerfectSquare(15));
	}

	public static boolean isPerfectSquare(int num) {
		double val = Math.sqrt(num);
		return Math.ceil(val) == (int) val;
	}

}
