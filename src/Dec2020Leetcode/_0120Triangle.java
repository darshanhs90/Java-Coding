package Dec2020Leetcode;

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

		out = new ArrayList<List<Integer>>();
		out.add(new ArrayList<Integer>(Arrays.asList(-10)));
		System.out.println(minimumTotal(out));

	}

	public static int minimumTotal(List<List<Integer>> triangle) {
		if (triangle.size() == 1)
			return triangle.get(0).get(0);
		for (int i = triangle.size() - 1; i >= 1; i--) {
			List<Integer> currList = triangle.get(i);
			List<Integer> prevList = triangle.get(i - 1);

			for (int j = 0; j < prevList.size(); j++) {
				prevList.set(j, Math.min(prevList.get(j) + currList.get(j), prevList.get(j) + currList.get(j + 1)));
			}
		}
		return triangle.get(0).get(0);
	}

}
