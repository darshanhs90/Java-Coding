package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _067924Game {

	public static void main(String[] args) {
		System.out.println(judgePoint24(new int[] { 4, 1, 8, 7 }));
		System.out.println(judgePoint24(new int[] { 1, 2, 1, 2 }));
	}

	public static boolean judgePoint24(int[] cards) {
		List<Double> list = new ArrayList<Double>();
		for (Integer card : cards) {
			list.add((double) card);
		}
		return dfs(list);
	}

	public static boolean dfs(List<Double> list) {
		if (list.size() == 1) {
			if (Math.abs(list.get(0) - 24.0) < 0.001) {
				return true;
			}
			return false;
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				List<Double> combinations = getCombinations(list.get(i), list.get(j));

				for (Double doubleVal : combinations) {
					List<Double> newList = new ArrayList<Double>();
					newList.add(doubleVal);

					for (int k = 0; k < list.size(); k++) {
						if (k == i || k == j)
							continue;
						newList.add(list.get(k));
					}

					if (dfs(newList))
						return true;
				}
			}
		}

		return false;
	}

	public static List<Double> getCombinations(double a, double b) {
		List<Double> newList = new ArrayList<Double>();
		newList.add(a + b);
		newList.add(a - b);
		newList.add(b - a);
		newList.add(a * b);
		newList.add(a / b);
		newList.add(b / a);
		return newList;
	}
}
