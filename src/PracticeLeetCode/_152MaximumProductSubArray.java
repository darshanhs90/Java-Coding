package PracticeLeetCode;

public class _152MaximumProductSubArray {
	public static void main(String[] args) {
		System.out.println(maxProduct(new int[]{-2,3,-4}));
		System.out.println(maxProduct(new int[]{2,3,-2,4}));

	}
	public static int maxProduct(int[] nums) {
		if(nums==null||nums.length==0)
			return 0;
		int[] max=new int[nums.length];
		int[] min=new int[nums.length];
		max[0]=nums[0];
		min[0]=nums[0];
		int res=nums[0];
		for (int i = 1; i < min.length; i++) {
			if(nums[i]>0)
			{
				max[i]=Math.max(max[i-1]*nums[i], nums[i]);
				min[i]=Math.min(min[i-1]*nums[i], nums[i]);

			}else{
				max[i]=Math.max(min[i-1]*nums[i], nums[i]);
				min[i]=Math.min(max[i-1]*nums[i], nums[i]);
			}
			res=Math.max(res, max[i]);
		}
		return res;
	}

}
