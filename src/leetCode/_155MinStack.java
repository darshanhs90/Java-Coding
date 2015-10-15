package leetCode;

import java.util.ArrayList;
import java.util.Stack;

/*
 * Link : https://leetcode.com/problems/min-stack/
 */

public class _155MinStack {
	class MinStack {
		ArrayList<Integer> minList=new ArrayList<>();
		Stack<Integer> mainStack=new Stack<>();
		public void push(int x) {
			mainStack.push(x);
			if(!minList.isEmpty())
				if(minList.get(minList.size()-1)>x)
					minList.add(x);
				else
					minList.add(minList.get(minList.size()-1));
			else
				minList.add(x);
		}

		public void pop() {
			mainStack.pop();
			minList.remove(minList.size()-1);
		}

		public int top() {
			return mainStack.peek();
		}

		public int getMin() {
			return minList.get(minList.size()-1);
		}
	}
	public static void main(String[] args) {
	}
}