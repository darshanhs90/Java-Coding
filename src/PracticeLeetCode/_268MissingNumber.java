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
		int arrSum=0;
		for (int i = 0; i < nums.length; i++) {
			arrSum+=nums[i];
		}
		int newSum=(nums.length)*(nums.length+1)/2;
		return -arrSum+newSum;
	}
}
