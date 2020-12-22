package LeetcodeTemplate;

import java.util.Arrays;

public class _1337TheKWeakestRowsInAMatrix {
	public static void main(String[] args) {
		System.out
				.println(Arrays.toString(kWeakestRows(
						new int[][] { new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 1, 1, 0 },
								new int[] { 1, 0, 0, 0, 0 }, new int[] { 1, 1, 0, 0, 0 }, new int[] { 1, 1, 1, 1, 1 } },
						3)));

		System.out.println(Arrays.toString(kWeakestRows(new int[][] { new int[] { 1, 0, 0, 0 },
				new int[] { 1, 1, 1, 1 }, new int[] { 1, 0, 0, 0 }, new int[] { 1, 0, 0, 0 } }, 2)));

	}

	
}
