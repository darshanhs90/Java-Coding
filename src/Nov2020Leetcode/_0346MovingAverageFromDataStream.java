package Nov2020Leetcode;

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
		int currSum;
		int maxSize;

		public MovingAverage(int size) {
			// TODO Auto-generated constructor stub
			currSum = 0;
			this.maxSize = size;
			q = new LinkedList<Integer>();
		}

		public double next(int val) {
			if (q.size() < maxSize) {
				q.offer(val);
				currSum += val;
			} else {
				Integer pop = q.poll();
				currSum += val - pop;
				q.offer(val);
			}
			return currSum / (double) q.size();
		}
	}

}
