package April2021PrepLeetcode;

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
		int currWidth = 0;
		int left = 0, right = 0;
		while (right < words.length) {

			if (left == right) {
				currWidth = words[right].length();
			} else {
				currWidth += 1 + words[right].length();
			}

			if (currWidth >= maxWidth) {
				if (currWidth == maxWidth) {
					output.add(justify(left, right, words, maxWidth));
					left = right + 1;
				} else {
					output.add(justify(left, right - 1, words, maxWidth));
					left = right;
					currWidth = words[right].length();
				}
			}
			right++;
		}

		if (currWidth != 0) {
			output.add(justify(left, words.length - 1, words, maxWidth));
		}
		return output;
	}

	public static String justify(int left, int right, String[] words, int maxWidth) {
		int noOfWords = right - left;
		if (noOfWords == 0 || right == words.length - 1)
			return justifyLast(left, right, words, maxWidth);

		int width = 0;
		for (int i = left; i <= right; i++) {
			width += words[i].length();
		}

		int totalNoOfSpaces = maxWidth - width;
		int equalSpaces = totalNoOfSpaces / noOfWords;
		int extraSpaces = totalNoOfSpaces % noOfWords;

		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]);
			sb.append(spaces(equalSpaces));
			sb.append(spaces(extraSpaces--));
		}
		sb.append(words[right]);
		return sb.toString();
	}

	public static String justifyLast(int left, int right, String[] words, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		for (int i = left; i < right; i++) {
			sb.append(words[i]);
			sb.append(spaces(1));
		}
		sb.append(words[right]);

		while (sb.length() < maxWidth)
			sb.append(" ");

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
