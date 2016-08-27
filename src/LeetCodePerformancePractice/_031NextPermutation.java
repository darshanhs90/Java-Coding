package LeetCodePerformancePractice;

public class _031NextPermutation {
	public static void main(String[] args) {
		nextPermutation(new int[]{1,2,3});
	}
	public static void nextPermutation(int[] nums) {
		if(nums==null||nums.length<2)
			return;
		int p=0,q=0;
		for (int i = nums.length-2;i>=0;i--) {
			if(nums[i]<nums[i+1]){
				p=i;
				break;
			}
		}
		for (int i = nums.length-1;i>=0;i--) {
			if(nums[i]>nums[p])
			{
				q=i;
				break;
			}
		}
		if(p==0 && q==0)
		{
			nums=swapElements(nums, 0,nums.length-1);
		}
		else{
			int temp=nums[p];
			nums[p]=nums[q];
			nums[q]=temp;
			q=nums.length-1;
			p++;
			nums=swapElements(nums,p,q);
		}
	}


	private static int[] swapElements(int[] nums, int p, int q) {
		while(p<q)
		{
			int temp=nums[p];
			nums[p]=nums[q];
			nums[q]=temp;
			p++;
			q--;
		}

		return nums;
	}

}

