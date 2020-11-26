package Nov2020Leetcode;

import java.util.Stack;

public class _0331VerifyPreorderSerializationOfABinaryTree {

	public static void main(String[] args) {
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
		System.out.println(isValidSerialization("1,#"));
		System.out.println(isValidSerialization("9,#,#,1"));

	}

	public static boolean isValidSerialization(String preorder) {
		if (preorder == null)
			return false;
		String[] strArr = preorder.split(",");
		Stack<String> stack = new Stack<String>();
		for (int i = 0; i < strArr.length; i++) {
			String c = strArr[i];
			if (c.contentEquals("#")) {
				while (!stack.isEmpty() && stack.peek().contentEquals(c)) {
					stack.pop();
					if (!stack.isEmpty())
						stack.pop();
					else
						return false;
				}
			}
			stack.push(c);
		}
		return stack.size() == 1 && stack.peek().contentEquals("#");
	}

}
