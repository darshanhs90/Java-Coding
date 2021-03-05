package FacebookPortalPrep;

import java.util.Arrays;

public class _0019Sorting_BalancedSplit {

	public static void main(String[] args) {
		System.out.println(balancedSplitExists(new int[] { 1, 5, 7, 1 }));
		System.out.println(balancedSplitExists(new int[] { 12, 7, 6, 7, 61 }));
	}

	public static boolean balancedSplitExists(int[] arr) {
		// Write your code here
		Arrays.sort(arr);
		int leftMax = arr[0];
		int leftSum = arr[0];
		int rightSum = arr[arr.length - 1];
		int rightMin = rightSum;
		int left = 1, right = arr.length - 2;
		while (left <= right) {
			if (leftSum > rightSum) {
				rightSum += arr[right];
				rightMin = arr[right];
				right--;
			} else {
				leftSum += arr[left];
				leftMax = arr[left];
				left++;
			}
		}
		return leftSum == rightSum && leftMax < rightMin;
	}

	public static boolean balancedSplitExists1(int[] arr) {
		// Write your code here
		int totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum += arr[i];
		}
		if (totalSum % 2 != 0)
			return false;

		return checkIfSubsetExists(0, arr, totalSum, null);
	}

	public static boolean checkIfSubsetExists(int index, int[] arr, int targetSum, Integer currSum) {
		// Write your code here

		if (currSum != null && currSum == targetSum)
			return true;

		for (int i = index; i < arr.length; i++) {
			if (checkIfSubsetExists(i + 1, arr, targetSum, currSum == null ? arr[i] : currSum + arr[i]))
				return true;
		}
		return false;
	}
}
