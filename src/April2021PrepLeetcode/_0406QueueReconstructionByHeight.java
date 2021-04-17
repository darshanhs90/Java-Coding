package April2021PrepLeetcode;

import java.util.Arrays;

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
	}

}
