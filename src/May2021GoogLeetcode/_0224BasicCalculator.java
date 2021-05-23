package May2021GoogLeetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _0224BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public static int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ')
				q.offer(c);
		}
		q.offer('+');
		return calc(q);
	}

	public static int calc(Queue<Character> q) {
		char prevSign = '+';
		int prev = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (!q.isEmpty()) {
			char c = q.poll();
			if (Character.isDigit(c)) {
				String str = c + "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				prev = Integer.parseInt(str);
			} else if (c == '(') {
				prev = calc(q);
			} else {
				if (prevSign == '+') {
					stack.push(prev);
				} else if (prevSign == '-') {
					stack.push(-prev);
				} else if (prevSign == '*') {
					stack.push(stack.pop() * prev);
				} else if (prevSign == '/') {
					stack.push(stack.pop() / prev);
				}

				if (c == ')')
					break;
				prev = 0;
				prevSign = c;
			}
		}

		int sum = 0;
		while (!stack.isEmpty()) {
			sum += stack.pop();
		}
		return sum;
	}
}
