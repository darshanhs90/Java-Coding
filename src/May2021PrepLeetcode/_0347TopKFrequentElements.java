package May2021PrepLeetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0347TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3, 3, 3 }, 2)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1)));
	}

	static class Pair {
		int key, val;

		public Pair(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static int[] topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.compute(nums[i], (key, val) -> val == null ? 1 : val + 1);
		}

		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.val - o1.val;
			}
		});

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		int[] out = new int[k];
		for (int i = 0; i < out.length; i++) {
			out[i] = pq.poll().key;
		}
		return out;
	}

}
