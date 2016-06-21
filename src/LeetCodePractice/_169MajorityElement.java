package LeetCodePractice;

import java.util.HashMap;

public class _169MajorityElement {

	public static void main(String[] args) {
		System.out.println(majorityElement(new int[]{1,2,2,2,2,2,2,3,4}));
	}

	public static int majorityElement(int[] nums) {
		HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
		int maxVal=0,val=-1;
		if(nums.length<=1)
			return nums[0];
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i]))
			{
				map.put(nums[i], map.get(nums[i])+1);
				if(map.get(nums[i])>maxVal)
				{
					maxVal=map.get(nums[i]);
					val=nums[i];
				}
			}
			else{
				map.put(nums[i],1);
			}
		}
		return val;
		
	}
}

