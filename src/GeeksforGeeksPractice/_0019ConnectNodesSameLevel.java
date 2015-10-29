package GeeksforGeeksPractice;

public class _0019ConnectNodesSameLevel {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(30);
		//preOrder(tn);
		tn.next=null;
		connect(tn);
	}
	private static void connect(TreeNode tn) {
		if(tn==null)
			return;
		if(tn.left!=null)
			tn.left.next=tn.right;
		if(tn.right!=null)
			tn.right.next=tn.next!=null?tn.next.left:null;
		connect(tn.left);
		connect(tn.right);
	}
	public static void preOrder(TreeNode tn)
	{
		if(tn!=null)
		{
			System.out.println(tn.val+"//"+tn.next);
			preOrder(tn.left);
			preOrder(tn.right);
		}
	}

}
