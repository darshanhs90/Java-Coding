package Mar2021Leetcode;

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
		List<String> output = new ArrayList<String>();
		if (words == null || words.length == 0)
			return output;
		int left = 0;
		int currLength = 0;
		for (int right = 0; right < words.length; right++) {
			if (currLength == 0) {
				currLength += words[right].length();
			} else {
				currLength += words[right].length() + 1;
			}

			if (currLength == maxWidth) {
				output.add(justify(left, right, words, maxWidth));
				left = right + 1;
				currLength = 0;
			} else if (currLength > maxWidth) {
				output.add(justify(left, right - 1, words, maxWidth));
				left = right;
				currLength = words[right].length();
			}
		}

		if (currLength != 0) {
			output.add(justify(left, words.length - 1, words, maxWidth));
		}

		return output;
	}

	public static String justify(int left, int right, String[] words, int maxWidth) {
		if (right == words.length - 1)
			return justifyLeft(left, right, words, maxWidth);

		int noOfWords = right - left;
		int totalWidth = 0;
		for (int i = left; i <= right; i++) {
			totalWidth += words[i].length();
		}

		if (left == right) {
			return justifyLeft(left, right, words, maxWidth);
		}

		int totalSpaces = maxWidth - totalWidth;
		int noOfSpaces = totalSpaces / noOfWords;
		int extraSpaces = totalSpaces % noOfWords;
		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]);
			sb.append(spaces(noOfSpaces));
			sb.append(spaces(extraSpaces--));
		}
		sb.append(words[right]);
		return sb.toString();
	}

	public static String justifyLeft(int left, int right, String[] words, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]);
			sb.append(spaces(1));
		}
		sb.append(words[right]);

		while (sb.length() < maxWidth) {
			sb.append(spaces(1));
		}

		return sb.toString();
	}

	public static String spaces(int noOfSpaces) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < noOfSpaces; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

}
