package FacebookPrep;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _0227BasicCalculatorII {

	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
		System.out.println(calculate(" 3/2 "));
		System.out.println(calculate(" 3+5 / 2 "));
		System.out.println(calculate("-3+4"));
	}

	public static int calculate(String s) {
		if (s == null) {
			return 0;
		}
		Queue<Character> q = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (c != ' ')
				q.offer(c);
		}
		q.offer('+');
		return cal(q);
	}

	private static int cal(Queue<Character> q) {
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
				prevNum = cal(q);
			} else {
				if (prevSign == '+') {
					stack.push(+1 * prevNum);
				} else if (prevSign == '-') {
					stack.push(-1 * prevNum);
				} else if (prevSign == '*') {
					stack.push(stack.pop() * prevNum);
				} else if (prevSign == '/') {
					stack.push(stack.pop() / prevNum);
				}

				prevNum = 0;
				prevSign = c;
				if (c == ')') {
					break;
				}
			}
		}

		int val = 0;
		while (!stack.isEmpty()) {
			val += stack.pop();
		}
		return val;
	}
}
