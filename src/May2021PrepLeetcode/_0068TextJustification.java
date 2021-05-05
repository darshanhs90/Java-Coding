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
		int currWidth = 0;
		int left = 0, right = 0;
		List<String> output = new ArrayList<String>();
		while (right < words.length) {
			if (left == right) {
				currWidth = words[right].length();
			} else {
				currWidth += 1 + words[right].length();
			}

			if (currWidth >= maxWidth) {
				if (currWidth == maxWidth) {
					output.add(justify(left, right, maxWidth, words));
					left = right + 1;
					currWidth = 0;
				} else {
					output.add(justify(left, right - 1, maxWidth, words));
					left = right;
					currWidth = words[right].length();
				}
			}
			right++;
		}

		if (currWidth != 0) {
			output.add(justify(left, words.length - 1, maxWidth, words));
		}
		return output;
	}

	public static String spaces(int count) {
		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < count; j++) {
			sb.append(" ");
		}
		return sb.toString();
	}

	public static String justifyLast(int left, int right, int maxWidth, String[] words) {
		StringBuilder sb = new StringBuilder();
		for (int j = left; j < right; j++) {
			sb.append(words[j]);
			sb.append(spaces(1));
		}
		sb.append(words[right]);
		while (sb.length() < maxWidth) {
			sb.append(spaces(1));
		}
		return sb.toString();
	}

	public static String justify(int left, int right, int maxWidth, String[] words) {
		if (left == right || right == words.length - 1)
			return justifyLast(left, right, maxWidth, words);

		int noOfWords = right - left;
		int totalWidth = 0;
		for (int i = left; i <= right; i++) {
			totalWidth += words[i].length();
		}

		int totalSpaces = maxWidth - totalWidth;
		int noOfEqualSpaces = totalSpaces / noOfWords;
		int extraSpaces = totalSpaces % noOfWords;

		StringBuilder sb = new StringBuilder();
		for (int j = left; j < right; j++) {
			sb.append(words[j]);
			sb.append(spaces(noOfEqualSpaces));
			sb.append(spaces(extraSpaces--));
		}
		sb.append(words[right]);
		return sb.toString();
	}

}
