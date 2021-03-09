package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _0658FindKClosestElements {

	public static void main(String[] args) {
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, 3));
		System.out.println(findClosestElements(new int[] { 1, 2, 3, 4, 5 }, 4, -1));
	}

	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				int diff1 = Math.abs(o1 - x);
				int diff2 = Math.abs(o2 - x);

				if (diff1 == diff2)
					return o1 - o2;
				return diff1 - diff2;
			}
		});

		for (int i = 0; i < arr.length; i++) {
			pq.offer(arr[i]);
		}

		List<Integer> output = new ArrayList<Integer>();
		while (!pq.isEmpty() && k > 0) {
			output.add(pq.poll());
			k--;
		}
		Collections.sort(output);
		return output;
	}

}
