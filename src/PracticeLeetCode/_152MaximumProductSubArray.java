package PracticeLeetCode;

public class _152MaximumProductSubArray {
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{-2,3,-4}));
	}
	public static int maxProduct(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int max[]=new int[nums.length];
		int min[]=new int[nums.length];
		int res=nums[0];
		max[0]=nums[0];
		min[0]=nums[0];
		for (int i = 1; i < nums.length; i++) {
			if(nums[i]>0)
			{
				max[i]=Math.max(nums[i], max[i-1]*nums[i]);
				min[i]=Math.min(nums[i], min[i-1]*nums[i]);
			}
			else{
				max[i]=Math.min(nums[i], max[i-1]*nums[i]);
				min[i]=Math.max(nums[i], min[i-1]*nums[i]);
			}
			res=Math.max(min[i], max[i]);
		}
		return res;
	}
	
	
	//3,-6
	//
}
