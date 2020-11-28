package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _004ThreeSum {

	public static void main(String[] args) {
		System.out.println(threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
		System.out.println(threeSum(new int[] {}));
		System.out.println(threeSum(new int[] { 0 }));
		System.out.println(threeSum(new int[] { 0, 0, 0 }));
		System.out.println(threeSum(new int[] { -2, 0, 1, 1, 2 }));
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3)
			return output;
		HashSet<List<Integer>> set = new HashSet<List<Integer>>();
		Arrays.parallelSort(nums);
		for (int i = 0; i <= nums.length - 3; i++) {
			int num1 = nums[i];
			int left = i + 1;
			int right = nums.length - 1;
			while (left < right) {
				int sum = num1 + nums[left] + nums[right];
				if (sum == 0) {
					List<Integer> list = new ArrayList<Integer>(Arrays.asList(num1, nums[left], nums[right]));
					if (!set.contains(list)) {
						output.add(list);
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
