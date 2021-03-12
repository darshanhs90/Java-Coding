package Feb2021Leetcode;

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
		Queue<Character> q = new LinkedList<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c != ' ')
				q.offer(c);
		}
		q.offer('+');
		return calculate(q);
	}

	public static int calculate(Queue<Character> q) {
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
				prevNum = calculate(q);
			} else {
				if (prevSign == '+') {
					stack.push(+prevNum);
				} else if (prevSign == '-') {
					stack.push(-prevNum);
				} else if (prevSign == '*') {
					stack.push(prevNum * stack.pop());
				} else if (prevSign == '/') {
					stack.push(stack.pop() / prevNum);
				}

				if (c == ')')
					break;
				prevNum = 0;
				prevSign = c;
			}
		}
		int num = 0;
		while (!stack.isEmpty()) {
			num += stack.pop();
		}
		return num;
	}
}
