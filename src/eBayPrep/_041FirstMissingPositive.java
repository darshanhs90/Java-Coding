package eBayPrep;

public class _041FirstMissingPositive {

	public static void main(String[] args) {
		System.out.println(firstMissingPositive(new int[]{2,1,0}));
		System.out.println(firstMissingPositive(new int[]{2,1}));
		System.out.println(firstMissingPositive(new int[]{0}));
		System.out.println(firstMissingPositive(new int[]{3,4,-1,1}));

	}

	public static int firstMissingPositive(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]!=i+1)
			{
				//find the index of i+1
				int j=i+1;
				while(j<nums.length && nums[j]!=i+1)
				{
					j++;
				}
				if(j>=nums.length)
					return i+1;
				else
				{
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
				}
			}
		}
		return nums.length+1;	
	}
}
