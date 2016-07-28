package eBayPrep;

public class _198HouseRobber {

	public static void main(String[] args) {
		System.out.println(rob(new int[]{50,1,1,50}));
	}
	public static int rob(int[] nums) {
		int even=0,odd=0;
		for (int i = 0; i < nums.length; i++) {
			if(i%2==0)
			{
				even+=nums[i];	
				even=Math.max(even, odd);
			}
			else{
				odd+=nums[i];
				odd=Math.max(even, odd);
			}
		}
		return Math.max(even, odd);
	}
}

