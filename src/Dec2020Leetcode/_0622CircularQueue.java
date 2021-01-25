package Dec2020Leetcode;

import java.util.Arrays;

public class _0622CircularQueue {

	public static void main(String[] args) {
		MyCircularQueue myCircularQueue = new MyCircularQueue(3);
		System.out.println(myCircularQueue.enQueue(1)); // return True
		System.out.println(myCircularQueue.enQueue(2)); // return True
		System.out.println(myCircularQueue.enQueue(3)); // return True
		System.out.println(myCircularQueue.enQueue(4)); // return False
		System.out.println(myCircularQueue.Rear()); // return 3
		System.out.println(myCircularQueue.isFull()); // return True
		System.out.println(myCircularQueue.deQueue()); // return True
		System.out.println(myCircularQueue.enQueue(4)); // return True
		System.out.println(myCircularQueue.Rear()); // return 4
	}

	static class MyCircularQueue {
		Integer[] queue;
		int startIndex;
		int rearIndex;
		int currCount;

		public MyCircularQueue(int k) {
			queue = new Integer[k];
			Arrays.fill(queue, null);
			startIndex = 0;
			rearIndex = 0;
			currCount = 0;
		}

		public boolean enQueue(int value) {
			if (currCount < queue.length) {
				queue[rearIndex] = value;
				rearIndex++;
				if (rearIndex == queue.length)
					rearIndex = 0;
				currCount++;
				return true;
			}
			return false;
		}

		public boolean deQueue() {
			if (currCount == 0)
				return false;
			queue[startIndex] = null;
			startIndex++;
			if (startIndex == queue.length)
				startIndex = 0;
			currCount--;
			return true;
		}

		public int Front() {
			return queue[startIndex] != null ? queue[startIndex] : -1;
		}

		public int Rear() {
			int prevIndex = rearIndex == 0 ? queue.length-1 : rearIndex-1;
			return queue[prevIndex] != null ? queue[prevIndex] : -1;
		}

		public boolean isEmpty() {
			return currCount == 0;
		}

		public boolean isFull() {
			return currCount == queue.length;
		}
	}
}
