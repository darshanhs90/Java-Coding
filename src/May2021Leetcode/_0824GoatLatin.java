package May2021Leetcode;

public class _0824GoatLatin {
	public static void main(String[] args) {
		System.out.println(toGoatLatin("I speak Goat Latin"));
		System.out.println(toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}

	public static String toGoatLatin(String S) {
		String[] sArray = S.split(" ");
		StringBuilder sb = new StringBuilder();
		String prevString = "maa";
		for (int i = 0; i < sArray.length; i++) {
			String word = sArray[i];
			if (isVowel(word.charAt(0))) {
				sb = sb.append(word);
			} else {
				sb = sb.append(word.substring(1) + word.charAt(0));
			}

			sb = sb.append(prevString);
			prevString += "a";
			if (i != sArray.length - 1) {
				sb = sb.append(" ");
			}
		}
		return sb.toString();
	}

	public static boolean isVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U';
	}
}
