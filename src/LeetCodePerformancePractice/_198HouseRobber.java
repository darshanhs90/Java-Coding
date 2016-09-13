package LeetCodePerformancePractice;

public class _198HouseRobber {
	public static void main(String[] args) {
		System.out.println(rob(new int[]{50,3,3,50}));
	}
	public static int rob(int[] nums) {
		int evenSum=0,oddSum=0,sum=0;
		for (int i = 0; i < nums.length; i++) {
			if(i%2==0)
			{
				evenSum=Math.max(sum, evenSum+nums[i]);
			}else
			{
				oddSum=Math.max(sum, oddSum+nums[i]);
			}
			sum=Math.max(evenSum, oddSum);
		}
		return sum;
	}

}