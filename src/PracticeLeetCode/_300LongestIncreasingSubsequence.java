package PracticeLeetCode;

public class _300LongestIncreasingSubsequence {
	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
	}a
	public static int lengthOfLIS(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int max[]=new int[nums.length];
		int result=1;
		for (int i = 0; i < max.length; i++) {
			max[i]=1;
			for (int j = 0; j < i; j++) {
				if(nums[i]>nums[j])
				{
					max[i]=Math.max(max[i],max[j]+1);
				}
			}
			result=Math.max(result, max[i]);
		}
		return result;
	}

}
