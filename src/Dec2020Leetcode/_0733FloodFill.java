package Dec2020Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class _0733FloodFill {
	public static void main(String[] args) {
		int[][] out = floodFill(new int[][] { new int[] { 1, 1, 1 }, new int[] { 1, 1, 0 }, new int[] { 1, 0, 1 } }, 1,
				1, 2);
		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}

		out = floodFill(new int[][] { new int[] { 0, 0, 0 }, new int[] { 0, 1, 1 } }, 1, 1, 1);
		for (int i = 0; i < out.length; i++) {
			System.out.println(Arrays.toString(out[i]));
		}
	}

	static class Pair {
		int x, y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		HashMap<Integer, HashSet<Integer>> visitedSet = new HashMap<Integer, HashSet<Integer>>();
		
		if(image[sr][sc] == newColor)
			return image;
		
		int originalColor = image[sr][sc];
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(sr, sc));
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pair p = q.poll();
				int x = p.x;
				int y = p.y;
				image[x][y] = newColor;
				if (visitedSet.containsKey(x)) {
					visitedSet.get(x).add(y);
				} else {
					HashSet<Integer> set = new HashSet<Integer>();
					set.add(y);
					visitedSet.put(x, set);
				}

				if (x - 1 >= 0 && image[x - 1][y] == originalColor
						&& (!visitedSet.containsKey(x - 1) || !visitedSet.get(x - 1).contains(y))) {
					q.offer(new Pair(x - 1, y));
				}

				if (x + 1 < image.length && image[x + 1][y] == originalColor
						&& (!visitedSet.containsKey(x + 1) || !visitedSet.get(x + 1).contains(y))) {
					q.offer(new Pair(x + 1, y));
				}

				if (y - 1 >= 0 && image[x][y - 1] == originalColor && (!visitedSet.get(x).contains(y - 1))) {
					q.offer(new Pair(x, y - 1));
				}

				if (y + 1 < image[0].length && image[x][y + 1] == originalColor
						&& (!visitedSet.get(x).contains(y + 1))) {
					q.offer(new Pair(x, y + 1));
				}
			}
		}
		return image;
	}

}
