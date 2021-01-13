package Dec2020Leetcode;

import java.util.Stack;

public class _0394DecodeString {

	public static void main(String[] args) {
		System.out.println(decodeString("3[a]2[bc]"));
		System.out.println(decodeString("3[a2[c]]"));
		System.out.println(decodeString("2[abc]3[cd]ef"));
		System.out.println(decodeString("abc3[cd]xyz"));
	}

	static class Pair {
		String strVal;
		int numVal;
		boolean isNum;

		public Pair(String strVal, int numVal, boolean isNum) {
			this.strVal = strVal;
			this.numVal = numVal;
			this.isNum = isNum;
		}
	}

	public static String decodeString(String s) {
		Stack<Pair> stack = new Stack<Pair>();
		for (int i = 0; i < s.length();) {
			char c = s.charAt(i);
			StringBuilder num = new StringBuilder();
			if (Character.isDigit(c)) {
				while(i<s.length() && Character.isDigit(s.charAt(i)))
				{
					num.append(s.charAt(i));
					i++;
				}
				int numVal = Integer.parseInt(num.toString());
				stack.push(new Pair("", numVal, true));
			}
			else if(Character.isAlphabetic(c)){
				stack.push(new Pair(c+"", 0, false));
				i++;
			}
			else {
				if(c == '[')
				{
					i++;
					continue;
				}
				else {
					// c = ']'
					i++;
					StringBuilder sb = new StringBuilder();
					while(!stack.isEmpty() && stack.peek().isNum == false)
					{
						sb.append(stack.pop().strVal);
					}
					sb =sb.reverse();
					int count = stack.pop().numVal;
					StringBuilder out = new StringBuilder();
					for (int j = 0; j < count; j++) {
						out.append(sb.toString());
					}
					
					stack.push(new Pair(out.reverse().toString(), 0, false));
				}
			}
		}
		
		StringBuilder output = new StringBuilder();
		while(!stack.isEmpty())
		{
			output.append(stack.pop().strVal);
		}
		return output.reverse().toString();
	}

}
