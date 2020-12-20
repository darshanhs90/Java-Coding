package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _057CountOfSmallerNumbersAfterSelf {

	public static void main(String[] args) {
		System.out.println(countSmaller(new int[] { 5, 2, 6, 1 }));
	}

	static class Pair {
		int index;
		int val;

		public Pair(int index, int val) {
			this.index = index;
			this.val = val;
		}
	}

	static public List<Integer> countSmaller(int[] nums) {
		int[] smaller = new int[nums.length];
		Pair[] pair = new Pair[nums.length];
		Arrays.fill(smaller, 0);
		for (int i = 0; i < pair.length; i++) {
			pair[i] = new Pair(i, nums[i]);
		}

		mergeSort(pair, smaller);

		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < smaller.length; i++) {
			list.add(smaller[i]);
		}
		return list;
	}

	static public Pair[] mergeSort(Pair[] pair, int[] smaller) {
		if (pair.length <= 1)
			return pair;

		int mid = pair.length / 2;
		Pair[] leftPair = mergeSort(Arrays.copyOfRange(pair, 0, mid), smaller);
		Pair[] rightPair = mergeSort(Arrays.copyOfRange(pair, mid, pair.length), smaller);

		for (int i = 0, j = 0; i < leftPair.length || j < rightPair.length;) {
			if (j == rightPair.length || i < leftPair.length && leftPair[i].val <= rightPair[j].val) {
				pair[i + j] = leftPair[i];
				smaller[leftPair[i].index] += j;
				i++;
			} else {
				pair[i + j] = rightPair[j];
				j++;
			}
		}
		return pair;
	}

}
