package appleInterview;

import java.util.Stack;

public class _DS_Queue_1QueueUsingStacks {
	static Stack<Integer> stack1=new Stack<>();
	static Stack<Integer> stack2=new Stack<>();

	public static void main(String[] args) {
		enqueue(10);
		enqueue(20);
		enqueue(30);
		enqueue(40);
		System.out.println(dequeue());
		enqueue(50);
		enqueue(60);
		System.out.println(dequeue());		
	}

	private static int dequeue() {
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		int value=stack2.pop();
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		return value;
	}

	private static void enqueue(int i) {
		stack1.push(i);
	}

}
