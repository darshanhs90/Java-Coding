package GeeksforGeeksPractice;

public class _0013FoldableBinaryTrees {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(50);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		//tn.left.right=new TreeNode(5);
		//tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(30);
		System.out.println(isFoldable(tn));
	}
	private static boolean isFoldable(TreeNode tn) {
		boolean x=checkFoldable(tn.left,tn.right);
		return x;
	}
	private static boolean checkFoldable(TreeNode tn, TreeNode tnNew) {
		if(tn==null && tnNew==null)
			return true;
		if(tn==null || tnNew==null)
			return false;
		return checkFoldable(tn.left, tnNew.right) && checkFoldable(tn.right, tnNew.left);
	}	
}
