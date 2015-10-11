package leetCode;

import java.util.LinkedList;

/*
 * Link : https://leetcode.com/problems/implement-stack-using-queues/
 * Done in CTCI
 */

public class _225StackUsingQueues {
	class MyStack {
	    // Push element x onto stack.
		LinkedList<Integer> queue1 = new LinkedList<Integer>();
	    public void push(int x) {
	        queue1.addLast(x);
	    }

	    // Removes the element on top of the stack.
	    public void pop() {
	        queue1.removeLast();
	    }

	    // Get the top element.
	    public int top() {
	        return queue1.getLast();
	    }

	    // Return whether the stack is empty.
	    public boolean empty() {
	    	return queue1.isEmpty();
	    }
	}
}