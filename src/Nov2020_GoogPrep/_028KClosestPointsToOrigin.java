package Nov2020_GoogPrep;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _028KClosestPointsToOrigin {

	public static void main(String[] args) {
		System.out.println(kClosest(new int[][] { new int[] { 1, 3 }, new int[] { -2, 2 } }, 1));
		System.out.println(kClosest(new int[][] { new int[] { 3, 3 }, new int[] { 5, -1 }, new int[] { -2, 4 } }, 2));

	}

	static class Points {
		int[] pointPair;
		int dist = 0;

		public Points(int[] pointPair, int dist) {
			this.pointPair = pointPair;
			this.dist = dist;
		}
	}

	public static int[][] kClosest(int[][] points, int K) {
		if (points == null || points.length == 0 || K == 0)
			return points;
		PriorityQueue<Points> q = new PriorityQueue<Points>(K, new Comparator<Points>() {
			@Override
			public int compare(Points o1, Points o2) {
				return -o1.dist + o2.dist;
			}
		});

		for (int i = 0; i < points.length; i++) {
			q.offer(new Points(points[i], points[i][0] * points[i][0] + points[i][1] * points[i][1]));
			if (q.size() > K)
				q.poll();
		}

		int[][] out = new int[q.size()][2];
		int index = 0;
		while (!q.isEmpty()) {
			Points p = q.poll();
			out[index] = p.pointPair;
			System.out.println(Arrays.toString(out[index]));
			index++;
		}
		return out;
	}
}
