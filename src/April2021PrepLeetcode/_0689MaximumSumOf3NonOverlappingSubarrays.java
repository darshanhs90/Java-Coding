package April2021PrepLeetcode;

import java.util.Arrays;

public class _0689MaximumSumOf3NonOverlappingSubarrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2)));
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 1, 2, 1, 2, 1 }, 2)));
	}

	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] sd = new int[nums.length];
		int sum = 0;
		int left = 0, right = 0;
		while (right < nums.length) {
			sum += nums[right];
			if (right >= k) {
				sum -= nums[left];
				left++;
			}
			sd[right] = sum;
			right++;
		}

		int[] leftMax = new int[nums.length];
		int[] rightMax = new int[nums.length];
		int currMaxIndex = 0;
		for (int i = 0; i < sd.length; i++) {
			if (sd[i] > sd[currMaxIndex]) {
				currMaxIndex = i;
			}
			leftMax[i] = currMaxIndex;
		}

		currMaxIndex = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (sd[i] >= sd[currMaxIndex]) {
				currMaxIndex = i;
			}
			rightMax[i] = currMaxIndex;
		}
		int[] res = new int[3];
		int n = nums.length;
		int currMax = 0;
		for (int mid = 2 * k - 1; mid <= n - k - 1; mid++) {
			int leftVal = leftMax[mid - k];
			int rightVal = rightMax[mid + k];
			int sumVal = sd[mid] + sd[leftVal] + sd[rightVal];
			if (sumVal > currMax) {
				currMax = sumVal;
				res[0] = leftMax[mid - k] - k + 1;
				res[1] = mid - k + 1;
				res[2] = rightMax[mid + k] - k + 1;
			}
		}

		return res;
	}

}
