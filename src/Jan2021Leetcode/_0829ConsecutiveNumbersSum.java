package Jan2021Leetcode;

public class _0829ConsecutiveNumbersSum {

	public static void main(String[] args) {
		System.out.println(consecutiveNumbersSum(5));
		System.out.println(consecutiveNumbersSum(9));
		System.out.println(consecutiveNumbersSum(15));
	}

	public static int consecutiveNumbersSum(int N) {
		int limit = (int) (Math.sqrt(2 * N + 0.25) - 0.5);
		int count = 0;
		for (int k = 1; k <= limit; k++) {
			if ((N - k * (k + 1) / 2) % k == 0)
				count++;
		}
		return count;
	}

}
