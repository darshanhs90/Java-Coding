package Oct2023Leetcode;

public class _1456MaximumNumberOfVowelsInASubstringOfGivenLength {
	public static void main(String[] args) {
		System.out.println(maxVowels("abciiidef", 3));
		System.out.println(maxVowels("aeiou", 2));
		System.out.println(maxVowels("leetcode", 3));
	}

	public static int maxVowels(String s, int k) {
		int currNumOfVowels = 0;
		for (int i = 0; i < k; i++) {
			if (isVowel(s.charAt(i))) {
				currNumOfVowels++;
			}
		}
		int maxNumOfVowels = currNumOfVowels;
		int index = 0;
		for (int i = k; i < s.length(); i++) {
			if (isVowel(s.charAt(index))) {
				currNumOfVowels--;
			}
			index++;
			if (isVowel(s.charAt(i))) {
				currNumOfVowels++;
			}
			maxNumOfVowels = Math.max(maxNumOfVowels, currNumOfVowels);
		}
		return maxNumOfVowels;
	}

	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}
}
