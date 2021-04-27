package April2021PrepLeetcode;

public class _0109ConvertSortedListToBinarySearchTree {
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

	static public class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		ListNode ln = new ListNode(-10);
		ln.next = new ListNode(-3);
		ln.next.next = new ListNode(0);
		ln.next.next.next = new ListNode(5);
		ln.next.next.next.next = new ListNode(9);

		printNodes(sortedListToBST(ln));
	}

	public static void printNodes(TreeNode tn) {
		if (tn == null)
			return;
		printNodes(tn.left);
		System.out.print(tn.val + "->");
		printNodes(tn.right);
	}

	public static ListNode getMiddleElement(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
			fast = fast.next;
		}
		if (prev != null)
			prev.next = null;
		return slow;
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		ListNode mid = getMiddleElement(head);
		TreeNode tn = new TreeNode(mid.val);
		if (head == mid) {
			return tn;
		}
		tn.left = sortedListToBST(head);
		tn.right = sortedListToBST(mid.next);
		return tn;
	}

}
