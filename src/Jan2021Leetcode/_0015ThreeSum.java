package Jan2021Leetcode;

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
		Arrays.sort(nums);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			int startVal = nums[i];
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = startVal + nums[left] + nums[right];
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>(Arrays.asList(startVal, nums[left], nums[right]));
					if (!set.contains(list)) {
						set.add(list);
						output.add(list);
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
