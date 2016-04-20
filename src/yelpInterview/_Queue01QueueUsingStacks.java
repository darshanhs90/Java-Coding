package yelpInterview;

import java.util.Stack;

public class _Queue01QueueUsingStacks {
	static Stack<Integer> stack1=new Stack<>();
	static Stack<Integer> stack2=new Stack<>();
	public static void main(String a[]){
		enqueue(10);
		enqueue(20);
		enqueue(30);
		enqueue(40);
		enqueue(50);
		System.out.println(dequeue());
		enqueue(60);
		System.out.println(dequeue());
	}

	private static int dequeue() {
		if(stack1.isEmpty())
			return -1;
		while(!stack1.isEmpty())
		{
			stack2.push(stack1.pop());
		}
		int element=stack2.pop();
		while(!stack2.isEmpty())
		{
			stack1.push(stack2.pop());
		}
		return element;
	}

	private static void enqueue(int i) {
		stack1.push(i);
	}




}

