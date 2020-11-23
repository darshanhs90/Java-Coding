package Nov2020Leetcode;

import java.util.Stack;

public class _0232ImplementQueueUsingStacks {

	public static void main(String[] args) {
		MyQueue obj = new MyQueue();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.peek());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}

	static class MyQueue {
		Stack<Integer> s1;
		Stack<Integer> s2;

		/** Initialize your data structure here. */
		public MyQueue() {
			s1 = new Stack<Integer>();
			s2 = new Stack<Integer>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			s1.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			int val = s2.pop();
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			return val;
		}

		/** Get the front element. */
		public int peek() {
			while (!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			int val = s2.peek();
			while (!s2.isEmpty()) {
				s1.push(s2.pop());
			}
			return val;
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return s1.isEmpty();
		}
	}
}
