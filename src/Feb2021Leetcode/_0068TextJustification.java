package Feb2021Leetcode;

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
		List<String> output = new ArrayList<String>();
		int currWidth = 0;
		while (right < words.length) {
			if (currWidth == 0) {
				currWidth += words[right].length();
			} else {
				currWidth += words[right].length() + 1;
			}

			if (currWidth >= maxWidth) {
				if (currWidth == maxWidth) {
					output.add(justify(left, right, words, maxWidth));
					currWidth = 0;
					left = right + 1;
				} else {
					output.add(justify(left, right - 1, words, maxWidth));
					currWidth = words[right].length();
					left = right;
				}
			}
			right++;
		}

		output.add(justifyLast(left, words.length - 1, words, maxWidth));

		return output;
	}

	public static String justify(int left, int right, String[] words, int maxWidth) {
		int wordsLength = 0;
		int noOfWords = right - left;
		if (noOfWords == 0)
			return justifyLast(left, right, words, maxWidth);
		for (int i = left; i <= right; i++) {
			wordsLength += words[i].length();
		}

		int totalSpaces = maxWidth - (wordsLength);
		int minSpaces = noOfWords == 0 ? 0 : totalSpaces / noOfWords;
		int extraSpaces = noOfWords == 0 ? 0 : totalSpaces % noOfWords;

		StringBuilder sb = new StringBuilder();

		for (int i = left; i <= right; i++) {
			sb.append(words[i]);
			if (i != right) {
				sb.append(spaces(minSpaces));
				sb.append(spaces(extraSpaces--));
			}
		}
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

	public static String spaces(int number) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < number; i++) {
			sb.append(" ");
		}
		return sb.toString();
	}

}
