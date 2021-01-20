package Dec2020Leetcode;

import java.util.Stack;

public class _0716MaxStack {
	public static void main(String[] args) {
		MaxStack stk = new MaxStack();
		stk.push(5); // [5] the top of the stack and the maximum number is 5.
		stk.push(1); // [5, 1] the top of the stack is 1, but the maximum is 5.
		stk.push(5); // [5, 1, 5] the top of the stack is 5, which is also the maximum, because it is
						// the top most one.
		System.out.println(stk.top()); // return 5, [5, 1, 5] the stack did not change.
		System.out.println(stk.popMax()); // return 5, [5, 1] the stack is changed now, and the top is different from
											// the
		// max.
		System.out.println(stk.top()); // return 1, [5, 1] the stack did not change.
		System.out.println(stk.peekMax()); // return 5, [5, 1] the stack did not change.
		System.out.println(stk.pop()); // return 1, [5] the top of the stack and the max element is now 5.
		System.out.println(stk.top()); // return 5, [5] the stack did not change.
	}

	static class MaxStack {
		Stack<Integer> stack;
		Stack<Integer> maxStack;

		/** initialize your data structure here. */
		public MaxStack() {
			stack = new Stack<Integer>();
			maxStack = new Stack<Integer>();
		}

		public void push(int x) {
            stack.push(x);
			if (maxStack.isEmpty()) {
				maxStack.push(x);
			} else {
				maxStack.push(Math.max(x, maxStack.peek()));
			}
		}

		public int pop() {
			maxStack.pop();
			return stack.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int peekMax() {
			return maxStack.peek();
		}

		public int popMax() {
			int max = maxStack.peek();
			Stack<Integer> temp = new Stack<Integer>();
			while (!stack.isEmpty() && stack.peek() != max) {
				temp.push(pop());
			}
			pop();
			while (!temp.isEmpty()) {
				push(temp.pop());
			}

			return max;
		}
	}
}
