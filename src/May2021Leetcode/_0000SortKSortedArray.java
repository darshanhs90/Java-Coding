package May2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _0000SortKSortedArray {
	// https://leetcode.com/discuss/interview-question/1170063/Facebook-Phone-Interview
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 4, 5, 2, 3, 7, 8, 6, 10, 9);
		int k = 2;

		System.out.println(sortKSortedArray(list, k));
	}

	public static List<Integer> sortKSortedArray(List<Integer> list, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i = 0; i <= k; i++) {
			pq.offer(list.get(i));
		}
		List<Integer> out = new ArrayList<Integer>();
		for (int i = k + 1; i < list.size(); i++) {
			out.add(pq.poll());
			pq.offer(list.get(i));
		}

		while (!pq.isEmpty()) {
			out.add(pq.poll());
		}
		return out;
	}
}
