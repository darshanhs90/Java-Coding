package Jan2021Leetcode;

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
		Stack<Integer> stack, minStack;

		/** initialize your data structure here. */
		public MinStack() {
			stack = new Stack<Integer>();
			minStack = new Stack<Integer>();
		}

		public void push(int x) {
			if (stack.isEmpty()) {
				stack.push(x);
				minStack.push(x);
			} else {
				stack.push(x);
				minStack.push(Math.min(minStack.peek(), x));
			}
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
