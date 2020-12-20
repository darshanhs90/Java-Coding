package Nov2020_UberPrep;

import java.util.Stack;

public class _015BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("11 + 2"));
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
				StringBuilder currDigit = new StringBuilder(c + "");
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					currDigit = currDigit.append(s.charAt(i + 1));
					i++;
				}
				result += Integer.parseInt(currDigit.toString()) * sign;

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
