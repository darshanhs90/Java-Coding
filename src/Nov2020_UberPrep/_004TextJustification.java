package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.List;

public class _004TextJustification {

	public static void main(String[] args) {
		System.out.println(
				fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16));
		System.out.println(fullJustify(new String[] { "What", "must", "be", "acknowledgment", "shall", "be" }, 16));
		System.out.println(fullJustify(new String[] { "Science", "is", "what", "we", "understand", "well", "enough",
				"to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do" }, 20));
	}

	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> output = new ArrayList<String>();
		if (words.length == 0)
			return output;
		String currString = words[0];
		for (int i = 1; i < words.length; i++) {
			if (currString.length() + words[i].length() > maxWidth - 1) {
				output.add(currString);
				currString = words[i];
			} else {
				currString = currString + " " + words[i];
			}
		}
		output.add(currString);

		return output;
	}
}
