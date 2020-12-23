package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
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
		if (nums.length < 3)
			return output;
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			int val = nums[i];
			while (left < right) {
				int sum = val + nums[left] + nums[right];
				if (sum == 0) {
					list = new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right]));
					if (!set.contains(list)) {
						output.add(new ArrayList<Integer>(list));
						set.add(list);
					}
					left++;
					right--;
				} else if (sum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return output;
	}

}
