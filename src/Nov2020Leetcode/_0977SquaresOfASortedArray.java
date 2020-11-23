package Nov2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _0977SquaresOfASortedArray {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(sortedSquares(new int[] { -4, -1, 0, 3, 10 })));
		System.out.println(Arrays.toString(sortedSquares(new int[] { -7, -3, 2, 3, 11 })));
	}

	public static int[] sortedSquares(int[] A) {
		Integer[] arr = new Integer[A.length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = A[i];
		}
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return Math.abs(o1) - Math.abs(o2);
			}
		});

		for (int i = 0; i < arr.length; i++) {
			A[i] = arr[i] * arr[i];
		}
		return A;
	}
}
