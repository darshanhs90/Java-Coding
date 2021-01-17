package Dec2020Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class _1024VideoStitching {
	// https://www.youtube.com/watch?v=Gg64QXc9K0s
	public static void main(String[] args) {
		System.out.println(videoStitching(new int[][] { new int[] { 0, 2 }, new int[] { 4, 6 }, new int[] { 8, 10 },
				new int[] { 1, 9 }, new int[] { 1, 5 }, new int[] { 5, 9 } }, 10));

		System.out.println(videoStitching(new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } }, 5));

		System.out.println(videoStitching(new int[][] { new int[] { 0, 1 }, new int[] { 6, 8 }, new int[] { 0, 2 },
				new int[] { 5, 6 }, new int[] { 0, 4 }, new int[] { 0, 3 }, new int[] { 6, 7 }, new int[] { 1, 3 },
				new int[] { 4, 7 }, new int[] { 1, 4 }, new int[] { 2, 5 }, new int[] { 2, 6 }, new int[] { 3, 4 },
				new int[] { 4, 5 }, new int[] { 5, 7 }, new int[] { 6, 9 } }, 9));

		System.out.println(videoStitching(new int[][] { new int[] { 0, 4 }, new int[] { 2, 8 } }, 5));
	}

	public static int videoStitching(int[][] clips, int T) {
		Arrays.sort(clips, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[0] - o2[0];
			}
		});
		int min = 0, max = 0, count = 0;
		while (max < T) {
			int prevMax = max;
			for (int i = 0; i < clips.length; i++) {
				int left = clips[i][0];
				int right = clips[i][1];

				if (left <= min && right > max) {
					max = right;
				}
			}
			if (max == prevMax)
				return -1;
			min = max;
			count++;
		}
		return count;
	}

}
