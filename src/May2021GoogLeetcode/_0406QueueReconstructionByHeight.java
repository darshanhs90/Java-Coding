package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class _0406QueueReconstructionByHeight {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(reconstructQueue(new int[][] { new int[] { 7, 0 }, new int[] { 4, 4 },
				new int[] { 7, 1 }, new int[] { 5, 0 }, new int[] { 6, 1 }, new int[] { 5, 2 } })));

		System.out.println(Arrays.deepToString(reconstructQueue(new int[][] { new int[] { 6, 0 }, new int[] { 5, 0 },
				new int[] { 4, 0 }, new int[] { 3, 2 }, new int[] { 2, 2 }, new int[] { 1, 4 } })));
	}

	public static int[][] reconstructQueue(int[][] people) {
		Arrays.sort(people, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o2[0] - o1[0];
			}
		});
		List<int[]> list = new ArrayList<int[]>();
		for (int[] person : people) {
			list.add(person[1], person);
		}
		return list.toArray(new int[list.size()][2]);
	}

}
