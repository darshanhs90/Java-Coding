package GeeksforGeeksPractice;

public class _0023MaximumSumLeafToRootPath {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(-2);
		tn.right=new TreeNode(7);
		tn.left.left=new TreeNode(8);
		tn.left.right=new TreeNode(-4);
		System.out.println(maxSumPath(tn));//17
	}
	private static int maxSumPath(TreeNode tn) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
