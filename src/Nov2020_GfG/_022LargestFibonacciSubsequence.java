package Nov2020_GfG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _022LargestFibonacciSubsequence {

	public static void main(String[] args) {
		System.out.println(largestFibonacciSubsequence(new int[] { 1, 4, 3, 9, 10, 13, 7 }));
		System.out.println(largestFibonacciSubsequence(new int[] { 0, 2, 8, 5, 2, 1, 4, 13, 23 }));
	}

	static List<Integer> largestFibonacciSubsequence(int[] arr) {
		int maxVal = findMax(arr);
		List<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> set = generateFibonacciNos(maxVal);
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(arr[i]))
				list.add(arr[i]);
		}
		return list;
	}

	static HashSet<Integer> generateFibonacciNos(int maxVal) {
		HashSet<Integer> set = new HashSet<Integer>();
		int fib1 = 0;
		int fib2 = 1;
		set.add(fib1);
		while (fib2 <= maxVal) {
			int sum = fib1 + fib2;
			set.add(sum);
			fib1 = fib2;
			fib2 = sum;
		}
		return set;
	}

	static int findMax(int[] arr) {
		int maxVal = arr[0];
		for (int i = 1; i < arr.length; i++) {
			maxVal = Math.max(maxVal, arr[i]);
		}
		return maxVal;
	}

}
