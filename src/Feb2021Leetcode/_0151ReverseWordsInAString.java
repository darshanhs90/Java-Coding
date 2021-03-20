package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0151ReverseWordsInAString {
	static public class TreeNode {
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

	public static void main(String[] args) {
		System.out.println(reverseWords("the sky is blue"));
		System.out.println(reverseWords("  hello world  "));
		System.out.println(reverseWords("a good   example"));
		System.out.println(reverseWords("  Bob    Loves  Alice   "));
		System.out.println(reverseWords("Alice does not even like bob"));
	}

	public static String reverseWords(String s) {
		s = s.trim();
		String[] str = s.split(" ");
		List<String> lst = new ArrayList<String>();
		for (int i = str.length - 1; i >= 0; i--) {
			String word = str[i].trim();
			if (word.length() > 0)
				lst.add(word);
		}
		return String.join(" ", lst);
	}
}
