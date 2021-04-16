package April2021Leetcode;

import java.util.Arrays;

public class _0689MaximumSumOf3NonOverlappingSubarrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2)));
	}

	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] sdSum = new int[nums.length];
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i >= k) {
				sum -= nums[i-k];
			}
			sdSum[i] = sum;
		}

		int leftMax[] = new int[nums.length];
		int rightMax[] = new int[nums.length];
		int currMaxIdx = 0;
		for (int i = 0; i < rightMax.length; i++) {
			if (sdSum[i] > sdSum[currMaxIdx]) {
				currMaxIdx = i;
			}
			leftMax[i] = currMaxIdx;
		}

		currMaxIdx = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (sdSum[i] >= sdSum[currMaxIdx]) {
				currMaxIdx = i;
			}
			rightMax[i] = currMaxIdx;
		}
		int currMax = -1;
		int[] res = new int[3];
		for (int mid = 2 * k - 1; mid < nums.length - k; mid++) {
			int leftSum = sdSum[leftMax[mid - k]];
			int midSum = sdSum[mid];
			int rightSum = sdSum[rightMax[mid + k]];
			if (leftSum + rightSum + midSum > currMax) {
				currMax = leftSum + rightSum + midSum;
				res[0] = leftMax[mid - k] - k + 1;
				res[1] = mid - k + 1;
				res[2] = rightMax[mid + k] - k + 1;
			}

		}

		return res;
	}

}
