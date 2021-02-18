package Jan2021Leetcode;

public class _0277FindCelebrity {

	public static void main(String[] args) {
		System.out.println(findCelebrity(3));
	}

	static boolean knows(int a, int b) {
		return true;
	}

	public static int findCelebrity(int n) {
		for (int i = 0; i < n; i++) {
			if (isCelebrity(i, n))
				return i;
		}
		return -1;
	}

	public static boolean isCelebrity(int person, int n) {
		for (int i = 0; i < n && i != person; i++) {
			if (knows(person, i) || !knows(i, person))
				return false;
		}
		return true;
	}

}
