package June2021GoogLeetcode;

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
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int[] interval : intervals) {
			int currStart = interval[0];
			int currEnd = interval[1];

			if (pq.isEmpty()) {
				pq.offer(currEnd);
			} else if (pq.peek() <= currStart) {
				pq.poll();
				pq.offer(currEnd);
			} else {
				pq.offer(currEnd);
			}
		}
		return pq.size();
	}

}
