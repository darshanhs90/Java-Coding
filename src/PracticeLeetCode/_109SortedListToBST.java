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
	static ListNode ln;
	public static TreeNode sortedListToBST(ListNode head) {
		if(head==null)
			return null;
		ln=head;
		int length=getLength(head);
		return convertList(1,length);
	}
	private static TreeNode convertList(int low, int high) {
		if(low>high)
			return null;
		int mid=(low+high)/2;
		TreeNode leftNode=convertList(low, mid-1);
		TreeNode tn=new TreeNode(ln.val);
		ln=ln.next;
		TreeNode rightNode=convertList(mid+1, high);
		tn.left=leftNode;
		tn.right=rightNode;
		return tn;
	}
	private static int getLength(ListNode head) {
		return head==null?0:1+getLength(head.next);
	}
}
