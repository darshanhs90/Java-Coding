package PracticeLeetCode;

public class _108SortedArrayToBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
	public TreeNode sortedArrayToBST(int[] nums) {
		int left=0,right=nums.length-1;
		return convertTree(left,right,nums);
	}
	private TreeNode convertTree(int left, int right, int[] nums) {
		if(left>right)
			return null;
		int mid=(left+right)/2;
		TreeNode tn=new TreeNode(nums[mid]);
		tn.left=convertTree(left, mid-1, nums);
		tn.right=convertTree(mid+1, right, nums);
		return tn;
	}

}
