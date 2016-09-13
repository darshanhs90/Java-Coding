package LeetCodePerformancePractice;

import java.util.Stack;

public class _155MinStack {
	class MinStack {
		Stack<Integer> elements=new Stack<Integer>();
		Stack<Integer> minElements=new Stack<Integer>();
		
		/** initialize your data structure here. */
		public MinStack() {
			elements=new Stack<Integer>();
			minElements=new Stack<Integer>();
		}

		public void push(int x) {
			if(elements.isEmpty())
			{
				elements.push(x);
				minElements.push(x);
			}
			else{
				elements.push(x);
				minElements.push(Math.min(x, minElements.peek()));
			}
		}

		public void pop() {
			elements.pop();
			minElements.pop();
		}

		public int top() {
			return elements.peek();
		}

		public int getMin() {
			return minElements.peek();
		}
	}
}
