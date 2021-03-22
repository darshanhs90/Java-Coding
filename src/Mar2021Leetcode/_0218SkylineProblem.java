package Mar2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _0218SkylineProblem {
	// https://www.youtube.com/watch?v=GSBLe8cKu0s
	public static void main(String[] args) {
		System.out.println(getSkyline(new int[][] { new int[] { 2, 9, 10 }, new int[] { 3, 7, 15 },
				new int[] { 5, 12, 12 }, new int[] { 15, 20, 10 }, new int[] { 19, 24, 8 } }));

		System.out.println(getSkyline(new int[][] { new int[] { 0, 2, 3 }, new int[] { 2, 5, 3 } }));

		System.out.println(getSkyline(new int[][] { new int[] { 1, 3, 4 }, new int[] { 3, 4, 4 }, new int[] { 2, 6, 2 },
				new int[] { 8, 11, 4 }, new int[] { 7, 9, 3 }, new int[] { 10, 11, 2 } }));

	}

	public static List<List<Integer>> getSkyline(int[][] buildings) {
	
	}
}
