package Dec2020_HackerRankPrepKit;

public class _003JumpingOnTheClouds {

	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[] { 0, 0, 1, 0, 0, 1, 0 }));
		System.out.println(jumpingOnClouds(new int[] { 0, 0, 0, 1, 0, 0 }));
	}

	public static int jumpingOnClouds(int[] c) {
		int currIndex = 0;
		int count = 0;
		while (currIndex < c.length - 1) {
			if (currIndex + 2 >= c.length - 1) {
				count++;
				currIndex += 2;
			} else {
				if (c[currIndex + 2] == 0) {
					count++;
					currIndex += 2;
				} else {
					count++;
					currIndex += 1;
				}
			}
		}
		return count;
	}
}
