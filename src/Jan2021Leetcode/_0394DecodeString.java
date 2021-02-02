package Jan2021Leetcode;

import java.util.Stack;

public class _0394DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
	}

	static class Pair {
		Integer number;
		String str;

		public Pair(Integer number) {
			this.number = number;
		}

		public Pair(String str) {
			this.str = str;
		}
	}

	public static String decodeString(String s) {
		if (s == null || s.length() == 0)
			return s;
		Stack<Pair> stack = new Stack<Pair>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isAlphabetic(c)) {
				stack.push(new Pair(c + ""));
			} else if (c == '[') {
				// do nothing
			} else if (c == ']') {

				String str = "";
				while (stack.peek().str != null) {
					str += stack.pop().str;
				}

				StringBuilder sb = new StringBuilder();
				Integer num = stack.pop().number;
				for (int j = 0; j < num; j++) {
					sb.append(str);
				}
				stack.push(new Pair(sb.toString()));
				// pop chars until chars
				// pop numbers until change
				// combine and push again
			} else {
				String str = "";
				while (Character.isDigit(s.charAt(i))) {
					str += s.charAt(i) + "";
					i++;
				}
				i--;
				stack.push(new Pair(Integer.parseInt(str)));
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop().str);
		}
		return sb.reverse().toString();
	}

}
