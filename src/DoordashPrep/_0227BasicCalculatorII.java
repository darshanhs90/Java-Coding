package DoordashPrep;

import java.util.Stack;

public class _0227BasicCalculatorII {

	public static void main(String[] args) {
		System.out.println(calculate("3+2*2"));
		System.out.println(calculate(" 3/2 "));
		System.out.println(calculate(" 3+5 / 2 "));
	}

	public static int calculate(String s) {
		s = s.trim();
		Stack<Integer> stack = new Stack<Integer>();
		String str = "";
		int sign = +1;
		Character prevOperation = null;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				str += c;
			} else {
				if (str.length() > 0) {
					if (prevOperation != null) {
						int prevVal = stack.pop();
						if (prevOperation == '*') {
							stack.push(prevVal * Integer.parseInt(str) * sign);
						} else {
							stack.push(prevVal / (Integer.parseInt(str) * sign));
						}
						prevOperation = null;
					} else {
						stack.push(Integer.parseInt(str) * sign);
					}
					str = "";
				}

				if (c == '+') {
					sign = +1;
					str = "";
				} else if (c == '-') {
					sign = -1;
					str = "";
				} else if (c == '*') {
					sign = +1;
					str = "";
					prevOperation = '*';
				} else if (c == '/') {
					sign = +1;
					str = "";
					prevOperation = '/';
				}
			}
		}

		if (prevOperation != null) {
			int prevVal = stack.pop();
			if (prevOperation == '*') {
				stack.push(prevVal * Integer.parseInt(str) * sign);
			} else {
				stack.push(prevVal / (Integer.parseInt(str) * sign));
			}
			prevOperation = null;
		} else {
			stack.push(Integer.parseInt(str) * sign);
		}

		int val = 0;
		while (!stack.isEmpty()) {
			val += stack.pop();
		}
		return val;
	}

}
