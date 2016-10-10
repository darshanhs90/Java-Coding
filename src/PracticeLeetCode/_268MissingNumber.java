package PracticeLeetCode;

public class _268MissingNumber {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println("**"+missingNumber(new int[]{0,1,2}));
		System.out.println("**"+missingNumber(new int[]{0,1,3}));
		System.out.println("**"+missingNumber(new int[]{1,2,3}));

	}

	public static int missingNumber(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int n=nums.length;
		int sum=n*(n+1)/2;
		int arraySum=0;
		for (int i = 0; i < nums.length; i++) {
			arraySum+=nums[i];
		}
		return sum-arraySum;
	}
}
