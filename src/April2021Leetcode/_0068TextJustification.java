package April2021Leetcode;

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
		int left = 0;
		int currWidth = 0;
		List<String> output = new ArrayList<String>();
		for (int i = 0; i < words.length; i++) {
			if (currWidth == 0) {
				currWidth = words[i].length();
			} else {
				currWidth += words[i].length() + 1;
			}

			if (currWidth >= maxWidth) {
				if (currWidth == maxWidth) {
					output.add(justify(left, i, words, maxWidth));
					left = i + 1;
					currWidth = 0;
				} else {
					output.add(justify(left, i - 1, words, maxWidth));
					left = i;
					currWidth = words[i].length();
				}
			}
		}

		if (currWidth != 0) {
			output.add(justify(left, words.length - 1, words, maxWidth));
		}
		return output;
	}

	public static String justify(int left, int right, String[] words, int maxWidth) {
		if (left == right || right == words.length - 1) {
			return justifyRight(left, right, words, maxWidth);
		}
		int noOfWords = right - left;
		int wordsLength = 0;
		for (int i = left; i <= right; i++) {
			wordsLength += words[i].length();
		}
		int totalRemainingWidth = maxWidth - wordsLength;
		int noOfSpaces = totalRemainingWidth / noOfWords;
		int extraSpaces = totalRemainingWidth % noOfWords;

		StringBuilder sb = new StringBuilder();
		sb.append(words[left]);
		for (int i = left + 1; i <= right; i++) {
			sb.append(spaces(noOfSpaces));
			sb.append(spaces(extraSpaces--));
			sb.append(words[i]);
		}
		return sb.toString();
	}

	public static String justifyRight(int left, int right, String[] words, int maxWidth) {
		StringBuilder sb = new StringBuilder();
		sb.append(words[left]);
		for (int i = left + 1; i <= right; i++) {
			sb.append(spaces(1));
			sb.append(words[i]);
		}
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
