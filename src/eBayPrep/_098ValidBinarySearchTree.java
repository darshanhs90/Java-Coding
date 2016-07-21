package LeetCodePractice;

public class _098ValidBinarySearchTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(Integer.MAX_VALUE);
		//tn.left=new TreeNode(1);
		//tn.right=new TreeNode(3);
		System.out.println(isValidBST(tn));
	}


	public static boolean isValidBST(TreeNode root){
		return isValidBSTTree(root,-2147483649l,2147483648l);
	}

	public static boolean isValidBSTTree(TreeNode root,long min,long max) {
		if(root==null)
			return true;
		return root.val>min && root.val<max && isValidBSTTree(root.left,min,root.val) && isValidBSTTree(root.right,root.val,max);
	}


}

