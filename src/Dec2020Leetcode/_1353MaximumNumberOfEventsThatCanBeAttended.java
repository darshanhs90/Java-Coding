package Dec2020Leetcode;

import java.util.Arrays;
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
		if (events.length <= 1)
			return events.length;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
		int index = 0;
		int count = 0;
		for (int day = 1; day <= 100000; day++) {
			while (!pq.isEmpty() && pq.peek() < day)
				pq.poll();

			while (index < events.length && events[index][0] == day) {
				pq.offer(events[index++][1]);
			}

			if (!pq.isEmpty()) {
				pq.poll();
				count++;
			}
		}
		return count;
	}
}
