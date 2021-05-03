package May2021PrepLeetcode;

import java.util.Arrays;

public class _0689MaximumSumOf3NonOverlappingSubarrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2)));
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 1, 2, 1, 2, 1 }, 2)));
	}

	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int sum = 0;
		int[] sdSum = new int[nums.length];
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (i >= k) {
				sum -= nums[left];
				left++;
			}
			sdSum[i] = sum;
		}

		int[] leftMax = new int[nums.length];
		int[] rightMax = new int[nums.length];

		int maxIndex = 0;
		for (int i = 1; i < nums.length; i++) {
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
		int maxSum = 0;
		int[] res = new int[3];
		int n = nums.length;
		for (int mid = 2 * k - 1; mid <= n - k - 1; mid++) {
			int leftIndex = leftMax[mid - k];
			int rightIndex = rightMax[mid + k];

			int sumVal = sdSum[leftIndex] + sdSum[rightIndex] + sdSum[mid];
			if (sumVal > maxSum) {
				maxSum = sumVal;
				res[0] = leftIndex - k + 1;
				res[1] = mid - k + 1;
				res[2] = rightIndex - k + 1;
			}
		}
		return res;
	}
}
