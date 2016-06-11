package LeetCodePractice;

import java.util.Arrays;

public class _016ThreeSumClosest {

	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{1,1,1,1},3));
	}
	public static int threeSumClosest(int[] nums, int target) {
		int posDiff=Integer.MAX_VALUE;
		int negDiff=Integer.MIN_VALUE;
		if(nums.length==3)
			return nums[0]+nums[1]+nums[2];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			int pointer=i;
			int left=0;
			int right=nums.length-1;
			while(left<right)
			{
				if(left==pointer){
					left++;
					continue;
				}

				if(right==pointer)
				{
					right--;
					continue;
				}

				int diff=nums[left]+nums[right]+nums[pointer]-target;
				//System.out.println(nums[left]+"/"+nums[right]+"/"+nums[pointer]+"/"+diff);
				if(diff>0)
				{
					posDiff=Math.min(diff,posDiff);
					right--;
				}
				else if(diff<0)
				{
					negDiff=Math.max(diff,negDiff);
					left++;
				}
				else
					return target;
			}
		}
		int value=Math.min(posDiff+target,-negDiff+target);
		return value==Integer.MIN_VALUE?nums[0]:value;
	}
}
