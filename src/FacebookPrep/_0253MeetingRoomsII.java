package FacebookPrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _0253MeetingRoomsII {

	public static void main(String[] args) {
		System.out.println(
				minMeetingRooms(new int[][] { new int[] { 0, 30 }, new int[] { 5, 10 }, new int[] { 15, 20 } }));

		System.out.println(minMeetingRooms(new int[][] { new int[] { 7, 10 }, new int[] { 2, 4 } }));
		System.out.println(
				minMeetingRooms(new int[][] { new int[] { 6, 15 }, new int[] { 13, 20 }, new int[] { 6, 17 } }));
	}

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals == null || intervals.length == 0)
			return 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				int val = o1[0] - o2[0];
				if (val == 0)
					return o1[1] - o2[1];
				return val;
			}
		});

		for (int i = 0; i < intervals.length; i++) {
			if (pq.isEmpty()) {
				pq.offer(intervals[i][1]);
			} else if (pq.peek() <= intervals[i][0]) {
				pq.poll();
				pq.offer(intervals[i][1]);
			} else {
				pq.offer(intervals[i][1]);
			}
		}
		return pq.size();
	}

}
