package April2021Leetcode;

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

		List<Integer> output = new ArrayList<Integer>();
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

		int index1 = 0, index2 = 0;
		while (index1 < slots1.length && index2 < slots2.length) {
			int start1 = slots1[index1][0];
			int end1 = slots1[index1][1];
			int start2 = slots2[index2][0];
			int end2 = slots2[index2][1];

			int low = Math.max(start1, start2);
			int high = Math.min(end1, end2);

			if (low <= high && high - low >= duration) {
				output.add(low);
				output.add(low + duration);
				return output;
			}

			if (end1 < end2)
				index1++;
			else
				index2++;
		}
		return output;
	}
}
