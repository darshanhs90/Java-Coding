package Jan2021Leetcode;

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
		Stack<Integer> stack1, stack2;
		/** Initialize your data structure here. */
		public MyQueue() {
			stack1 = new Stack<Integer>();
			stack2 = new Stack<Integer>();
		}

		/** Push element x to the back of queue. */
		public void push(int x) {
			stack1.push(x);
		}

		/** Removes the element from in front of queue and returns that element. */
		public int pop() {
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
			
			int val = stack2.pop();
			while(!stack2.isEmpty())
			{
				stack1.push(stack2.pop());
			}
			return val;
		}

		/** Get the front element. */
		public int peek() {
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
			
			int val = stack2.peek();
			while(!stack2.isEmpty())
			{
				stack1.push(stack2.pop());
			}
			return val;
		}

		/** Returns whether the queue is empty. */
		public boolean empty() {
			return stack1.isEmpty();
		}
	}
}
