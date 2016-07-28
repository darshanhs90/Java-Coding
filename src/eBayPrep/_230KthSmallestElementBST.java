package eBayPrep;

public class _230KthSmallestElementBST{
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static int output=0,count=0;
	public int kthSmallest(TreeNode root, int k) {
		count=0;
		getSmallest(root,k);
		return output;
	}
	private void getSmallest(TreeNode tn,int k) {
		if(tn!=null)
		{
			getSmallest(tn.left,k);
			count++;
			if(count==k)
				output=tn.val;
			getSmallest(tn.right,k);
		}
	}



}

