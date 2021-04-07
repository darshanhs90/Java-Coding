package SnapPrep;

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
		int left = 0, right = 0;
		int currWidth = 0;
		List<String> output = new ArrayList<String>();
		while (right < words.length) {
			if (currWidth == 0) {
				currWidth += words[right].length();
			} else {
				currWidth += words[right].length() + 1;
			}

			if (currWidth >= maxWidth) {
				if (currWidth == maxWidth) {
					output.add(justify(left, right, words, maxWidth));
					left = right + 1;
					currWidth = 0;
				} else {
					output.add(justify(left, right - 1, words, maxWidth));
					currWidth = words[right].length();
					left = right;
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
		if (right == words.length - 1 || left == right)
			return justifyEnd(left, right, words, maxWidth);

		int noOfWords = right - left;
		int currWidth = 0;
		for (int i = left; i <= right; i++) {
			currWidth += words[i].length();
		}

		int totalSpaces = maxWidth - currWidth;

		int equalSpaces = totalSpaces / noOfWords;
		int extraSpaces = totalSpaces % noOfWords;

		StringBuilder sb = new StringBuilder();
		sb.append(words[left]);

		for (int i = left + 1; i <= right; i++) {
			sb.append(spaces(equalSpaces));
			sb.append(spaces(extraSpaces--));
			sb.append(words[i]);
		}
		return sb.toString();
	}

	public static String justifyEnd(int left, int right, String[] words, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		sb.append(words[left]);

		for (int i = left + 1; i <= right; i++) {
			sb.append(spaces(1));
			sb.append(words[i]);
		}

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
