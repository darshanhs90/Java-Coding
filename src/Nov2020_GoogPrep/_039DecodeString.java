package Nov2020_GoogPrep;

import java.util.Stack;

public class _039DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
		System.out.println(decodeString("100[leetcode]"));
	}

	public static String decodeString(String s) {
		Stack<String> stack = new Stack<String>();
		StringBuilder outputString = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == ']') {
				// pop stack until we get a [
				// and then pop again the next one to get a number
				String str = "";
				while (!stack.isEmpty() && !stack.peek().equals("[")) {
					str += stack.pop();
				}
				// remove the [
				stack.pop();
				StringBuilder noOfTimes = new StringBuilder();
				while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
					noOfTimes.append(stack.pop());
				}

				int count = Integer.parseInt(noOfTimes.reverse().toString());
				String currString = "";
				for (int j = 0; j < count; j++) {
					currString += str;
				}
				stack.push(currString);
			} else {
				stack.push(c + "");
			}
		}

		while (!stack.isEmpty()) {
			outputString.append(stack.pop());
		}

		return outputString.reverse().toString();
	}
}
