package June2021GoogLeetcode;

import java.util.Arrays;

public class _0849MaximizeDistanceToClosestPerson {
	public static void main(String[] args) {
		System.out.println(maxDistToClosest(new int[] { 1, 0, 0, 0, 1, 0, 1 }));
		System.out.println(maxDistToClosest(new int[] { 1, 0, 0, 0 }));
		System.out.println(maxDistToClosest(new int[] { 0, 1 }));
	}

	public static int maxDistToClosest(int[] seats) {
		int[] left = new int[seats.length];
		int[] right = new int[seats.length];
		Arrays.fill(left, seats.length);
		Arrays.fill(right, seats.length);

		for (int i = 0; i < seats.length; i++) {
			if (seats[i] == 1) {
				left[i] = 0;
			} else if (i > 0) {
				left[i] = left[i - 1] + 1;
			}
		}

		for (int i = seats.length - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				right[i] = 0;
			} else if (i + 1 < seats.length) {
				right[i] = right[i + 1] + 1;
			}
		}

		int maxDist = 0;
		for (int i = 0; i < right.length; i++) {
			if (seats[i] == 1)
				continue;
			maxDist = Math.max(maxDist, Math.min(left[i], right[i]));
		}
		return maxDist;
	}

}
