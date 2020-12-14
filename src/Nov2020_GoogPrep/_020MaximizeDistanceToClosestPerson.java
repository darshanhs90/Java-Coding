package Nov2020_GoogPrep;

import java.util.Arrays;

public class _020MaximizeDistanceToClosestPerson {

	public static void main(String[] args) {
		System.out.println(maxDistToClosest(new int[] { 1, 0, 0, 0, 1, 0, 1 }));
		System.out.println(maxDistToClosest(new int[] { 1, 0, 0, 0 }));
		System.out.println(maxDistToClosest(new int[] { 0, 1 }));
	}

	public static int maxDistToClosest(int[] seats) {
		int[] forwardDistance = new int[seats.length];
		int[] backwardDistance = new int[seats.length];
		Arrays.fill(forwardDistance, seats.length);
		Arrays.fill(backwardDistance, seats.length);
		for (int i = 0; i < forwardDistance.length; i++) {
			if (seats[i] == 1) {
				forwardDistance[i] = 0;
			} else if (i > 0) {
				forwardDistance[i] = forwardDistance[i - 1] + 1;
			}
		}

		for (int i = backwardDistance.length - 1; i >= 0; i--) {
			if (seats[i] == 1) {
				backwardDistance[i] = 0;
			} else if (i < seats.length - 1) {
				backwardDistance[i] = backwardDistance[i + 1] + 1;
			}
		}

		int ans = 0;
		for (int i = 0; i < seats.length; i++)
			if (seats[i] == 0)
				ans = Math.max(ans, Math.min(forwardDistance[i], backwardDistance[i]));
		return ans;
	}
}
