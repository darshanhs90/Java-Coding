package Nov2020Leetcode;

import java.util.Stack;

public class _0682BaseballGame {

	public static void main(String[] args) {
		System.out.println(calPoints(new String[] { "5", "2", "C", "D", "+" }));
		System.out.println(calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
		System.out.println(calPoints(new String[] { "1" }));
	}

	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < ops.length; i++) {
			if (ops[i].contentEquals("C")) {
				stack.pop();
			} else if (ops[i].contentEquals("D")) {
				stack.push(stack.peek() * 2);
			} else if (ops[i].contentEquals("+")) {
				int val = stack.pop();
				int midSum = val + stack.peek();
				stack.push(val);
				stack.push(midSum);
			} else {
				stack.push(Integer.parseInt(ops[i]));
			}
		}
		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}
