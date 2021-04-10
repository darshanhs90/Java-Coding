package April2021Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

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

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i < intervals.length; i++) {
			int start = intervals[i][0];
			int end = intervals[i][1];
			if (pq.isEmpty()) {
				pq.offer(end);
			} else if (pq.peek() <= start) {
				pq.poll();
				pq.offer(end);
			} else {
				return false;
			}
		}
		return true;
	}

}
