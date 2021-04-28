package May2021PrepLeetcode;

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
		int left = 0, right = 0;
		int width = 0;
		List<String> output = new ArrayList<String>();
		while (right < words.length) {
			if (left == right) {
				width += words[right].length();
			} else {
				width += words[right].length() + 1;
			}

			if (width >= maxWidth) {
				if (width == maxWidth) {
					output.add(justify(left, right, words, maxWidth));
					left = right + 1;
					width = 0;
				} else {
					output.add(justify(left, right - 1, words, maxWidth));
					left = right;
					width = words[right].length();
				}
			}
			right++;
		}
		if (width != 0) {
			output.add(justify(left, words.length - 1, words, maxWidth));
		}

		return output;
	}

	public static String justify(int left, int right, String[] words, int maxWidth) {
		int noOfWords = right - left;
		int width = 0;
		if (left == right || right == words.length - 1)
			return justifyRight(left, right, words, maxWidth);
		for (int i = left; i <= right; i++) {
			width += words[i].length();
		}

		int remainingSpaces = maxWidth - width;
		int equalSpaces = remainingSpaces / noOfWords;
		int extraSpaces = remainingSpaces % noOfWords;
		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]);
			sb.append(spaces(equalSpaces));
			sb.append(spaces(extraSpaces--));
		}
		sb.append(words[right]);
		return sb.toString();
	}

	public static String justifyRight(int left, int right, String[] words, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]);
			sb.append(spaces(1));
		}
		sb.append(words[right]);

		while (sb.length() < maxWidth)
			sb.append(spaces(1));

		return sb.toString();
	}

	public static String spaces(int count) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < count; i++) {
			sb.append(" ");
		}

		return sb.toString();
	}

}
