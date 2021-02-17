package Jan2021Leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0225ImplementStackUsingQueues {

	public static void main(String[] args) {
		MyStack obj = new MyStack();
		obj.push(1);
		obj.push(2);
		System.out.println(obj.top());
		System.out.println(obj.pop());
		System.out.println(obj.empty());
	}

	static class MyStack {
		Queue<Integer> q1, q2;

		/** Initialize your data structure here. */
		public MyStack() {
			q1 = new LinkedList<Integer>();
			q2 = new LinkedList<Integer>();
		}

		/** Push element x onto stack. */
		public void push(int x) {
			q1.add(x);
		}

		/** Removes the element on top of the stack and returns that element. */
		public int pop() {
			while (!q1.isEmpty() && q1.size() > 1) {
				q2.add(q1.poll());
			}
			int val = q1.poll();
			while (!q2.isEmpty()) {
				q1.add(q2.poll());
			}
			return val;
		}

		/** Get the top element. */
		public int top() {
			while (!q1.isEmpty() && q1.size() > 1) {
				q2.add(q1.poll());
			}
			int val = q1.poll();
			q2.add(val);
			while (!q2.isEmpty()) {
				q1.add(q2.poll());
			}
			return val;
		}

		/** Returns whether the stack is empty. */
		public boolean empty() {
			return q1.isEmpty();
		}
	}
}
