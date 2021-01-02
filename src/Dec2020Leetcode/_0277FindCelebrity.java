package Dec2020Leetcode;

public class _0277FindCelebrity {

	public static void main(String[] args) {
		System.out.println(findCelebrity(3));
	}

	static boolean knows(int a, int b) {
		return true;
	}

	public static int findCelebrity(int n) {
		boolean[] knows = new boolean[n];

		for (int i = 0; i < knows.length; i++) {
			if (knows[i])
				continue;
			for (int j = 0; j < knows.length; j++) {
				if (i == j)
					continue;
				if (knows(i, j)) {
					knows[i] = true;
					break;
				}
			}
		}

		for (int i = 0; i < knows.length; i++) {
			if (!knows[i])
				return i;
		}
		return -1;
	}

}
