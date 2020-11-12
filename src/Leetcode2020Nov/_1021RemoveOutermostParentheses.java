package Leetcode2020Nov;

public class _1021RemoveOutermostParentheses {

	public static void main(String[] args) {
		System.out.println(removeOuterParentheses("(()())(())"));
		System.out.println(removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(removeOuterParentheses("()()"));
	}

	public static String removeOuterParentheses(String S) {
		int leftParentheses = 0;
		boolean leftInit = false;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (leftParentheses > 0) {
				sb = sb.append(c);
			}
			
			if (c == '(') {
				leftParentheses++;
			} else {
				leftParentheses--;
			}
			if(leftParentheses == 0)
				sb = sb.deleteCharAt(sb.length() - 1);

		}
		return sb.toString();
	}
}
