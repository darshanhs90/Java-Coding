package Dec2020Leetcode;

public class _0374GuessNumberHigherOrLower {

	public static void main(String[] args) {
		System.out.println(guessNumber(10));
	}

	static int guess(int num) {
		return num;
	}

	public static int guessNumber(int n) {
		int left = 1, right = n;
		while (left <= right) {
			int mid = left + (right-left) / 2;
			int val = guess(mid);
			if (val == 0)
				return mid;
			else if (val == -1) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

}
