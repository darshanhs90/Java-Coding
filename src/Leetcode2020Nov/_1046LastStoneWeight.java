package Leetcode2020Nov;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1046LastStoneWeight {

	public static void main(String[] args) {
		System.out.println(lastStoneWeight(new int[] { 2, 7, 4, 1, 8, 1 }));
	}

	public static int lastStoneWeight(int[] stones) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < stones.length; i++) {
			list.add(stones[i]);
		}
		while (list.size() > 1) {
			Collections.sort(list);
			int maxVal1 = list.remove(list.size() - 1);
			int maxVal2 = list.remove(list.size() - 1);
			if (maxVal1 != maxVal2) {
				list.add(Math.abs(maxVal1 - maxVal2));
			}
		}
		return list.size() == 1 ? list.get(0) : 0;
	}
}
