package PracticeLeetCode;

import java.util.Stack;

public class _155MinStack {
	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		System.out.println(minStack.top());    // return 0
		System.out.println(minStack.getMin()); // return -2
	}

	static class MinStack {
		Stack<Integer> stack;
		Stack<Integer> minElements;

		/** initialize your data structure here. */
		public MinStack() {
			stack = new Stack<Integer>();
			minElements = new Stack<Integer>();
		}

		public void push(int x) {
			stack.push(x);
			if(minElements.isEmpty())
			{
				minElements.push(x);
			}
			else {
				int topElement = minElements.peek();
				int minElement = topElement > x ? x : topElement;
				minElements.push(minElement);
			}
		}

		public void pop() {
			stack.pop();
			minElements.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return minElements.peek();
		}
	}

}