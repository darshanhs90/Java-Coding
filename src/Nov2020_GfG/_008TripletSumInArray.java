package Nov2020_GfG;

import java.util.Arrays;

public class _008TripletSumInArray {

	public static void main(String[] args) {
		System.out.println(hasTripletSumInArray(new int[] { 1, 4, 45, 6, 10, 8 }, 13));
		System.out.println(hasTripletSumInArray(new int[] { 1, 2, 4, 3, 6 }, 13));
	}

	static int hasTripletSumInArray(int[] arr, int sum) {
		Arrays.parallelSort(arr);
		for (int i = 0; i < arr.length; i++) {
			int num1 = arr[i];
			int left = i;
			int right = arr.length - 1;
			while (left < right) {
				int currSum = arr[left] + arr[right] + num1;
				if (currSum == sum)
					return 1;
				else if (currSum > sum) {
					right--;
				} else {
					left++;
				}
			}
		}
		return 0;
	}
}
