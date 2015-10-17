package leetCode;

/*
 * Link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */

public class _108SortedArrayToBST {
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length<1)
			return null;
		int element=nums[(nums.length-1)/2];
		System.out.println(element);
		if(nums.length==1)
			return new TreeNode(nums[0]);
		else{
			return sortedArray(nums,0,nums.length-1);
		}
	}
	private static TreeNode sortedArray(int[] nums, int start, int end) {
		
		if(start>end)
			return null;
		int mid=(start+end)/2;
		TreeNode tn=new TreeNode(nums[mid]);
		tn.left=sortedArray(nums, start,mid-1);
		tn.right=sortedArray(nums, mid+1,end);
		return tn;
		
	}
	public static  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=sortedArrayToBST(new int[]{1,2,3,4,5,7,8,9});
		preOrder(tn);
		sortedArrayToBST(new int[]{1,2,3,4,5,7,8});

	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			System.out.print(tn.val+"/");
			preOrder(tn.left);
			preOrder(tn.right);
		}
		
	}
}