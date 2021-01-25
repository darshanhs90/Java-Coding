package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class _0406QueueReconstructionByHeight {

	public static void main(String[] args) {
		int[][] out = new int[][] { new int[] { 7, 0 }, new int[] { 4, 4 }, new int[] { 7, 1 }, new int[] { 5, 0 },
				new int[] { 6, 1 }, new int[] { 5, 2 } };
		out = reconstructQueue(out);
		printArray(out);
		out = new int[][] { new int[] { 6, 0 }, new int[] { 5, 0 }, new int[] { 4, 0 }, new int[] { 3, 2 },
				new int[] { 2, 2 }, new int[] { 1, 4 } };
		out = reconstructQueue(out);
		printArray(out);
	}

	public static void printArray(int[][] people) {
		for (int i = 0; i < people.length; i++) {
			System.out.println(Arrays.toString(people[i]));
		}

	}

	public static int[][] reconstructQueue(int[][] people) {

		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}

		});

		List<int[]> output = new LinkedList<int[]>();
		for (int[] p : people) {
			output.add(p[1], p);
		}
		return output.toArray(new int[people.length][2]);
	}

}
