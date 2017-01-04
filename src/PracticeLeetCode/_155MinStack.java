package PracticeLeetCode;

import java.util.Stack;

public class _155MinStack {
	public class MinStack {
		Stack<Integer> stack;
		Stack<Integer> minStack;
		
	    /** initialize your data structure here. */
	    public MinStack() {
	    	stack=new Stack<Integer>();
	    	minStack=new Stack<Integer>();
	    }
	    
	    public void push(int x) {
	        stack.push(x);
	        if(minStack.isEmpty())
	        	minStack.push(x);
	        else{
	        	minStack.push(Math.min(x, minStack.peek()));
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