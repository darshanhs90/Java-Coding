package June2021GoogLeetcode;

import java.util.Stack;

public class _0394DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
	}

	static class Helper {
		String str;
		int count;
		boolean isString;

		public Helper(String str) {
			this.str = str;
			this.isString = true;
		}

		public Helper(int count) {
			this.count = count;
			this.isString = false;
		}
	}

	public static String decodeString(String s) {
		Stack<Helper> stack = new Stack<Helper>();
		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				String str = c + "";
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					str += s.charAt(i + 1);
					i++;
				}
				stack.push(new Helper(Integer.parseInt(str)));
			} else if (c == '[') {
				// no op
			} else if (c == ']') {
				String str = "";
				while (!stack.isEmpty() && stack.peek().isString) {
					str += stack.pop().str;
				}

				int mult = 1;
				if (!stack.isEmpty() && !stack.peek().isString) {
					mult = stack.pop().count;
				}

				String out = "";
				for (int j = 0; j < mult; j++) {
					out += str;
				}
				stack.push(new Helper(out));
			} else {
				stack.push(new Helper(c + ""));
			}
			i++;
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pop().str);
		}
		return sb.reverse().toString();
	}

}
