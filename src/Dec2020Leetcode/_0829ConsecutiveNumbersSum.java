package Dec2020Leetcode;

public class _0829ConsecutiveNumbersSum {

	public static void main(String[] args) {
		System.out.println(consecutiveNumbersSum(5));
		System.out.println(consecutiveNumbersSum(9));
		System.out.println(consecutiveNumbersSum(15));
	}

	public static int consecutiveNumbersSum(int N) {
		int count = 0;
		int upperLimit = (int) (Math.sqrt(2 * N + 0.25) - 0.5);
		for (int k = 1; k <= upperLimit; k++) {
			if ((N - k * (k + 1) / 2) % k == 0)
				count++;
		}
		return count;
	}

}
