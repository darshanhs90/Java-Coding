package May2021Leetcode;

public class _0999AvailableCapturesForRook {

	public static void main(String[] args) {
		System.out.println(numRookCaptures(new char[][] { new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'R', '.', '.', '.', 'p' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' } }));

		System.out.println(numRookCaptures(new char[][] { new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
				new char[] { '.', 'p', 'p', 'B', 'p', 'p', '.', '.' },
				new char[] { '.', 'p', 'B', 'R', 'B', 'p', '.', '.' },
				new char[] { '.', 'p', 'p', 'B', 'p', 'p', '.', '.' },
				new char[] { '.', 'p', 'p', 'p', 'p', 'p', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' } }));

		System.out.println(numRookCaptures(new char[][] { new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { 'p', 'p', '.', 'R', '.', 'p', 'B', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'B', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', 'p', '.', '.', '.', '.' },
				new char[] { '.', '.', '.', '.', '.', '.', '.', '.' } }));

	}

	public static int numRookCaptures(char[][] board) {

	}
}
