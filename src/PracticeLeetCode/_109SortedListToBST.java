package PracticeLeetCode;

public class _109SortedListToBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln1=new ListNode(1);
		sortedListToBST(ln1);
	}

}
