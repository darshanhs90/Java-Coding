package PracticeLeetCode;

import java.util.HashMap;
import java.util.Map;

public class _169MajorityElement {
	public static void main(String[] args) {

	}

	public static int majorityElement(int[] nums) {
		HashMap<Integer, Integer> elementMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (!elementMap.containsKey(nums[i])) {
				elementMap.put(nums[i], 1);
			} else {
				elementMap.put(nums[i], elementMap.get(nums[i]) + 1);
			}
		}
		
		int len = nums.length;
		// using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<Integer, Integer> entry : elementMap.entrySet())
		{
			if(entry.getValue() > len/2)
				return entry.getKey();
		}
		return 0;
	}

}
