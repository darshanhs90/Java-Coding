package Nov2020Leetcode;

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
		System.out.print(tn.val + "->");
		printNodes(tn.left);
		printNodes(tn.right);
	}

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;
		return helper(head, null);
	}

	public static TreeNode helper(ListNode head, ListNode tail) {
		if (head == tail)
			return null;
		ListNode slow = head;
		ListNode fast = head;
		while (fast != tail && fast.next != tail) {
			fast = fast.next.next;
			slow = slow.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left = helper(head, slow);
		root.right = helper(slow.next, tail);
		return root;
	}

}
