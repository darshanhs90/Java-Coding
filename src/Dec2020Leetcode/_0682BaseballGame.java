package Dec2020Leetcode;

import java.util.Stack;

public class _0682BaseballGame {

	public static void main(String[] args) {
		System.out.println(calPoints(new String[] { "5", "2", "C", "D", "+" }));
		System.out.println(calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" }));
		System.out.println(calPoints(new String[] { "1" }));
	}

	public static int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<Integer>();
		for (String str : ops) {
			if (str.equals("+")) {
				Integer pre1 = stack.pop();
				Integer newVal = pre1 + stack.peek();
				stack.push(pre1);
				stack.push(newVal);
			} else if (str.equals("C")) {
				stack.pop();
			} else if (str.equals("D")) {
				stack.push(stack.peek() * 2);
			} else {
				stack.push(Integer.parseInt(str));
			}
		}
		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}

}
