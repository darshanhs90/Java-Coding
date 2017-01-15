package PracticeLeetCode;

import java.util.Stack;

public class _155MinStack {
	public class MinStack {
		Stack<Integer> stack;
		Stack<Integer> minStack;
		
		public MinStack() {
			stack=new Stack<>();
			minStack=new Stack<>();
		}

		public void push(int x) {
			if(stack.isEmpty())
			{
				minStack.push(x);
			}
			else{
				minStack.push(Math.min(x, minStack.peek()));
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