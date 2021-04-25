package April2021PrepLeetcode;

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
		Queue<Integer> q;
		int size;
		int sum;

		/** Initialize your data structure here. */
		public MovingAverage(int size) {
			q = new LinkedList<Integer>();
			this.size = size;
			this.sum = 0;
		}

		public double next(int val) {
			q.offer(val);
			sum += val;
			if (q.size() > size) {
				sum -= q.poll();
			}
			return sum / (double) q.size();
		}
	}

}
