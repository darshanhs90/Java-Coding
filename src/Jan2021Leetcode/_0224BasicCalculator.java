package Jan2021Leetcode;

import java.util.Stack;

public class _0224BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculate("1 + 1"));
		System.out.println(calculate(" 2-1 + 2 "));
		System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
	}

	public static int calculate(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		int sign = 1;
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				StringBuilder sb = new StringBuilder();
				sb.append(c);
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					sb.append(s.charAt(i + 1));
					i++;
				}
				res += (sign * (Integer.parseInt(sb.toString())));
			} else if (c == '(') {

				stack.push(res);
				stack.push(sign);
				sign = +1;
				res = 0;
			} else if (c == ')') {
				int prevSign = stack.pop();
				int prevRes = stack.pop();
				res = prevRes + prevSign * res;
			} else if (c == '+') {
				sign = 1;
			} else if (c == '-') {
				sign = -1;
			}
		}
		return res;
	}
}
