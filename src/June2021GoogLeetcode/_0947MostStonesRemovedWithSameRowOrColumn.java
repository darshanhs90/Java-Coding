package June2021GoogLeetcode;

import java.util.HashSet;

public class _0947MostStonesRemovedWithSameRowOrColumn {

	public static void main(String[] args) {
		System.out.println(removeStones(new int[][] { new int[] { 0, 0 }, new int[] { 0, 1 }, new int[] { 1, 0 },
				new int[] { 1, 2 }, new int[] { 2, 1 }, new int[] { 2, 2 } }));

		System.out.println(removeStones(new int[][] { new int[] { 0, 0 }, new int[] { 0, 2 }, new int[] { 1, 1 },
				new int[] { 2, 0 }, new int[] { 2, 2 } }));

		System.out.println(removeStones(new int[][] { new int[] { 0, 0 } }));
	}

	public static int removeStones(int[][] stones) {
	
	}
}
