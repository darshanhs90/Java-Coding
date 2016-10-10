package PracticeLeetCode;

import java.util.Stack;

public class _232QueueUsingStacks {
	Stack<Integer> stack1=new Stack<>();
	Stack<Integer> stack2=new Stack<>();
	public void push(int x) {
		stack1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		while(stack1.size()>1)
		{
			stack2.push(stack1.pop());
		}
		stack1.pop();
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
	}

	// Get the front element.
	public int peek() {
		while(stack1.size()>1)
		{
			stack2.push(stack1.pop());
		}
		int value=stack1.pop();
		stack2.push(value);
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
}