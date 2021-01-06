package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class _0506RelativeRanks {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(findRelativeRanks(new int[] { 5, 4, 3, 2, 1 })));
		System.out.println(Arrays.toString(findRelativeRanks(new int[] { 1, 2, 5, 4, 3 })));
	}

	public static String[] findRelativeRanks(int[] nums) {
		HashMap<Integer, Integer> valueIndexMap = new HashMap<Integer, Integer>();
		TreeSet<Integer> set = new TreeSet<Integer>(Collections.reverseOrder());
		String[] output = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			valueIndexMap.put(nums[i], i);
			set.add(nums[i]);
		}

		Iterator<Integer> iter = set.iterator();
		int count = 1;
		while (iter.hasNext()) {
			int val = iter.next();
			int index = valueIndexMap.get(val);
			if (count == 1) {
				output[index] = "Gold Medal";
			} else if (count == 2) {

				output[index] = "Silver Medal";
			} else if (count == 3) {

				output[index] = "Bronze Medal";
			} else {
				output[index] = count + "";
			}
			count++;
		}
		return output;
	}
}
