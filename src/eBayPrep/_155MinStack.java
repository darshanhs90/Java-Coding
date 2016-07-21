package LeetCodePractice;

import java.util.Stack;

public class _155MinStack {
	static Stack<Integer> stack;
	static Stack<Integer> minStack;
	public _155MinStack() {
		stack=null;
		minStack=null;
	}

	public void push(int x) {
		if(stack==null){
			minStack=null;
			stack=new Stack<>();
		}
		stack.push(x);
		if(minStack==null||minStack.isEmpty())
		{
			minStack=new Stack<>();
			minStack.push(x);
		}
		else{
			minStack.push(Math.min(minStack.peek(), x));
		}
	}

	public void pop() {
		stack.pop();
	}

	public int top() {
		return stack.peek();

	}

	public int getMin() {
		return minStack.pop();

	}
	public static void main(String[] args) {
		_155MinStack m=new _155MinStack();
		m.push(-1);
		System.out.println(m.top());
		m.getMin();
		
	}
}

