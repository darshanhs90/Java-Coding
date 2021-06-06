package June2021GoogLeetcode;

import java.util.Arrays;

public class _02593SumSmaller {

	public static void main(String[] args) {
		System.out.println(threeSumSmaller(new int[] { -2, 0, 1, 3 }, 2));
		System.out.println(threeSumSmaller(new int[] {}, 0));
		System.out.println(threeSumSmaller(new int[] { 0 }, 0));

	}

	public static int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];
				if (sum >= target) {
					right--;
				} else {
					count+=right-left;
					left++;
				}
			}
		}
		return count;
	}

}
