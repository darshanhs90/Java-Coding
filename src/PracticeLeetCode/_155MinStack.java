package PracticeLeetCode;

import java.util.Stack;

public class _155MinStack {
	Stack<Integer> elementStack;
	Stack<Integer> minElementStack;

	public _155MinStack() {
		elementStack=new Stack<>();
		minElementStack=new Stack<>();
	}

	public void push(int x) {
		if(elementStack.isEmpty())
		{
			elementStack.push(x);
			minElementStack.push(x);
		}
		else{
			elementStack.push(x);
			minElementStack.push(Math.min(x, minElementStack.peek()));
		}
	}

	public void pop() {
		elementStack.pop();
		minElementStack.pop();
	}

	public int top() {
		return elementStack.peek();
	}

	public int getMin() {
		return minElementStack.peek();
	}
}