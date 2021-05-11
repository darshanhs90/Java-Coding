package May2021Leetcode;

import java.util.Arrays;

public class _0689MaximumSumOf3NonOverlappingSubarrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2)));
	}

	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] sdSum = new int[nums.length];
		int left = 0, right = 0;
		int sum = 0;
		while (right < nums.length) {
			sum += nums[right];
			if (right >= k) {
				sum -= nums[left];
				left++;
			}
			sdSum[right] = sum;
			right++;
		}

		int[] leftMax = new int[nums.length];
		int[] rightMax = new int[nums.length];
		int maxIndex = 0;
		for (int i = 1; i < sdSum.length; i++) {
			if (sdSum[i] > sdSum[maxIndex]) {
				maxIndex = i;
			}
			leftMax[i] = maxIndex;
		}
		maxIndex = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (sdSum[i] >= sdSum[maxIndex]) {
				maxIndex = i;
			}
			rightMax[i] = maxIndex;
		}

		int[] res = new int[3];
		int maxSum = Integer.MIN_VALUE;
		for (int mid = 2 * k - 1; mid <= nums.length - k - 1; mid++) {
			int leftIndex = leftMax[mid - k];
			int midIndex = mid;
			int rightIndex = rightMax[mid + k];
			int sumVal = sdSum[leftIndex] + sdSum[midIndex] + sdSum[rightIndex];

			if (sumVal > maxSum) {
				maxSum = sumVal;
				int leftRes = leftIndex - k + 1;
				int midRes = mid - k + 1;
				int rightRes = rightIndex - k + 1;

				res[0] = leftRes;
				res[1] = midRes;
				res[2] = rightRes;
			}
		}
		return res;
	}

}
