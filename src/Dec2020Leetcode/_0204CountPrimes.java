package Dec2020Leetcode;

public class _0204CountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}

	public static int countPrimes(int n) {
		int count = 0;
		boolean[] nonPrimes = new boolean[n];
		for (int i = 2; i < n; i++) {
			if (nonPrimes[i] == false) {
				count++;
			}
			int num = i;
			while (num < n) {
				nonPrimes[num] = true;
				num += i;
			}
		}
		return count;
	}

}
