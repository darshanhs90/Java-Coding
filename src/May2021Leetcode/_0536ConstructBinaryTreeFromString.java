package May2021Leetcode;

import java.util.Stack;

public class _0536ConstructBinaryTreeFromString {

	public static void main(String[] args) {
		System.out.println(str2tree("4(2(3)(1))(6(5))"));
		System.out.println(str2tree("4(2(3)(1))(6(5)(7))"));
		System.out.println(str2tree("-4(2(3)(1))(6(5)(7))"));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static TreeNode str2tree(String s) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '-' || Character.isDigit(c)) {
				String str = c + "";
				while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
					str += s.charAt(i + 1);
					i++;
				}
				TreeNode tn = new TreeNode(Integer.parseInt(str));
				stack.push(tn);
			} else if (c == '(') {
				// no op
			} else {
				TreeNode tn = stack.pop();
				if (stack.peek().left == null) {
					stack.peek().left = tn;
				} else {
					stack.peek().right = tn;
				}
			}
		}
		return stack.isEmpty() ? null : stack.peek();
	}

}
