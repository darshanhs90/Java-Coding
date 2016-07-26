package eBayPrep;

public class _108SortedArrayToBST {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9});
		preOrder(tn);
	}

	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.println(tn.val);
			preOrder(tn.right);
		}
	}

	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums==null||nums.length==0)
			return null;
		else
		{
			int left=0,right=nums.length-1;
			int mid=(left+right)/2;
			TreeNode tn=new TreeNode(nums[mid]);
			tn.left=prepTree(left,mid-1,nums);
			tn.right=prepTree(mid+1,right,nums);
			return tn;
		}

	}

	private static TreeNode prepTree(int left, int right, int[] nums) {
		if(left>right)
			return null;
		else
		{
			int mid=(left+right)/2;
			TreeNode tn=new TreeNode(nums[mid]);
			tn.left=prepTree(left,mid-1,nums);
			tn.right=prepTree(mid+1,right,nums);
			return tn;
		}
	}


}

