package DoordashPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _1383MaximumPerformanceOfATeam {
	public static void main(String[] args) {
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 2));
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 3));
		System.out.println(maxPerformance(6, new int[] { 2, 10, 3, 1, 5, 8 }, new int[] { 5, 4, 3, 9, 7, 2 }, 4));
	}

	public static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {

		List<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < efficiency.length; i++) {
			list.add(new int[] { efficiency[i], speed[i] });
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o2[0] - o1[0];
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k, (a, b) -> a - b);
		long max = 0;
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i)[1];
			pq.offer(list.get(i)[1]);
			if (pq.size() > k) {
				sum -= pq.poll();
			}

			max = Math.max(max, sum * list.get(i)[0]);
		}
		return (int) (max % (long) (1e9 + 7));
	}

}
