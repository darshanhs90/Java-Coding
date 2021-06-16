package June2021AppleLeetcode;

import java.util.List;

public class _1229MeetingScheduler {
	public static void main(String[] args) {
		System.out.println(minAvailableDuration(
				new int[][] { new int[] { 10, 50 }, new int[] { 60, 120 }, new int[] { 140, 210 } },
				new int[][] { new int[] { 0, 15 }, new int[] { 60, 70 } }, 8));
		System.out.println(minAvailableDuration(
				new int[][] { new int[] { 10, 50 }, new int[] { 60, 120 }, new int[] { 140, 210 } },
				new int[][] { new int[] { 0, 15 }, new int[] { 60, 70 } }, 12));

		System.out.println(
				minAvailableDuration(new int[][] { new int[] { 0, 2 } }, new int[][] { new int[] { 1, 3 } }, 2));
	}

	public static List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

	}
}
