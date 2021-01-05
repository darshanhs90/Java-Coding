package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _0373FindKPairsWithSmallestSums {

	public static void main(String[] args) {
		System.out.println(kSmallestPairs(new int[] { 1, 7, 11 }, new int[] { 2, 4, 6 }, 3));
		System.out.println(kSmallestPairs(new int[] { 1, 1, 2 }, new int[] { 1, 2, 3 }, 2));
		System.out.println(kSmallestPairs(new int[] { 1, 2 }, new int[] { 3 }, 3));

	}

	static class Pair {
		int num1, num2, sum;

		public Pair(int num1, int num2, int sum) {
			this.num1 = num1;
			this.num2 = num2;
			this.sum = sum;
		}

	}

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Pair> pairs = new PriorityQueue<Pair>(new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.sum - o1.sum;
			}
		});

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				int diff = nums1[i] + nums2[j];
				if (pairs.size() < k) {
					pairs.offer(new Pair(nums1[i], nums2[j], diff));
				} else {
					pairs.offer(new Pair(nums1[i], nums2[j], diff));
					pairs.poll();
				}
			}
		}
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		while (!pairs.isEmpty()) {
			Pair p = pairs.poll();
			output.add(new ArrayList<Integer>(Arrays.asList(p.num1, p.num2)));
		}
		return output;
	}

}
