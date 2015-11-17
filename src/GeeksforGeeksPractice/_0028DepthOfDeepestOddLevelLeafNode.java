package GeeksforGeeksPractice;

public class _0028DepthOfDeepestOddLevelLeafNode {
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
		tn.right.left=new TreeNode(5);
		tn.right.left.right=new TreeNode(7);
		tn.right.left.right.left=new TreeNode(9);
		tn.right.right=new TreeNode(6);
		tn.right.right.right=new TreeNode(8);
		tn.right.right.right.right=new TreeNode(10);
		tn.right.right.right.right.left=new TreeNode(11);
		findDepthOfDeepestOddLevelLeaf(tn);//4->9
	}
	private static void findDepthOfDeepestOddLevelLeaf(TreeNode tn) {
		
		
	}
	


}
