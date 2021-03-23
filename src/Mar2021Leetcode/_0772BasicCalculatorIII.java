package Mar2021Leetcode;

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
			if (s.charAt(i) != ' ')
				q.offer(s.charAt(i));
		}
		q.offer('+');
		return calc(q);
	}

	public static int calc(Queue<Character> q) {
		int prevRes = 1;
		char prevSign = '+';
		Stack<Integer> stack = new Stack<Integer>();
		while (!q.isEmpty()) {
			char c = q.poll();
			if (Character.isDigit(c)) {
				String str = c + "";
				while (!q.isEmpty() && Character.isDigit(q.peek())) {
					str += q.poll();
				}
				prevRes = Integer.parseInt(str);
			} else if (c == '(') {
				prevRes = calc(q);
			} else {
				if (prevSign == '+') {
					stack.push(prevRes);
				} else if (prevSign == '-') {
					stack.push(-prevRes);
				} else if (prevSign == '*') {
					stack.push(stack.pop() * prevRes);
				} else if (prevSign == '/') {
					stack.push(stack.pop() / prevRes);
				}

				if (c == ')') {
					break;
				}

				prevRes = 1;
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
