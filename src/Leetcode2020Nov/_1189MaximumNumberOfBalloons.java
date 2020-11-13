package Leetcode2020Nov;

public class _1189MaximumNumberOfBalloons {
	public static void main(String[] args) {
		System.out.println(maxNumberOfBalloons("nlaebolko"));
		System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
		System.out.println(maxNumberOfBalloons("leetcode"));
	}

	public static int maxNumberOfBalloons(String text) {
		int[] charArr = new int[26];
		for (int i = 0; i < text.length(); i++) {
			charArr[text.charAt(i) - 'a']++;
		}
		int count = 0;
		text = "balloon";
		while(true)
		{
			for (int i = 0; i < text.length(); i++) {
				charArr[text.charAt(i) - 'a']--;
				if(charArr[text.charAt(i) - 'a'] < 0)
				{
					return count;
				}
			}
			count++;
		}
	}

}
