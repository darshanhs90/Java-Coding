package FacebookPortalPrep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0023Queues_QueueRemovals {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findPositions(new int[] { 1, 2, 2, 3, 4, 5 }, 5)));
	}

	static class Pair {

		int num, index;

		public Pair(int num, int index) {
			this.num = num;
			this.index = index;
		}

		public String toString() {
			return this.num + "," + this.index;
		}

	}

	public static int[] findPositions(int[] arr, int x) {
		// Write your code here

		Queue<Pair> q = new LinkedList<Pair>();
		for (int i = 0; i < arr.length; i++) {
			q.offer(new Pair(arr[i], i + 1));
		}

		int index = 0;
		int[] output = new int[x];
		while (!q.isEmpty() && q.size() > 1 && index<output.length) {
			Queue<Pair> tempQ = new LinkedList<Pair>();
			int count = x;
			int maxVal = Integer.MIN_VALUE;
			while (count > 0 && !q.isEmpty()) {
				Pair pollVal = q.poll();
				maxVal = Math.max(maxVal, pollVal.num);
				tempQ.offer(pollVal);
				count--;
			}

			Pair maxPair = null;
			while (!tempQ.isEmpty()) {
				Pair poll = tempQ.poll();
				if (poll.num == maxVal && maxPair == null) {
					maxPair = poll;
					continue;
				}
				poll.num = poll.num == 0 ? 0 : poll.num - 1;
				q.offer(poll);
			}
			output[index++] = maxPair.index;
		}
		return output;
	}
}
