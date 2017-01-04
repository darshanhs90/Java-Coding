package PracticeLeetCode;

import java.util.Arrays;

public class _075SortColors {
	public static void main(String[] args) {
		sortColors(new int[]{1,2,0,1,0,0,0,0,1,1,2,1,2});
		sortColors(new int[]{1,0});

	}
	public static void sortColors(int[] nums){
		if(nums==null||nums.length<=1)
			return;
		int low=0,mid=0,high=nums.length-1;
		while(mid<=high){
			if(nums[mid]==0)
			{
				int temp=nums[mid];
				nums[mid]=nums[low];
				nums[low]=temp;
				low++;
				mid++;
			}else if(nums[mid]==1)
			{
				mid++;
			}else{
				int temp=nums[high];
				nums[high]=nums[mid];
				nums[mid]=temp;
				high--;
			}
		}
		System.out.println(Arrays.toString(nums));

	}
}
