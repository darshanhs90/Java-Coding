package PracticeLeetCode;

public class _198HouseRobber {
	public static void main(String[] args) {
		System.out.println(rob(new int[]{50,3,3,50}));
	}
	public static int rob(int[] nums) {
		int oddSum=0,evenSum=0,sum=0;
		for (int i = 0; i < nums.length; i++) {
			if(i%2==0)
			{
				evenSum=Math.max(evenSum+nums[i], sum);
			}
			else{
				oddSum=Math.max(oddSum+nums[i], sum);
			}
			sum=Math.max(evenSum, oddSum);
		}
		return sum;
	}
//evensum=50
//sum=50
	


}