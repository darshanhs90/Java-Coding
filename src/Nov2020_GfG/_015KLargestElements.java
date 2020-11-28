package Nov2020_GfG;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _015KLargestElements {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(kLargest(new int[] { 12, 5, 787, 1, 23 }, 5, 2)));
		System.out.println(Arrays.toString(kLargest(new int[] { 1, 23, 12, 9, 30, 2, 50 }, 7, 3)));
	}

	static int[] kLargest(int[] arr, int n, int k) {
		if (k <= 0)
			return null;
		int[] output = new int[k];
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(k, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2.compareTo(o1);
			}
		});

		for (int i = 0; i < arr.length; i++) {
			q.offer(arr[i]);
		}
		for (int i = 0; i < k; i++) {
			output[i] = q.poll();
		}
		return output;
	}
}
