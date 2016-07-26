package eBayPrep;

public class _109SortedListToBST {
	static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		ListNode ln=new ListNode(1);
		ln.next=new ListNode(2);
		ln.next.next=new ListNode(3);
		ln.next.next.next=new ListNode(4);
		ln.next.next.next.next=new ListNode(5);
		ln.next.next.next.next.next=new ListNode(6);
		ln.next.next.next.next.next.next=new ListNode(7);
		ln.next.next.next.next.next.next.next=new ListNode(8);
		ln.next.next.next.next.next.next.next.next=new ListNode(9);		
		TreeNode tn=sortedListToBST(ln);
		preOrder(tn);
	}

	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.println(tn.val);
			preOrder(tn.right);
		}
	}
	public static TreeNode sortedListToBST(ListNode head) {
		if(head==null)
			return null;
		int length=getLength(head);
		int value=length/2;
		TreeNode tn=new TreeNode(getValue(head,value));
		tn.left=populateNode(head,0,value-1);
		tn.right=populateNode(head,value+1,length-1);		
		return tn;
	}

	private static TreeNode populateNode(ListNode head, int left, int right) {
		if(left>right)
			return null;
		else{
			int mid=(left+right)/2;
			TreeNode tn=new TreeNode(getValue(head, mid));
			tn.left=populateNode(head, left, mid-1);
			tn.right=populateNode(head, mid+1,right);
			return tn;
		}
	}

	private static int getValue(ListNode head, int value) {
		int counter=0;
		while(counter<value){
			head=head.next;
			counter++;
		}
		return head.val;
	}

	private static int getLength(ListNode ln) {
		if(ln==null)
			return 0;
		return 1+getLength(ln.next);
	}


}

