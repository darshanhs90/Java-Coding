package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _0253MeetingRoomsII {

	public static void main(String[] args) {
		System.out.println(
				minMeetingRooms(new int[][] { new int[] { 0, 30 }, new int[] { 5, 10 }, new int[] { 15, 20 } }));

		System.out.println(minMeetingRooms(new int[][] { new int[] { 7, 10 }, new int[] { 2, 4 } }));
	}

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		PriorityQueue<Integer> pQ = new PriorityQueue<Integer>();
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		for (int[] interval : intervals) {
			if (pQ.isEmpty()) {
				pQ.offer(interval[1]);
			} else {
				if (pQ.peek() <= interval[0]) {
					pQ.poll();
				}
				pQ.offer(interval[1]);
			}
		}
		return pQ.size();
	}

}
