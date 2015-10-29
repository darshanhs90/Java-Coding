package GeeksforGeeksPractice;

public class _0020InOrderSuccessorOfNode {
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
		inOrder(tn);
		preOrder(tn);
	}
	static TreeNode tnNext=null;
	public static void inOrder(TreeNode tn)
	{
		if(tn!=null)
		{
			inOrder(tn.right);
			System.out.print(tn.val+"//");
			if(tnNext==null)
				tnNext=tn;
			else{
				tn.next=tnNext;
				tnNext=tn;	
			}
			inOrder(tn.left);
		}
	}
	public static void preOrder(TreeNode tn)
	{
		if(tn!=null)
		{
			System.out.print(tn.val+"//"+tn.next.val+"||");//print only if tn.next!=null
			preOrder(tn.left);
			preOrder(tn.right);
		}
	}
}
