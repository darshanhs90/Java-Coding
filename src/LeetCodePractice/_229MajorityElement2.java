package LeetCodePractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _229MajorityElement2{
	public static void main(String[] args) {


	}
	public static List<Integer> majorityElement(int[] nums) {
		HashMap<Integer, Integer> elemCount=new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(elemCount.containsKey(nums[i]))
				elemCount.put(nums[i], elemCount.get(nums[i])+1);
			else
				elemCount.put(nums[i], 1);
		}
		Map<Integer, Integer> map = elemCount;
		List<Integer> outputList=new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
		{
			if(entry.getValue()>nums.length/3)
				outputList.add(entry.getKey());
		}
		return outputList;
	}
}

