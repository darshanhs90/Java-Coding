package Nov2020Leetcode;

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
		StringBuilder sb = new StringBuilder();
		String[] sArr = s.split(" ");
		for (int i = sArr.length - 1; i >= 0; i--) {
			if (sArr[i].trim().length() > 0) {
				sb = sb.append(sArr[i] + " ");
			}
		}
		return sb.toString().trim();
	}
}
