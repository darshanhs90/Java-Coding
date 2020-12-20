package Nov2020_UberPrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _016MeetingRoomsII {

	public static void main(String[] args) {
		System.out.println(
				minMeetingRooms(new int[][] { new int[] { 0, 30 }, new int[] { 5, 10 }, new int[] { 15, 20 } }));

		System.out.println(minMeetingRooms(new int[][] { new int[] { 7, 10 }, new int[] { 2, 4 } }));

	}

	public static int minMeetingRooms(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
		});

		Arrays.sort(intervals, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		for (int[] interval : intervals) {
			if (q.isEmpty()) {
				q.offer(interval[1]);
			} else {
				if (interval[0] < q.peek())
					q.offer(interval[1]);
				else {
					q.poll();
					q.offer(interval[1]);
				}
			}
		}
		return q.size();
	}

}
