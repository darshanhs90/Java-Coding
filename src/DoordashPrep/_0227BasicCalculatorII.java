package DoordashPrep;

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
			if (s.charAt(i) != ' ')
				q.offer(s.charAt(i));
		}
		q.offer('+');
		return calculate(q);
	}

	public static int calculate(Queue<Character> q) {
		char prevSign = '+';
		int prevNum = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (!q.isEmpty()) {
			char c = q.poll();
			if (Character.isDigit(c)) {
				String str = c + "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				prevNum = Integer.parseInt(str);
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

				prevSign = c;
				prevNum = 0;
			}
		}
		int val = 0;
		while (!stack.isEmpty()) {
			val += stack.pop();
		}
		return val;
	}

}
