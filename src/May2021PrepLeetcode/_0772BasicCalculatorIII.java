package May2021PrepLeetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _0772BasicCalculatorIII {

	public static void main(String[] args) {
		System.out.println(calculate("1+1"));
		System.out.println(calculate("6-4/2"));
		System.out.println(calculate("2*(5+5*2)/3+(6/2+8)"));
		System.out.println(calculate("(2+6*3+5-(3*14/7+2)*5)+3"));
		System.out.println(calculate("0"));
	}

	public static int calculate(String s) {
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
		int prevVal = 0;
		Stack<Integer> stack = new Stack<Integer>();
		while (!q.isEmpty()) {
			char c = q.poll();
			if (Character.isDigit(c)) {
				String str = c + "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				prevVal = Integer.parseInt(str);
			} else if (c == '(') {
				prevVal = calc(q);
			} else {

				if (prevSign == '+') {
					stack.push(+prevVal);
				} else if (prevSign == '-') {
					stack.push(-prevVal);
				} else if (prevSign == '*') {
					stack.push(stack.pop() * prevVal);
				} else if (prevSign == '/') {
					stack.push(stack.pop() / prevVal);
				}

				if (c == ')')
					break;

				prevVal = 0;
				prevSign = c;
			}
		}

		int res = 0;
		while (!stack.isEmpty()) {
			res += stack.pop();
		}
		return res;
	}
}
