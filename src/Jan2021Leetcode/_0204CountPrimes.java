package Jan2021Leetcode;

public class _0204CountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}

	public static int countPrimes(int n) {
		if (n <= 1)
			return 0;
		boolean[] out = new boolean[n];

		for (int i = 2; i <= n / 2; i++) {
			int count = 2;
			while (count * i < n) {
				out[count * i] = true;
				count++;
			}
		}

		int count = 0;

		for (int i = 2; i < out.length; i++) {
			if (out[i] == false)
				count++;
		}
		return count;
	}

}
