package yelpInterview;

import java.util.Arrays;
import java.util.HashSet;

public class _Leetcode11ThreeSumClosest {


	public static void main(String[] args) {
		System.out.println(threeSumClosest(new int[]{-1,2,1,-4}, 1));
	}


	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest=Integer.MAX_VALUE;
		HashSet<Integer> set=new HashSet<>();
		for (int i = 0; i < nums.length; i++) {

			int left=0;
			int right=nums.length-1;
			while(left<right)
			{
				if(left==i)
					left++;
				else if(right==i)
					right--;
				else{
					int sum=nums[left]+nums[right]+nums[i];
					if(!set.contains(sum))
					{
						closest=Math.min(closest, Math.abs(sum-target));
						set.add(sum);
					}
					if(sum>target)
					{
						right--;
					}
					else{
						left++;
					}
				}
			}	
		}
		System.out.println(Arrays.toString(set.toArray()));
		if(set.contains(target+closest))
			return target+closest;
		else
			return target-closest;

	}

}

