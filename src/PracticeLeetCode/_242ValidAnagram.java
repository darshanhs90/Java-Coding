package LeetCodePerformancePractice;

public class _242ValidAnagram {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
		System.out.println(isAnagram("rzt", "car"));
	}
	
}
