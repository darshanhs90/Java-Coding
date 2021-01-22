package Dec2020Leetcode;

import java.util.Arrays;

public class _0974SubarraySumsDivisibleByK {
	public static void main(String[] args) {
		System.out.println(subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
	}

	public static int subarraysDivByK(int[] A, int K) {
		int[] out = new int[A.length + 1];
		out[0] = 0;
		for (int j = 1; j < out.length; j++) {
			out[j] = out[j - 1] + A[j - 1];
		}

		System.out.println(Arrays.toString(out));
		int[] count = new int[K];
		for (int x : out)
			count[(x % K + K) % K]++;

		int ans = 0;
		for (int v : count)
			ans += (v * (v - 1)) / 2;
		return ans;
	}
}
