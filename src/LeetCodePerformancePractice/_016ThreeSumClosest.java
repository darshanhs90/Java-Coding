package LeetCodePerformancePractice;

import java.util.Arrays;

public class _016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1,2,1 ,4},1));
	}
	public static int threeSumClosest(int[] nums, int target) {
		int min=Integer.MAX_VALUE;
		Arrays.sort(nums);
		int result=0;
		for (int i = 0; i < nums.length; i++) {
			int j=i+1;
			int k=nums.length-1;
			while(j<k)
			{	
				int sum=nums[i]+nums[j]+nums[k];
				int diff=Math.abs(-target+sum);
				if(diff==0)return sum;
				if(diff<min){
					min=diff;
					result=sum;
				}
				if(sum>target)
					k--;
				else
					j++;	
			}
		}
		return result;
	}
}
