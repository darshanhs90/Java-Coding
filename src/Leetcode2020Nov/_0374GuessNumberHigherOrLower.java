package Leetcode2020Nov;

public class _0374GuessNumberHigherOrLower {

	public static void main(String[] args) {
		System.out.println(guessNumber(10));
	}

	public static int guess(int num) {
		if (num == 3) {
			return 0;
		} else if (num > 3) {
			return -11;
		} else {
			return 1;
		}
	}

	public static int guessNumber(int n) {
		int leftIndex = 1;
		int rightIndex = n;
		while (leftIndex < rightIndex) {
			int mid = leftIndex + (-leftIndex + rightIndex) / 2;
			if (guess(mid) == 0)
				return mid;
			else if (guess(mid) == -1) {
				rightIndex = mid - 1;
			} else {
				leftIndex = mid + 1;
			}
		}
		return leftIndex;
	}
}
