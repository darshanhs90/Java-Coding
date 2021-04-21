package April2021PrepLeetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _0227BasicCalculatorII {

	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
		System.out.println(calculate(" 3/2 "));
		System.out.println(calculate(" 3+5 / 2 "));
	}

	public static int calculate(String s) {
		if (s == null || s.length() == 0)
			return 0;
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ') {
				q.offer(c);
			}
		}
		q.offer('+');
		return calc(q);
	}

	public static int calc(Queue<Character> q) {
		int prevNum = 0;
		char prevSign = '+';
		Stack<Integer> stack = new Stack<Integer>();
		while (!q.isEmpty()) {
			char c = q.poll();
			if (Character.isDigit(c)) {
				String str = c + "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				prevNum = Integer.parseInt(str);
			} else if (c == '(') {
				prevNum = calc(q);
			} else {
				if (prevSign == '+') {
					stack.push(prevNum);
				} else if (prevSign == '-') {
					stack.push(-prevNum);
				} else if (prevSign == '*') {
					stack.push(stack.pop() * prevNum);
				} else if (prevSign == '/') {
					stack.push(stack.pop() / prevNum);
				}

				if (c == ')')
					break;

				prevSign = c;
				prevNum = 0;
			}
		}

		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
}
