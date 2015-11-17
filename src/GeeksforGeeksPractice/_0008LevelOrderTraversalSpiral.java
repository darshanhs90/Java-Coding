package GeeksforGeeksPractice;

public class _0008LevelOrderTraversalSpiral {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(7);
		tn.left.right=new TreeNode(6);
		tn.right.left=new TreeNode(5);
		tn.right.right=new TreeNode(4);
		levelOrderTraversalSpiral(tn);
		//1/
		//2/3/
		//4/5/6/7/
	}
	
	public static void levelOrderTraversalSpiral(TreeNode tn)
	{
		
	}
}
