package Dec2020Leetcode;

import java.util.Arrays;

public class _1465MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
	public static void main(String[] args) {
		System.out.println(maxArea(5, 4, new int[] { 1, 2, 4 }, new int[] { 1, 3 }));
		System.out.println(maxArea(5, 4, new int[] { 3, 1 }, new int[] { 1 }));
		System.out.println(maxArea(5, 4, new int[] { 3 }, new int[] { 3 }));
	}

	public static int maxArea(int height, int width, int[] h, int[] v) {
		int mod = 1000000007;
		Arrays.sort(h);
		Arrays.sort(v);
		int maxHDiff = h[0];
		int maxVDiff = v[0];
		for (int i = 1; i < h.length; i++) {
			maxHDiff = Math.max(maxHDiff, h[i] - h[i - 1]);
		}
		maxHDiff = Math.max(maxHDiff, height - h[h.length - 1]);

		for (int i = 1; i < v.length; i++) {
			maxVDiff = Math.max(maxVDiff, v[i] - v[i - 1]);
		}
		maxVDiff = Math.max(maxVDiff, width - v[v.length - 1]);

        return (int)(maxHDiff % (1e9 + 7) * maxVDiff % (1e9 + 7));
	}
}
