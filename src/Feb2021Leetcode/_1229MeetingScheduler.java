package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _1229MeetingScheduler {
	public static void main(String[] args) {
		System.out.println(minAvailableDuration(
				new int[][] { new int[] { 10, 50 }, new int[] { 60, 120 }, new int[] { 140, 210 } },
				new int[][] { new int[] { 0, 15 }, new int[] { 60, 70 } }, 8));
		System.out.println(minAvailableDuration(
				new int[][] { new int[] { 10, 50 }, new int[] { 60, 120 }, new int[] { 140, 210 } },
				new int[][] { new int[] { 0, 15 }, new int[] { 60, 70 } }, 12));

		System.out.println(
				minAvailableDuration(new int[][] { new int[] { 0, 2 } }, new int[][] { new int[] { 1, 3 } }, 2));
	}

	public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
		int firstIndex = 0, secondIndex = 0;
		Arrays.sort(slots1, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});
		Arrays.sort(slots2, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}

		});
		while (firstIndex < slots1.length && secondIndex < slots2.length) {
			int start1 = slots1[firstIndex][0];
			int end1 = slots1[firstIndex][1];
			int start2 = slots2[secondIndex][0];
			int end2 = slots2[secondIndex][1];

			int low = Math.max(start1, start2);
			int high = Math.min(end1, end2);
			if (low <= high && high - low >= duration) {
				return new ArrayList<Integer>(Arrays.asList(low, low + duration));
			}

			if (end1 < end2)
				firstIndex++;
			else
				secondIndex++;
		}
		return new ArrayList<Integer>();
	}
}
