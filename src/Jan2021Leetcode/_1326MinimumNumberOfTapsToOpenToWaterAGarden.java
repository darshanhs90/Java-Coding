package Jan2021Leetcode;

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
		List<int[]> posRanges = new ArrayList<int[]>();
		for (int i = 0; i < ranges.length; i++) {
			if (ranges[i] != 0) {
				int currVal = ranges[i];
				int minRange = i - currVal;
				minRange = minRange >= 0 ? minRange : 0;
				int maxRange = i + currVal;
				maxRange = maxRange > n ? n : maxRange;
				posRanges.add(new int[] { minRange, maxRange });
			}
		}

		if (posRanges.size() == 0)
			return -1;

		Collections.sort(posRanges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o2[1] - o1[1];
				return o1[0] - o2[0];
			}
		});

		int min = posRanges.get(0)[0], max = posRanges.get(0)[1];
		posRanges.remove(0);
		if (min != 0)
			return -1;

		int count = 1;
		while (max < n) {
			int currMax = max;
			int indexToRemove = -1;
			for (int i = 0; i < posRanges.size(); i++) {
				int[] arr = posRanges.get(i);
				if (arr[0] > min && arr[0] <= max && arr[1] > currMax) {
					currMax = arr[1];
					indexToRemove = i;
				}
			}

			if (currMax == max)
				return -1;

			min = posRanges.get(indexToRemove)[0];
			max = posRanges.get(indexToRemove)[1];
			posRanges.remove(indexToRemove);
			count++;
		}
		return count;
	}

}
