package Nov2020Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0448FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		System.out.println(findDisappearedNumbers(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
		System.out.println(findDisappearedNumbers(new int[] { 1, 1 }));
	}

	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			nums[index] = Math.abs(nums[index]) * -1;
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				output.add(i + 1);
			}
		}
		return output;
	}
}
