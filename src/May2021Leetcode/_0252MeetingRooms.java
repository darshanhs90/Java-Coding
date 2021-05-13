package May2021Leetcode;

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
		if (intervals == null || intervals.length < 2)
			return true;
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < intervals.length; i++) {
			int currStart = intervals[i][0];
			int currEnd = intervals[i][1];
			if (pq.isEmpty()) {
				pq.offer(currEnd);
			} else {
				if (pq.peek() > currStart)
					return false;
				pq.poll();
				pq.offer(currEnd);
			}
		}
		return true;
	}

}
