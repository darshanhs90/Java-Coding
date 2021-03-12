package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0015ThreeSum {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum(new int[] {}));
		System.out.println(threeSum(new int[] { 0 }));
		System.out.println(threeSum(new int[] { 0, 0, 0 }));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3)
			return output;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int left = i + 1;
				int right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[left] + nums[right];
					if (sum == 0) {
						List<Integer> list = new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right]));
						output.add(list);
						left++;
						right--;

						while (left < right && nums[left] == nums[left - 1])
							left++;
					} else if (sum > 0) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
		return output;
	}

}
