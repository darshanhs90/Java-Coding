package Jan2021Leetcode;

public class _0135Candy {

	public static void main(String[] args) {
		System.out.println(candy(new int[] { 1, 0, 2 }));
		System.out.println(candy(new int[] { 1, 2, 2 }));
	}

	public static int candy(int[] ratings) {
		int[] leftMax = new int[ratings.length];
		int[] rightMax = new int[ratings.length];

		leftMax[0] = 1;
		for (int i = 1; i < rightMax.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				leftMax[i] = leftMax[i - 1] + 1;
			} else {
				leftMax[i] = 1;
			}
		}

		rightMax[ratings.length - 1] = 1;
		for (int i = rightMax.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				rightMax[i] = rightMax[i + 1] + 1;
			} else {
				rightMax[i] = 1;
			}
		}

		int count = 0;
		for (int i = 0; i < rightMax.length; i++) {
			count += Math.max(leftMax[i], rightMax[i]);
		}
		return count;
	}
}
