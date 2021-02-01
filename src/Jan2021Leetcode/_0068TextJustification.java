package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0068TextJustification {

	public static void main(String[] args) {
		System.out.println(
				fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16));
		System.out.println(fullJustify(new String[] { "What", "must", "be", "acknowledgment", "shall", "be" }, 16));
		System.out.println(fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well", "enough",
				"to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20));
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		if (words == null || words.length == 0)
			return new ArrayList<String>();
		int currLength = words[0].length();
		int left = 0;
		List<String> output = new ArrayList<String>();
		for (int i = 1; i < words.length; i++) {
			if (currLength + 1 + words[i].length() > maxWidth) {
				output.add(justify(left, i - 1, words, maxWidth));
				left = i;
				currLength = words[i].length();
			} else {
				currLength += words[i].length() + 1;
			}
		}
		output.add(justifyLast(left, words.length - 1, words, maxWidth));
		return output;
	}

	public static String justify(int left, int right, String[] words, int maxWidth) {
		int noOfWords = right - left;
		if (noOfWords == 0)
			return justifyLast(left, right, words, maxWidth);
		int totalLength = 0;
		for (int i = left; i <= right; i++) {
			totalLength += words[i].length();
		}

		int noOfSpaces = maxWidth - totalLength;
		int regularSpaces = noOfSpaces / noOfWords;
		int extraSpaces = noOfSpaces % noOfWords;
		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]).append(regularSpacesFunc(regularSpaces)).append(regularSpacesFunc(extraSpaces--));
		}
		sb.append(words[right]);
		return sb.toString();
	}

	public static String justifyLast(int left, int right, String[] words, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]).append(" ");
		}
		sb.append(words[right]);
		while (sb.length() < maxWidth)
			sb.append(" ");
		return sb.toString();
	}

	private static String regularSpacesFunc(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= count; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

}
