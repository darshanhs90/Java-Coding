package leetCode;

import java.util.Stack;

/*
 * Link : https://leetcode.com/problems/implement-queue-using-stacks/
 */

public class _232QueueUsingStacks {
	static class MyQueue {
	    // Push element x to the back of queue.
		Stack<Integer> stack1=new Stack<>();
		Stack<Integer> stack2=new Stack<>();
		
	    public void push(int x) {
	        stack1.push(x);
	    }

	    // Removes the element from in front of queue.
	    public void pop() {
	        if(stack2.isEmpty())
	        {
	        	while(!stack1.isEmpty())
	        	{
	        		stack2.push(stack1.pop());
	        	}
	        }
	        if(!stack2.isEmpty())
	        	stack2.pop();
	    }

	    // Get the front element.
	    public int peek() {
	    	if(stack2.isEmpty())
	        {
	        	while(!stack1.isEmpty())
	        	{
	        		stack2.push(stack1.pop());
	        	}
	        }
	        return stack2.peek();
	    }

	    // Return whether the queue is empty.
	    public boolean empty() {
	        if(stack1.isEmpty() && stack2.isEmpty())
	        	return true;
	        return false;
	    }
	}
	public static void main(String[] args) {
		MyQueue q=new MyQueue();
		q.push(1);
		System.out.println(q.peek());
	}
}