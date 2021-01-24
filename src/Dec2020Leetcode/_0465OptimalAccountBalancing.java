package Dec2020Leetcode;

import java.util.HashMap;
import java.util.Iterator;

public class _0465OptimalAccountBalancing {

	public static void main(String[] args) {
		System.out.println(minTransfers(new int[][] { new int[] { 0, 1, 10 }, new int[] { 2, 0, 5 } }));
		System.out.println(minTransfers(new int[][] { new int[] { 0, 1, 10 }, new int[] { 1, 0, 1 },
				new int[] { 1, 2, 5 }, new int[] { 2, 0, 5 } }));
	}

	public static int minTransfers(int[][] transactions) {
		Integer[] debtArr = debtArray(transactions);
		return minTransfers(0, debtArr);
	}

	public static int minTransfers(int index, Integer[] debtArr) {

		while (index < debtArr.length && debtArr[index] == 0)
			index++;
		if (index == debtArr.length)
			return 0;

		int minTransactions = Integer.MAX_VALUE;
		for (int i = index + 1; i < debtArr.length; i++) {
			if (debtArr[index] * debtArr[i] < 0) {
				debtArr[i] += debtArr[index];
				minTransactions = Math.min(minTransactions, minTransfers(index + 1, debtArr) + 1);
				debtArr[i] -= debtArr[index];
			}
		}
		return minTransactions;
	}

	public static Integer[] debtArray(int[][] transactions) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < transactions.length; i++) {
			int source = transactions[i][0];
			int destination = transactions[i][1];
			int value = transactions[i][2];
			if (map.containsKey(source)) {
				map.put(source, map.get(source) - value);
			} else {
				map.put(source, -value);
			}

			if (map.containsKey(destination)) {
				map.put(destination, map.get(destination) + value);
			} else {
				map.put(destination, +value);
			}
		}

		Iterator<Integer> iter = map.values().iterator();
		Integer[] debtArr = new Integer[map.values().size()];
		int index = 0;
		while (iter.hasNext()) {
			debtArr[index] = iter.next();
			index++;
		}
		return debtArr;
	}

}
