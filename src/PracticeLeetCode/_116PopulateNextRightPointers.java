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
	static TreeLinkNode next;
    public static void connect(TreeLinkNode root) {
        if(root==null)
        	return;
        int height=getHeight(root);
        for (int i = 0; i < height; i++) {
        	next=null;
			connectNodes(root,i);
		}
    }
	private static void connectNodes(TreeLinkNode root, int level) {
		if(root==null)
			return;
		if(level==0)
		{
			root.next=next;
			next=root;
			return;
		}
		connectNodes(root.right, level-1);
		connectNodes(root.left, level-1);
	}
	private static int getHeight(TreeLinkNode root) {
		return root==null?0:1+Math.max(getHeight(root.left), getHeight(root.right));
	}


}
