package Jan2021Leetcode;

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
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return (o1.x + o1.y) - (o2.x + o2.y);
			}
		});

		for (int i = 0; i < nums1.length; i++) {
			for (int j = 0; j < nums2.length; j++) {
				pq.offer(new Pair(nums1[i], nums2[j]));
				//if (pq.size() > k)
				//	pq.poll();
			}
		}
		
		List<List<Integer>> lst = new ArrayList<List<Integer>>();
		while (!pq.isEmpty() && k>0) {
			Pair p = pq.poll();
			lst.add(new ArrayList<Integer>(Arrays.asList(p.x, p.y)));
			k--;
		}
		return lst;
	}

}
