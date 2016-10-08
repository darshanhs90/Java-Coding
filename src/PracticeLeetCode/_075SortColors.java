package PracticeLeetCode;

import java.util.Arrays;

public class _075SortColors {
	public static void main(String[] args) {
		sortColors(new int[]{1,2,0,1,0,0,0,0,1,1,2,1,2});
		sortColors(new int[]{1,0});
		
	}
	public static void sortColors(int[] nums) {
		if(nums==null||nums.length==0)
			return;
		int i=0,j=0,k=nums.length-1;
		while(j<=k)
		{
			if(nums[j]==0)
			{
				int temp=nums[i];
				nums[i]=nums[j];
				nums[j]=temp;
				i=i+1;
				j=j+1;
			}
			else if(nums[j]==1)
			{
				j=j+1;
			}
			else
			{
				int temp=nums[j];
				nums[j]=nums[k];
				nums[k]=temp;
				k=k-1;
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
