package FacebookPrep;

import java.util.Arrays;
import java.util.Comparator;

public class _0252MeetingRooms {

	public static void main(String[] args) {
		System.out.println(
				canAttendMeetings(new int[][] { new int[] { 0, 30 }, new int[] { 5, 10 }, new int[] { 5, 20 } }));

		System.out.println(canAttendMeetings(new int[][] { new int[] { 7, 10 }, new int[] { 2, 4 } }));
	}

	public static boolean canAttendMeetings(int[][] intervals) {
		if (intervals == null || intervals.length < 2)
			return true;

		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});

		int currMax = intervals[0][1];
		for (int i = 1; i < intervals.length; i++) {
			int currX = intervals[i][0];
			int currY = intervals[i][1];

			if (currX >= currMax) {
				currMax = currY;
			} else {
				return false;
			}
		}
		return true;
	}

}
