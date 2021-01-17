package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _1326MinimumNumberOfTapsToOpenToWaterAGarden {
	// https://www.youtube.com/watch?v=Gg64QXc9K0s
	public static void main(String[] args) {
		System.out.println(minTaps(5, new int[] { 3, 4, 1, 1, 0, 0 }));
		System.out.println(minTaps(3, new int[] { 0, 0, 0, 0 }));
		System.out.println(minTaps(7, new int[] { 1, 2, 1, 0, 2, 1, 0, 1 }));
		System.out.println(minTaps(8, new int[] { 4, 0, 0, 0, 0, 0, 0, 0, 4 }));
		System.out.println(minTaps(8, new int[] { 4, 0, 0, 0, 4, 0, 0, 0, 4 }));
	}

	public static int minTaps(int n, int[] ranges) {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < ranges.length; i++) {
			if (ranges[i] == 0)
				continue;
			int left = Math.max(0, i - ranges[i]);
			int right = Math.min(n, i + ranges[i]);
			list.add(new int[] { left, right });
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		int min = 0, max = 0, count = 0;
		while (max < n) {
			int prevMax = max;
			for (int i = 0; i < list.size(); i++) {
				int left = list.get(i)[0];
				int right = list.get(i)[1];

				if (left <= min && right > max) {
					max = right;
				}
			}
			if (max == prevMax)
				return -1;
			min = max;
			count++;
		}
		return count;
	}

}
