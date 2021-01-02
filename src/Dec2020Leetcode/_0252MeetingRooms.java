package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0252MeetingRooms {

	public static void main(String[] args) {
		System.out.println(
				canAttendMeetings(new int[][] { new int[] { 0, 30 }, new int[] { 5, 10 }, new int[] { 5, 20 } }));

		System.out.println(canAttendMeetings(new int[][] { new int[] { 7, 10 }, new int[] { 2, 4 } }));
	}

	public static boolean canAttendMeetings(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return true;
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});

		int max = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] >= max) {
				max = intervals[i][1];
			} else {
				return false;
			}
		}
		return true;
	}

}
