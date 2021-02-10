package Jan2021Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class _1353MaximumNumberOfEventsThatCanBeAttended {

	public static void main(String[] args) {
		System.out.println(maxEvents(
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 }, new int[] { 1, 2 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 4 }, new int[] { 4, 4 }, new int[] { 2, 2 },
				new int[] { 3, 4 }, new int[] { 1, 1 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 100000 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 },
				new int[] { 1, 4 }, new int[] { 1, 5 }, new int[] { 1, 6 }, new int[] { 1, 7 } }));

		System.out.println(maxEvents(
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 }, new int[] { 1, 2 } }));
	}

	public static int maxEvents(int[][] events) {
		Arrays.sort(events, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0])
					return o1[1] - o2[1];
				return o1[0] - o2[0];
			}
		});

		System.out.println(Arrays.deepToString(events));
		int count = 0;
		TreeSet<Integer> set = new TreeSet<Integer>();
		for (int i = events.length - 1; i >= 0; i--) {
			int end = events[i][1];
			int start = events[i][0];
			for (int j = end; j >= start; j--) {
				if (!set.contains(j)) {
					set.add(j);
					count++;
					break;
				}
			}
		}
		return count;
	}
}
