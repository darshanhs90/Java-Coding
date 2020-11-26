package Nov2020Leetcode;

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

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0)
			return output;

		PriorityQueue<List<Integer>> q1 = new PriorityQueue<List<Integer>>(new Comparator<List<Integer>>() {

			@Override
			public int compare(List<Integer> o1, List<Integer> o2) {
				// TODO Auto-generated method stub
				return o1.get(0) + o1.get(1) - (o2.get(0) + o2.get(1));
			}
		});
		for (int i = 0; i < nums1.length && i < k; i++) {
			q1.offer(new ArrayList<Integer>(Arrays.asList(nums1[i], nums2[0], 0)));
		}

		while (!q1.isEmpty() && k > 0) {
			List<Integer> list = q1.poll();
			output.add(new ArrayList<Integer>(Arrays.asList(list.get(0), list.get(1))));
			k--;
			int index = list.get(2);
			if (index == nums2.length - 1)
				continue;
			q1.offer(new ArrayList<Integer>(Arrays.asList(list.get(0), nums2[index + 1], index + 1)));

		}
		return output;
	}

}
