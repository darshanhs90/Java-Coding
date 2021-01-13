package Dec2020Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0973KClosestPointsToOrigin {
	public static void main(String[] args) {
		System.out.println(kClosest(new int[][] { new int[] { 1, 3 }, new int[] { -2, 2 } }, 1));
		System.out.println(kClosest(new int[][] { new int[] { 3, 3 }, new int[] { 5, -1 }, new int[] { -2, 4 } }, 2));
	}

	static class Pair {
		int[] point;
		Double distanceToOrigin;

		public Pair(int[] point, Double distanceToOrigin) {
			this.point = point;
			this.distanceToOrigin = distanceToOrigin;
		}
	}

	public static int[][] kClosest(int[][] points, int K) {
		PriorityQueue<Pair> pq = new PriorityQueue<Pair>(K, new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o1.distanceToOrigin.compareTo(o2.distanceToOrigin);
			}
		});

		for (int i = 0; i < points.length; i++) {
			int x = points[i][0];
			int y = points[i][1];
			Double currDistance = getDistance(x, y);
			pq.offer(new Pair(points[i], currDistance));
		}

		int[][] out = new int[K][2];
		for (int i = 0; i < out.length; i++) {
			out[i] = pq.poll().point;
		}
		return out;
	}

	public static double getDistance(int x, int y) {
		return Math.sqrt(x * x + y * y);
	}

}
