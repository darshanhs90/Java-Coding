package careerCup;

/*
 * Link: http://www.careercup.com/question?id=62586
 * Convert a doubly linked list to a binary search tree in place.
 */
public class _10googleCareerCup {

	public static void main(String[] args) {

	}
	public static  class BinaryTree{
		BinaryTree left,right; 
		int val;
		public BinaryTree(int val) {
			this.val=val;
		}
	}
	public static class ListNode{
		ListNode next; 
		int val;
		public ListNode(int val) {
			this.val=val;
		}
	}
	public static BinaryTree sortedListToBST(ListNode list, int start, int end) {
		if (start > end) 
			return null;
		// same as (start+end)/2, avoids overflow
		int mid = start + (end - start) / 2;
		BinaryTree leftChild = sortedListToBST(list, start, mid-1);
		BinaryTree parent = new BinaryTree(list.val);
		parent.left = leftChild;
		list = list.next;
		parent.right = sortedListToBST(list, mid+1, end);
		return parent;
	}

	public static BinaryTree sortedListToBST(ListNode head, int n) {
		return sortedListToBST(head, 0, n-1);
	}
}
