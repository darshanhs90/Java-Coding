package Dec2020Leetcode;

import java.util.Stack;

public class _0224BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int result = 0;
		int sign = +1;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (Character.isDigit(c)) {
				int number = c - '0';
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					number = number * 10 + s.charAt(i + 1) - '0';
					i++;
				}

				result += sign * number;
			} else if (c == '+') {
				sign = +1;
			} else if (c == '-') {
				sign = -1;
			} else if (c == '(') {
				stack.push(result);
				stack.push(sign);
				result = 0;
				sign = +1;
			} else if (c == ')') {
				result = result * stack.pop() + stack.pop();
			}
		}
		return result;
	}
}
