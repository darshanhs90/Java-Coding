package Nov2020_UberPrep;

import java.util.LinkedList;
import java.util.Queue;

public class _038MovingAverageFromDataStream {

	public static void main(String[] args) {
		MovingAverage m = new MovingAverage(3);
		System.out.println(m.next(1)); // 1
		System.out.println(m.next(10)); // (1 + 10) / 2
		System.out.println(m.next(3)); // (1 + 10 + 3) / 3
		System.out.println(m.next(5)); // (10 + 3 + 5) / 3
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
			sum += val;
			q.offer(val);
			if (q.size() > this.size) {
				sum -= q.poll();
			}
			return sum / (double)q.size();
		}
	}

}
