package Oct2023Leetcode;

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
			int left = i + 1, right = nums.length - 1;
			int currSum = nums[i];
			while (left < right) {
				currSum = nums[i] + nums[left] + nums[right];
				if (currSum == 0) {
					List<Integer> list = new ArrayList<Integer>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					if (!set.contains(list)) {
						output.add(list);
						set.add(list);
					}
					left++;
					right--;
				} else if (currSum > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return output;
	}

}
