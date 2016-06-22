package LeetCodePractice;

import java.util.LinkedList;
import java.util.Queue;

public class _225ImplementStackUsingQueues{
	static class MyStack {
		// Push element x onto stack.
		Queue<Integer> q1=new LinkedList<Integer>();
		Queue<Integer> q2=new LinkedList<Integer>();
		
		public void push(int x) {
			q1.offer(x);
		}

		// Removes the element on top of the stack.
		public void pop() {
			while(q1.size()>0)
			{
				q2.add(q1.remove());//enqueue and dequeue
			}
			int value=(int) q2.poll();
			while(q2.size()>0)
			{
				q1.add(q2.remove());//enqueue and dequeue
			}
		}

		// Get the top element.
		public int top() {
			//return (int) q1.peek();
			while(q1.size()>0)
			{
				q2.add(q1.poll());//enqueue and dequeue
			}
			int value=(int) q2.peek();
			while(q2.size()>0)
			{
				q1.add(q2.poll());//enqueue and dequeue
			}
			return value;
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return q1.size()==0?true:false;
		}
	}
	
	public static void main(String[] args) {
		MyStack m=new MyStack();
		m.push(1);
		m.push(2);
		System.out.println(m.top());
	}
}

