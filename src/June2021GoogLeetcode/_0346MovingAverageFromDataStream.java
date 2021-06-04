package June2021GoogLeetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0346MovingAverageFromDataStream {

	public static void main(String[] args) {
		MovingAverage ma = new MovingAverage(3);
		System.out.println(ma.next(1));
		System.out.println(ma.next(10));
		System.out.println(ma.next(3));
		System.out.println(ma.next(5));
	}

	static class MovingAverage {
		int sum;
		Queue<Integer> q;
		int capacity;

		/** Initialize your data structure here. */
		public MovingAverage(int size) {
			q = new LinkedList<Integer>();
			sum = 0;
			capacity = size;
		}

		public double next(int val) {
			q.offer(val);
			sum += val;
			if (q.size() > capacity) {
				sum -= q.poll();
			}
			return sum / (double) q.size();
		}
	}

}
