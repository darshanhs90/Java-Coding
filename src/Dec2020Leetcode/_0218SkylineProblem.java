package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _0218SkylineProblem {
	// https://www.youtube.com/watch?v=GSBLe8cKu0s
	public static void main(String[] args) {
		System.out.println(getSkyline(new int[][] { new int[] { 2, 9, 10 }, new int[] { 3, 7, 15 },
				new int[] { 5, 12, 12 }, new int[] { 15, 20, 10 }, new int[] { 19, 24, 8 } }));

		System.out.println(getSkyline(new int[][] { new int[] { 0, 2, 3 }, new int[] { 2, 5, 3 } }));

		System.out.println(getSkyline(new int[][] { new int[] { 1, 3, 4 }, new int[] { 3, 4, 4 }, new int[] { 2, 6, 2 },
				new int[] { 8, 11, 4 }, new int[] { 7, 9, 3 }, new int[] { 10, 11, 2 } }));

	}

	static class BuildingPoint {
		int x;
		int height;
		boolean isStart;

		public BuildingPoint(int x, int height, boolean isStart) {
			this.x = x;
			this.height = height;
			this.isStart = isStart;
		}
	}

	public static List<List<Integer>> getSkyline(int[][] buildings) {
		BuildingPoint[] points = new BuildingPoint[buildings.length * 2];
		int index = 0;
		for (int[] building : buildings) {
			int start = building[0];
			int end = building[1];
			int height = building[2];
			points[index] = new BuildingPoint(start, height, true);
			points[index + 1] = new BuildingPoint(end, height, false);
			index += 2;
		}

		Arrays.sort(points, new Comparator<BuildingPoint>() {
			@Override
			public int compare(BuildingPoint a, BuildingPoint b) {

				if (a.x != b.x) {
					return a.x - b.x;
				} else {
					if (a.isStart && b.isStart) {
						return b.height - a.height;
					} else if (!a.isStart && !b.isStart) {
						return a.height - b.height;
					} else if (a.isStart) {
						return -1;
					} else {
						return 1;
					}
				}
			}
		});

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int maxVal = 0;
		pq.offer(0);
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (BuildingPoint point : points) {
			if (point.isStart) {
				pq.offer(point.height);
				int currMaxVal = pq.peek();
				if (currMaxVal > maxVal) {
					maxVal = currMaxVal;
					output.add(new ArrayList<Integer>(Arrays.asList(point.x, point.height)));
				}
			} else {
				pq.remove(point.height);
				int currMaxVal = pq.peek();
				if (currMaxVal < maxVal) {
					maxVal = currMaxVal;
					output.add(new ArrayList<Integer>(Arrays.asList(point.x, currMaxVal)));

				}
			}
		}
		return output;
	}
}
