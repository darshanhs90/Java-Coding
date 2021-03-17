package Feb2021Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _1353MaximumNumberOfEventsThatCanBeAttended {

	public static void main(String[] args) {
		System.out.println(maxEvents(
				new int[][] { new int[] { 1, 2 }, new int[] { 2, 3 }, new int[] { 3, 4 }, new int[] { 1, 2 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 4 }, new int[] { 4, 4 }, new int[] { 2, 2 },
				new int[] { 3, 4 }, new int[] { 1, 1 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 100000 } }));

		System.out.println(maxEvents(new int[][] { new int[] { 1, 1 }, new int[] { 1, 2 }, new int[] { 1, 3 },
				new int[] { 1, 4 }, new int[] { 1, 5 }, new int[] { 1, 6 }, new int[] { 1, 7 } }));
	}

	public static int maxEvents(int[][] events) {
		Arrays.sort(events, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int index = 0;
		int noOfEvents = 0;
		for (int i = 1; i <= 10000; i++) {
			while (index < events.length && events[index][0] == i) {
				pq.offer(events[index][1]);
				index++;
			}

			while (!pq.isEmpty() && pq.peek() < i) {
				pq.poll();
			}

			if (!pq.isEmpty()) {
				noOfEvents++;
				pq.poll();
			}
		}
		return noOfEvents;
	}
}
