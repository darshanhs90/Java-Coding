package Mar2021Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0867TransposeMatrix {
	public static void main(String[] args) {
		int[][] out = transpose(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 }, new int[] { 7, 8, 9 } });
		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}

		out = transpose(new int[][] { new int[] { 1, 2, 3 }, new int[] { 4, 5, 6 } });
		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}
	}

	public static int[][] transpose(int[][] A) {
		
	}
}
