package SnapPrep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _00001Calc {
	static String evaluate(String input) {
		if (input == null || input.length() == 0) {
			return "Invalid input";
		}

		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != ' ') {
				q.offer(c);
			}
		}
		q.offer('+');
		return evaluateHelper(q);
	}

	// 4+5
	static String evaluateHelper(Queue<Character> q) {
		Double prevNum = 0.0;
		char prevSign = '+';
		// System.out.println(q);
		// ..
		// earliernum = 0;
		// res = 0;
		Stack<Double> stack = new Stack<Double>();
		while (!q.isEmpty()) {
			char c = q.poll();
			if (Character.isDigit(c) || c == '.') {
				String str = c + "";
				while (!q.isEmpty() && ((q.peek() == '.') || Character.isDigit(q.peek()))) {
					str += q.poll();
				}

				prevNum = Double.parseDouble(str);
				// same code
			} else if (c == '(') {
				// for later
			} else {
				if (prevSign == '+') {
					stack.push(+prevNum);
					// earlier num = +prevnum
					// res+= prevNum
				} else if (prevSign == '-') {
					stack.push(-prevNum);
					// earlier num = -prevnum
					// res+= -prevNum
				} else if (prevSign == '*') {
					stack.push(stack.pop() * prevNum);
				} else if (prevSign == '/') {
					stack.push(stack.pop() / prevNum);
				}

				prevNum = 0.0;
				prevSign = c;
			}
		}

		double result = 0.0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return String.valueOf(result);
	}

	public static void main(String args[]) throws Exception {
		System.out.println(evaluate(" 4 + 5 ")); // 9
		System.out.println(evaluate("3.5 * 2 - 5 * 3")); // -8

		System.out.println(evaluate(".5 * 2 - 5 * 3")); // -14
		System.out.println(evaluate(".5 * 2 - 5 * 3 + 10")); // -4

		// extra test cases
		// System.out.println(evaluate("3%2")); // -14
		// System.out.println(evaluate("3^2")); // -14
		// System.out.println(evaluate("1/0")); // -14
		// System.out.println(evaluate("/ 8 + 34 -- ")); // -14

		// System.out.println(evaluate("3.5 * 2 - (5 * 3)"));

	}

}
