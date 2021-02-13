package Jan2021Leetcode;

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

		Integer arr[];
		int frontIndex, rearIndex;
		int size;

		public MyCircularQueue(int k) {
			arr = new Integer[k];
			if (k <= 0)
				return;
			frontIndex = 0;
			rearIndex = 0;
			size = 0;
		}

		public boolean enQueue(int value) {
			if (isFull())
				return false;
			arr[rearIndex] = value;
			rearIndex++;

			if (rearIndex >= arr.length)
				rearIndex = 0;

			size++;
			return true;
		}

		public boolean deQueue() {
			if (isEmpty())
				return false;
			arr[frontIndex] = null;
			frontIndex++;
			if (frontIndex >= arr.length)
				frontIndex = 0;
			size--;
			return true;
		}

		public int Front() {
			if (isEmpty())
				return -1;

			return arr[frontIndex];
		}

		public int Rear() {
			if (isEmpty())
				return -1;

			int index = rearIndex;
			index--;

			if (index < 0)
				index = arr.length - 1;
			;
			return arr[index];
		}

		public boolean isEmpty() {
			return size == 0;
		}

		public boolean isFull() {
			return size == arr.length;
		}
	}
}
