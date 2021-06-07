package June2021GoogLeetcode;

import java.util.Arrays;

public class _0689MaximumSumOf3NonOverlappingSubarrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(maxSumOfThreeSubarrays(new int[] { 1, 2, 1, 2, 6, 7, 5, 1 }, 2)));
	}

	public static int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[] sdSum = new int[nums.length];
		int sum = 0;
		int left = 0;
		for (int i = 0; i < sdSum.length; i++) {
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
		leftMax[0] = 0;
		for (int i = 1; i < rightMax.length; i++) {
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
		int maxVal = Integer.MIN_VALUE;
		int n = nums.length;
		for (int mid = 2 * k - 1; mid <= n - k - 1; mid++) {

			int leftVal = leftMax[mid - k];
			int rightVal = rightMax[mid + k];

			if (sdSum[leftVal] + sdSum[rightVal] + sdSum[mid] > maxVal) {
				maxVal = sdSum[leftVal] + sdSum[rightVal] + sdSum[mid];
				res[0] = leftVal - k + 1;
				res[1] = mid - k + 1;
				res[2] = rightVal - k + 1;
			}
		}
		return res;
	}

}
