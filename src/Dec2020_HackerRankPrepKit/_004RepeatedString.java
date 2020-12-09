package Dec2020_HackerRankPrepKit;

public class _004RepeatedString {

	public static void main(String[] args) {
		System.out.println(repeatedString("baa", 10));
		System.out.println(repeatedString("baa", 9));
		System.out.println(repeatedString("ab", 10));
	}

	public static long repeatedString(String s, long n) {
		int currCount = 0;
		int currStringLength = s.length();
		for (int i = 0; i < currStringLength && i < n; i++) {
			char c = s.charAt(i);
			if (c == 'a') {
				currCount++;
			}
		}
		if (n < currStringLength)
			return currCount;

		long output = (n * currCount) / currStringLength;
		long extraCount = (n) % currStringLength;
		for (int i = 0; i < extraCount; i++) {
			char c = s.charAt(i);
			if (c == 'a') {
				output++;
			}
		}
		return output;
	}
}
