package Dec2020Leetcode;

public class _1189MaximumNumberOfBalloons {
	public static void main(String[] args) {
		System.out.println(maxNumberOfBalloons("nlaebolko"));
		System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
		System.out.println(maxNumberOfBalloons("leetcode"));
	}

	public static int maxNumberOfBalloons(String text) {
		int[] charArr = new int[26];
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			charArr[c - 'a']++;
		}

		String str = "balon";
		int out = Integer.MAX_VALUE;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'l' || c == 'o') {
				out = Math.min(out, charArr[c - 'a'] / 2);
			} else {
				out = Math.min(out, charArr[c - 'a']);
			}
		}
		return out;
	}
}
