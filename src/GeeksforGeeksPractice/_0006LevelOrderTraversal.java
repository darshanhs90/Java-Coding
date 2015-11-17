package GeeksforGeeksPractice;

public class _0006LevelOrderTraversal {
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.left=new TreeNode(5);
		tn.left.left.left=new TreeNode(6);
		tn.left.left.left.left=new TreeNode(7);
		levelOrderTraversal(tn);
		//1/2/3/5/4/6/7/
	}
	public static void levelOrderTraversal(TreeNode tn)
	{
		
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


}
