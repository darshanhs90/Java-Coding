package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0118PascalsTriangle {
	public static void main(String[] args) {
		System.out.println(generate(5));
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (numRows < 1)
			return output;
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		output.add(list);

		for (int i = 2; i <= numRows; i++) {
			List<Integer> currList = output.get(output.size() - 1);
			list = new ArrayList<Integer>();
			for (int j = 0; j < currList.size(); j++) {
				if (j == 0) {
					list.add(currList.get(j));
				} else {
					list.add(currList.get(j) + currList.get(j - 1));
				}

				if (j == currList.size() - 1)
					list.add(currList.get(j));
			}
			output.add(list);
		}
		return output;
	}
}
