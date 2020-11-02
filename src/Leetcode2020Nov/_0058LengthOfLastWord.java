package Leetcode2020Nov;

public class _0058LengthOfLastWord {

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord(" "));
	}

	public static int lengthOfLastWord(String s) {
		String[] wordSplit = s.split(" ");
		return wordSplit.length > 0 ? wordSplit[wordSplit.length - 1].length() : 0;
	}
}
