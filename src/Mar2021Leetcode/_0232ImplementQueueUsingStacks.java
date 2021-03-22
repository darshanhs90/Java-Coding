package Mar2021Leetcode;

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
		
		/** Initialize your data structure here. */
		public MyQueue() {
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
		}

		/** Get the front element. */
		public int peek() {
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
		}
	}
}
