package Feb2021Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _0347TopKFrequentElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1, 1, 1, 2, 2, 3, 3, 3 }, 2)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 1 }, 1)));
		System.out.println(Arrays.toString(topKFrequent(new int[] { 3, 0, 1, 0 }, 1)));
	}

	static class Pair {
		int num, count;

		public Pair(int num, int count) {
			this.num = num;
			this.count = count;
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
				return o2.count - o1.count;
			}
		});
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			pq.offer(new Pair(entry.getKey(), entry.getValue()));
		}

		int[] out = new int[k];
		int index = 0;
		while (!pq.isEmpty() && k > 0) {
			out[index++] = pq.poll().num;
			k--;
		}
		return out;
	}

}
