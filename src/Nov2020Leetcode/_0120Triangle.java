package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0120Triangle {
	public static void main(String[] args) {
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		out.add(new ArrayList<Integer>(Arrays.asList(2)));
		out.add(new ArrayList<Integer>(Arrays.asList(3, 4)));
		out.add(new ArrayList<Integer>(Arrays.asList(6, 5, 7)));
		out.add(new ArrayList<Integer>(Arrays.asList(4, 1, 8, 3)));
		System.out.println(minimumTotal(out));
	}

	static int min;

	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null || triangle.size() == 0)
			return 0;
		min = Integer.MAX_VALUE;
		minimumTotal(triangle, 0, 0, 0);
		return min;
	}

	public static void minimumTotal(List<List<Integer>> triangle, int row, int col, int currSum) {
		if (row == triangle.size()) {
			min = Math.min(min, currSum);
			return;
		}
		minimumTotal(triangle, row + 1, col, currSum + triangle.get(row).get(col));
		minimumTotal(triangle, row + 1, col + 1, currSum + triangle.get(row).get(col));
	}
}
