package GeeksforGeeksPractice;

public class _0007CountLeafNodes {
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
		tn.left.right=new TreeNode(4);
		tn.left.left=new TreeNode(5);
		System.out.println(countLeafNodes(tn));//3
	}
	
	public static int countLeafNodes(TreeNode tn)
	{
		
		return 0;
	}
	

}
