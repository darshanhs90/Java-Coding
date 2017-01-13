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
		if(nums==null||nums.length==0)
			return null;
		return bstConvert(0,nums.length-1,nums);
	}
	private TreeNode bstConvert(int left, int right, int[] nums) {
		if(left>right)
			return null;
		else{
			int mid=(left+right)/2;
			TreeNode tn=new TreeNode(nums[mid]);
			tn.left=bstConvert(left, mid-1, nums);
			tn.right=bstConvert(mid+1, right, nums);
			return tn;
		}
	}

}
