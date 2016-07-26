package eBayPrep;

public class _098ValidBinarySearchTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static void main(String[] args) {
		TreeNode tn=new TreeNode(2);
		tn.left=new TreeNode(1);
		tn.right=new TreeNode(3);
		System.out.println(isValidBST(tn));
	}
//-2147483649l,2147483648l

	public static boolean isValidBST(TreeNode tn){
		if(tn==null)
			return true;
		else 
			return isValidBSTree(tn.left,-2147483649l,tn.val) && isValidBSTree(tn.right,tn.val,2147483648l);
	}


	private static boolean isValidBSTree(TreeNode tn, long minValue, long maxValue) {
		if(tn==null)
			return true;
		return tn.val>minValue && tn.val<maxValue && isValidBSTree(tn.left, minValue, tn.val) && isValidBSTree(tn.right, tn.val, maxValue);
	}


}

