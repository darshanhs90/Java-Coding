package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0448FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(findDisappearedNumbers(new int[] { 1, 1 }));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> output = new ArrayList<Integer>();
		if(nums.length == 0)
			return output;
		for (int i = 0; i < nums.length; i++) {
			int newIndex = Math.abs(nums[i]);
			if (newIndex == nums.length) {
				nums[0] = -1 * Math.abs(nums[0]);
			} else {
				nums[newIndex] = -1 * Math.abs(nums[newIndex]);
			}
		}

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > 0)
				output.add(i);
		}
		if (nums[0] > 0)
			output.add(nums.length);
		return output;
	}
}
