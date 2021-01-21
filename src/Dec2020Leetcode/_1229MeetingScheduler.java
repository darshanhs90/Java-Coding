package Dec2020Leetcode;

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
		int leftIndex = 0, rightIndex = 0;

		Arrays.sort(slots1, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		Arrays.sort(slots2, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		while (leftIndex < slots1.length && rightIndex < slots2.length) {
			int[] slotA = slots1[leftIndex];
			int[] slotB = slots2[rightIndex];
			int low = Math.max(slotA[0], slotB[0]);
			int high = Math.min(slotA[1], slotB[1]);
			if (low <= high) {
				if (high - low >= duration) {
					return new ArrayList<Integer>(Arrays.asList(low, low + duration));
				}
			}

			if (slotA[1] < slotB[1])
				leftIndex++;
			else
				rightIndex++;
		}

		return new ArrayList<Integer>();
	}
}
