package April2021Leetcode;

import java.util.Stack;

public class _0394DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
	}

	static class Pair {
		int num;
		String str;
		boolean isString;

		public Pair(int num) {
			this.num = num;
		}

		public Pair(String str) {
			this.str = str;
			this.isString = true;
		}
	}

	public static String decodeString(String s) {
		if (s == null || s.length() < 2)
			return s;
		Stack<Pair> stack = new Stack<Pair>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				String str = c + "";
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					str += s.charAt(i + 1);
					i += 1;
				}
				stack.push(new Pair(Integer.parseInt(str)));
			} else if (c == '[') {
				// no op
			} else if (c == ']') {
				// pop until we get a num and multiply the times and push to stack
				String str = "";
				while (!stack.isEmpty() && stack.peek().isString) {
					str += stack.pop().str;
				}
				int multiplier = 1;
				if (!stack.isEmpty() && !stack.peek().isString)
					multiplier = stack.pop().num;
				StringBuilder sb = new StringBuilder();
				for (int j = 1; j <= multiplier; j++) {
					sb.append(str);
				}
				stack.push(new Pair(sb.toString()));
			} else {
				stack.push(new Pair(c + ""));
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop().str);
		}
		return sb.reverse().toString();
	}

}
