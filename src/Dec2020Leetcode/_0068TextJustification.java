package Dec2020Leetcode;

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
		List<String> list = new ArrayList<String>();
		int left = 0, right = 0;
		int currLength = 0;
		while (right < words.length) {
			if (currLength == 0) {
				left = right;
				currLength += words[right].length();
			} else {
				currLength += 1 + words[right].length();
			}

			if (currLength > maxWidth) {
				list.add(justify(left, right - 1, words, maxWidth));
				currLength = 0;
			} else if (currLength == maxWidth) {
				list.add(regularJustify(left, right, words, maxWidth));
				currLength = 0;
				right++;
			} else if (right == words.length - 1) {
				list.add(regularJustify(left, right, words, maxWidth));
				right++;
			} else {
				right++;
			}
		}
		return list;
	}

	public static String regularJustify(int left, int right, String[] words, int maxWidth) {
		if (left == right) {
			StringBuilder op = new StringBuilder();
			op.append(words[left]);
			while (op.length() < maxWidth)
				op.append(" ");
			return op.toString();
		}
		StringBuilder sb = new StringBuilder(words[left]);
		for (int i = left + 1; i <= right; i++) {
			sb.append(" ");
			sb.append(words[i]);
		}
		while (sb.length() < maxWidth)
			sb.append(" ");
		return sb.toString();
	}

	public static String justify(int left, int right, String[] words, int maxWidth) {
		if (left == right) {
			StringBuilder op = new StringBuilder();
			op.append(words[left]);
			while (op.length() < maxWidth)
				op.append(" ");
			return op.toString();
		}

		int wordLength = 0;
		int noOfWordsForSpaces = right - left;
		for (int i = left; i <= right; i++) {
			wordLength += words[i].length();
		}

		StringBuilder sb = new StringBuilder();
		int noOfSpaces = (maxWidth - wordLength) / noOfWordsForSpaces;
		int remainder = (maxWidth - wordLength) % noOfWordsForSpaces;
		StringBuilder spaces = new StringBuilder();
		for (int i = 0; i < noOfSpaces; i++) {
			spaces.append(" ");
		}
		for (int i = left; i < right; i++) {
			sb.append(words[i]);
			sb.append(spaces.toString());

			if (remainder > 0)
				sb.append(" ");
			remainder--;
		}
		sb.append(words[right]);
		return sb.toString();
	}

}
