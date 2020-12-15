package Nov2020_GoogPrep;

import java.util.Arrays;

public class _072Candy {

	public static void main(String[] args) {
		System.out.println(candy(new int[] { 1, 0, 2 }));
		System.out.println(candy(new int[] { 1, 2, 2 }));
	}

	public static int candy(int[] ratings) {
		int[] forward = new int[ratings.length];
		int[] backward = new int[ratings.length];
		Arrays.fill(forward, 1);
		Arrays.fill(backward, 1);
		for (int i = 1; i < forward.length; i++) {
			if (ratings[i] > ratings[i - 1])
				forward[i] = forward[i - 1] + 1;
		}

		for (int i = backward.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1])
				backward[i] = backward[i + 1] + 1;
		}

		int val = 0;
		for (int i = 0; i < backward.length; i++) {
			val += Math.max(forward[i], backward[i]);
		}
		return val;
	}
}
