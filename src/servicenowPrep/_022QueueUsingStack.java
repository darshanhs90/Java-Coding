package servicenowPrep;

import java.util.Stack;

public class _022QueueUsingStack {
	
	static class MyQueue{
		Stack<Integer> stack1=new Stack<>();
		Stack<Integer> stack2=new Stack<>();
		public void enqueue(int value)
		{
			stack1.push(value);
		}
		public int dequeue()
		{
			while(!stack1.isEmpty())
			{
				stack2.push(stack1.pop());
			}
			int value=stack2.pop();
			while(!stack2.isEmpty())
			{
				stack1.push(stack2.pop());
			}
			return value;
		}
		
	}
	public static void main(String[] args) {
		MyQueue m=new MyQueue();
		m.enqueue(1);
		m.enqueue(2);
		m.enqueue(3);
		System.out.println(m.dequeue());
		System.out.println(m.dequeue());
		
	}
	

	

}
