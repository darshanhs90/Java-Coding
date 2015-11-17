package GeeksforGeeksPractice;

public class _0022VerticalSumInTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		getVerticalSum(tn);
		//12,2,4,3,7
	}
	private static void getVerticalSum(TreeNode tn) {
		
		
	}
	
}
