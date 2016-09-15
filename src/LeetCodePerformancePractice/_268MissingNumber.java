package LeetCodePerformancePractice;

public class _268MissingNumber {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(missingNumber(new int[]{0,1,2}));
	}
	public static int missingNumber(int[] nums) {
		if(nums==null||nums.length==0)
			return -1;
		int sum=0;
		for (int i = 0; i < nums.length; i++) {
			sum+=nums[i];
		}
		int n=nums.length;
		return n*(n+1)/2 -sum;
	}

}
