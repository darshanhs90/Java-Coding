package GeeksforGeeksPractice;

public class _0026ReverseLevelOrderTraversal {
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
		reverseLevelOrderTraversal(tn);
	}
	private static void reverseLevelOrderTraversal(TreeNode tn) {
		
	}
	


}
