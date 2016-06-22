package LeetCodePractice;

public class _238ProductofArrayExceptSelf{
	/*public int[] productExceptSelf(int[] nums) {
		int product=1;
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0)
				product*=nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=0)
				nums[i]=product/nums[i];
		}
		return nums;
	}*/
	public int[] productExceptSelf(int[] nums) {
		int[] output=new int[nums.length];
		int[] temp1=new int[nums.length];
		int[] temp2=new int[nums.length];
		temp1[0]=1;
		temp2[nums.length-1]=1;
		
		for (int i = 0; i < temp2.length-1; i++) {
			temp1[i+1]=nums[i]*temp1[i];
		}
		for (int i = nums.length-1; i >0; i--) {
			temp2[i-1]=nums[i]*temp2[i];
		}
		for (int i = 0; i < temp2.length; i++) {
			output[i]=temp1[i]*temp2[i];
		}
		return output;
	}
}

