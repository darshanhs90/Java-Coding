package LeetCodePerformancePractice;

import java.util.LinkedList;
import java.util.Queue;

public class _225StackUsingQueues {
	class MyStack {
		// Push element x onto stack.
		Queue<Integer> q1=new LinkedList<>();
		Queue<Integer> q2=new LinkedList<>();
		public void push(int x) {
			q1.offer(x);
		}

		// Removes the element on top of the stack.
		public void pop() {
			while(q1.size()>1)
			{
				q2.offer(q1.poll());
			}
			q1.poll();
			while(q2.size()>0)
			{
				q1.offer(q2.poll());
			}
		}

		// Get the top element.
		public int top() {
			while(q1.size()>1)
			{
				q2.offer(q1.poll());
			}
			int value=q1.poll();
			q2.offer(value);
			while(q2.size()>0)
			{
				q1.offer(q2.poll());
			}
			return value;
		}

		// Return whether the stack is empty.
		public boolean empty() {
			return q1.isEmpty();
		}
	}
}
