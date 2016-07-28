package eBayPrep;

import java.util.Stack;

public class _232ImplementQueueUsingStacks{
	Stack<Integer> stack1=new Stack<>();
	Stack<Integer> stack2=new Stack<>();
	public void push(int x) {
		stack1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		int value=stack2.pop();
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
	}

	// Get the front element.
	public int peek() {
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		int value=stack2.peek();
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
		return value;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack1.isEmpty();
	}
	public static void main(String[] args) {
		_232ImplementQueueUsingStacks m=new _232ImplementQueueUsingStacks();
		m.push(1);
		m.push(2);
		System.out.println(m.peek());
		System.out.println(m.peek());
	}
}

