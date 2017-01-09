package PracticeLeetCode;

public class _116PopulateNextRightPointers {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left;
		TreeLinkNode right,next;
		TreeLinkNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeLinkNode tn=new TreeLinkNode(1);
		tn.left=new TreeLinkNode(2);
		tn.right=new TreeLinkNode(3);
		tn.left.left=new TreeLinkNode(4);
		tn.left.right=new TreeLinkNode(5);
		tn.right.left=new TreeLinkNode(6);
		tn.right.right=new TreeLinkNode(7);
		connect(tn);
	}
	a


}
