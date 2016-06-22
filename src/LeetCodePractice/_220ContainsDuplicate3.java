package LeetCodePractice;

import java.util.ArrayList;
import java.util.HashMap;

public class _220ContainsDuplicate3{
	public static void main(String[] args) {
		System.out.println(containsNearbyAlmostDuplicate(new int[]{1,3,4,5,2,4,4},3,3));
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i]))
			{
				ArrayList<Integer> aList=map.get(nums[i]);
				for (int j = 0; j < aList.size(); j++) {
					if(-aList.get(j)+i<=k && nums[i]-nums[j]<=t)
						return true;
				}
				aList.add(i);
				map.put(nums[i], aList);
			}
			else{
				ArrayList<Integer> aList=new ArrayList<>();
				aList.add(i);
				map.put(nums[i], aList);
			}
		}
		return false;
	}
}

