package June2021GoogLeetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0252MeetingRooms {

	public static void main(String[] args) {
		System.out.println(
				canAttendMeetings(new int[][] { new int[] { 0, 30 }, new int[] { 5, 10 }, new int[] { 5, 20 } }));

		System.out.println(canAttendMeetings(new int[][] { new int[] { 7, 10 }, new int[] { 2, 4 } }));
	}

	public static boolean canAttendMeetings(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		Integer prevEnd = -1;
		for (int[] interval : intervals) {
			int currStart = interval[0];
			int currEnd = interval[1];

			if (currStart >= prevEnd) {
				prevEnd = currEnd;
			} else {
				return false;
			}
		}
		return true;
	}

}
