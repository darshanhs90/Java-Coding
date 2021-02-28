package FacebookPrep;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0973KClosestPointsToOrigin {
	public static void main(String[] args) {
		System.out.println(kClosest(new int[][] { new int[] { 1, 3 }, new int[] { -2, 2 } }, 1));
		System.out.println(kClosest(new int[][] { new int[] { 3, 3 }, new int[] { 5, -1 }, new int[] { -2, 4 } }, 2));
	}

	public static int[][] kClosest(int[][] points, int K) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(K, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				int x1 = o1[0];
				int y1 = o1[1];
				int x2 = o2[0];
				int y2 = o2[1];
				double dist1 = Math.sqrt(x1 * x1 + y1 * y1);
				double dist2 = Math.sqrt(x2 * x2 + y2 * y2);
				return dist1 - dist2 < 0 ? 1 : -1;
			}
		});

		for (int i = 0; i < points.length; i++) {
			pq.offer(points[i]);
			if (pq.size() > K)
				pq.poll();
		}

		int[][] out = new int[K][2];
		for (int i = 0; i < out.length; i++) {
			out[i] = pq.poll();
		}

		return out;
	}

}
