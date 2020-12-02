package Nov2020_GoogPrep;

import java.util.Stack;

public class _066MinStack {

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin());
		minStack.pop();
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}

	static class MinStack {
		Stack<Integer> stack;
		Stack<Integer> minStack;

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
				minStack.push(Math.min(x, minStack.peek()));
			}
		}

		public void pop() {
			if (!stack.isEmpty()) {
				stack.pop();
				minStack.pop();
			}
		}

		public int top() {
			if (!stack.isEmpty()) {
				int val = stack.peek();
				return val;
			}
			return -1;
		}

		public int getMin() {
			if (!stack.isEmpty()) {
				return minStack.peek();
			}
			return -1;
		}
	}
}
