package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0119PascalsTriangleII {
	public static void main(String[] args) {
		System.out.println(getRow(3));
		System.out.println(getRow(0));
		System.out.println(getRow(1));
	}

	public static List<Integer> getRow(int rowIndex) {
		List<List<Integer>> lst = generate(rowIndex+1);
		return lst.get(lst.size() - 1);
	}

	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (numRows <= 0)
			return output;
		output.add(new ArrayList<Integer>(Arrays.asList(1)));
		for (int i = 1; i < numRows; i++) {
			List<Integer> prevList = output.get(output.size() - 1);
			List<Integer> nextList = new ArrayList<Integer>();
			nextList.add(prevList.get(0));
			for (int j = 1; j < prevList.size(); j++) {
				nextList.add(prevList.get(j) + prevList.get(j - 1));
			}
			nextList.add(prevList.get(prevList.size() - 1));
			output.add(nextList);
		}
		return output;
	}
}
