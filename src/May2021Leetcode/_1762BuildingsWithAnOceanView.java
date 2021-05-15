package May2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class _1762BuildingsWithAnOceanView {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findBuildings(new int[] { 4, 2, 3, 1 })));
		System.out.println(Arrays.toString(findBuildings(new int[] { 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(findBuildings(new int[] { 1, 3, 2, 4 })));
		System.out.println(Arrays.toString(findBuildings(new int[] { 2, 2, 2, 2 })));
	}

	public static int[] findBuildings(int[] heights) {
		List<Integer> out = new ArrayList<Integer>();
		if (heights == null || heights.length == 0)
			return heights;
		int maxIndex = heights.length - 1;
		out.add(maxIndex);
		for (int i = heights.length - 2; i >= 0; i--) {

			if (heights[i] > heights[maxIndex]) {
				maxIndex = i;
				out.add(maxIndex);
			}
		}

		int[] output = new int[out.size()];
		Collections.reverse(out);
		for (int i = 0; i < output.length; i++) {
			output[i] = out.get(i);
		}
		return output;
	}
}
