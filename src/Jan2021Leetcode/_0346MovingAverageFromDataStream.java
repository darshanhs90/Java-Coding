package Jan2021Leetcode;

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
		int sum, size;
		Queue<Integer> q;

		/** Initialize your data structure here. */
		public MovingAverage(int size) {
			q = new LinkedList<Integer>();
			this.size = size;
		}

		public double next(int val) {
			if (q.size() == size) {
				sum -= q.poll();
			}
			q.offer(val);
			sum += val;
			return sum / (double) q.size();
		}
	}

}
