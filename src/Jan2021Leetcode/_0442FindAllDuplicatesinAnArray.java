package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0442FindAllDuplicatesinAnArray {

	public static void main(String[] args) {
		System.out.println(findDuplicates(new int[] { 4, 3, 2, 7, 8, 2, 3, 1 }));
	}

	public static List<Integer> findDuplicates(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] < 0)
				list.add(index + 1);
			nums[index] = -1 * nums[index];
		}

		return list;
	}

}
