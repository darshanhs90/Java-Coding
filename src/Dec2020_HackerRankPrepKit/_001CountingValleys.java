package Dec2020_HackerRankPrepKit;

public class _001CountingValleys {

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
		System.out.println(countingValleys(12, "DDUUDDUDUUUD"));
	}

	public static int countingValleys(int steps, String path) {
		// Write your code here
		int numOfValleys = 0;
		int currLevel = 0;
		for (int i = 0; i < path.length(); i++) {
			char c = path.charAt(i);
			if (c == 'U') {
				currLevel++;
			} else if (c == 'D') {
				if (currLevel == 0) {
					numOfValleys++;
				}
				currLevel--;
			}
		}
		return numOfValleys;
	}
}
