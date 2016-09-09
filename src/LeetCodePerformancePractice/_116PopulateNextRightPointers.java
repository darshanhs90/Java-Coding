package LeetCodePerformancePractice;

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
	static TreeLinkNode prevVisitedNode=null;
	public static void connect(TreeLinkNode root) {
		int height=getHeight(root);
		for(int i=0;i<height;i++)
		{
			prevVisitedNode=null;
			levelOrder(root,i);
		}
	}
	public static int getHeight(TreeLinkNode root)
	{
		return root==null?0:1+Math.max(getHeight(root.left),getHeight(root.right));
	}
	public static void levelOrder(TreeLinkNode tn,int level){
		if(tn==null||level<0)
			return;
		if(level==0)
		{
			tn.next=prevVisitedNode;
			prevVisitedNode=tn;
			return;
		}
		levelOrder(tn.right,level-1);
		levelOrder(tn.left,level-1);
	}


}
