package Leetcode2020Nov;

import java.util.Stack;

public class _0155MinStack {

	public static void main(String[] args) {
		MinStack obj = new MinStack();
		obj.push(-2);
		obj.push(0);
		obj.push(-3);
		System.out.println(obj.getMin());
		obj.pop();
		System.out.println(obj.top());
		System.out.println(obj.getMin());
	}

	static class MinStack {
		Stack<Integer> minStack;
		Stack<Integer> stack;

		/** initialize your data structure here. */
		public MinStack() {
			minStack = new Stack<Integer>();
			stack = new Stack<Integer>();
		}

		public void push(int x) {
			if (minStack.isEmpty()) {
				minStack.push(x);
			} else {
				if (minStack.peek() >= x) {
					minStack.push(x);
				} else {
					minStack.push(Math.min(minStack.peek(), x));
				}
			}
			stack.push(x);
		}

		public void pop() {
			stack.pop();
			minStack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return minStack.peek();
		}
	}
}
