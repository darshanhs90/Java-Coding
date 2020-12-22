package LeetcodeTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0056MergeIntervals {
	public static void main(String[] args) {
		System.out.println(merge(
				new int[][] { new int[] { 1, 3 }, new int[] { 2, 6 }, new int[] { 8, 10 }, new int[] { 15, 18 } }));
		System.out.println(merge(new int[][] { new int[] { 1, 4 }, new int[] { 4, 5 } }));

		System.out.println(merge(
				new int[][] { new int[] { 1, 3 }, new int[] { 2, 9 }, new int[] { 8, 15 }, new int[] { 15, 18 } }));

		System.out.println(merge(
				new int[][] { new int[] { 1, 20 }, new int[] { 2, 9 }, new int[] { 8, 15 }, new int[] { 15, 18 } }));

	}

	
}
