package PracticeLeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _225StackUsingQueues {
	class MyStack {
		// Push element x onto stack.
		Queue<Integer> queue1=new LinkedList<>();
		Queue<Integer> queue2=new LinkedList<>();
		
		public void push(int x) {
			queue1.offer(x);
		}

		// Removes the element on top of the stack.
		public void pop() {
			while(queue1.size()>1)
			{
				queue2.offer(queue1.poll());
			}
			queue1.poll();
			while(!queue2.isEmpty())
			{
				queue1.offer(queue2.poll());
			}
		}

		// Get the top element.
		public int top() {
			while(queue1.size()>1)
			{
				queue2.offer(queue1.poll());
			}
			int val=queue1.poll();
			queue2.offer(val);
			while(!queue2.isEmpty())
			{
				queue1.offer(queue2.poll());
			}
			return val;
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return queue1.isEmpty();
		}
	}
}