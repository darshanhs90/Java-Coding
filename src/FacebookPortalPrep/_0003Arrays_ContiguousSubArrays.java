package FacebookPortalPrep;

import java.util.Arrays;

public class _0003Arrays_ContiguousSubArrays {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(countSubarrays(new int[] { 3, 4, 1, 6, 2 })));
	}

	public static int[] countSubarrays(int[] arr) {
		// Write your code here
		int[] out = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			out[i] += countForwardSubarrays(i, arr) + 1;
			out[i] += countBackwardSubarrays(i, arr);
		}
		return out;
	}

	public static int countBackwardSubarrays(int index, int[] arr) {
		// Write your code here
		int count = 0;
		Integer maxVal = arr[index];
		for (int i = index - 1; i >= 0; i--) {
			if (arr[i] < maxVal)
				count++;
			else {
				break;
			}
		}
		return count;
	}

	public static int countForwardSubarrays(int index, int[] arr) {
		// Write your code here
		int count = 0;
		Integer maxVal = arr[index];
		for (int i = index + 1; i < arr.length; i++) {
			if (arr[i] < maxVal)
				count++;
			else {
				break;
			}
		}
		return count;
	}

}
