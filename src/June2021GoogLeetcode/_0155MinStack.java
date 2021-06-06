package June2021GoogLeetcode;

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

		public void push(int val) {
			if (stack.isEmpty()) {
				stack.push(val);
				minStack.push(val);
			} else {
				stack.push(val);
				minStack.push(Math.min(val, minStack.peek()));
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
