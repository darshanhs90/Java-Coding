package leetCode;

import java.util.Arrays;

/*
 * Link : https://leetcode.com/problems/unique-binary-search-trees/
 */

public class _096UniqueBinaryTree {
	public static int numTrees(int n) {
		int[] count = new int[n + 1];
		System.out.println(Arrays.toString(count));
		count[0] = 1;
		count[1] = 1;

		for (int i = 2; i <= n; i++) {
			for (int j = 0; j <= i - 1; j++) {
				count[i] = count[i] + count[j] * count[i - j - 1];
			}
		}

		return count[n]; 
	}

	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
}