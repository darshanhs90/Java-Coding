package Leetcode2020Nov;

import java.util.Arrays;

public class _0204CountPrimes {

	public static void main(String[] args) {
		System.out.println(countPrimes(10));
	}

	public static int countPrimes(int n) {
		boolean[] primes = new boolean[n];
		Arrays.fill(primes, true);

		for (int i = 2; i < primes.length; i++) {
			int index = 2;
			while (index * i < n) {
				primes[i * index] = false;
				index++;
			}
		}
		int count = 0;
		for (int i = 2; i < primes.length; i++) {
			count = count + (primes[i] == true ? 1 : 0);
		}
		return count;
	}
}
