package May2021Leetcode;

public class _0622DesignCircularQueue {
// https://leetcode.com/discuss/interview-question/432086/Facebook-or-Phone-Screen-or-Task-Scheduler/394783
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
		int[] arr;
		int front = 0, rear = -1, len = 0;

		public MyCircularQueue(int k) {
			arr = new int[k];
		}

		public boolean enQueue(int value) {
			if (!isFull()) {
				rear = (rear + 1) % arr.length;
				arr[rear] = value;
				len++;
				return true;
			}
			return false;
		}

		public boolean deQueue() {
			if (!isEmpty()) {
				len--;
				front = (front + 1) % arr.length;
				return true;
			}
			return false;
		}

		public int Front() {
			return isEmpty() ? -1 : arr[front];
		}

		public int Rear() {
			return isEmpty() ? -1 : arr[rear];
		}

		public boolean isEmpty() {
			return len == 0;
		}

		public boolean isFull() {
			return len == arr.length;
		}
	}
}
