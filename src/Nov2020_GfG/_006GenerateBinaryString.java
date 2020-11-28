package Nov2020_GfG;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _006GenerateBinaryString {

	public static void main(String[] args) {
		System.out.println(generateBinaryString("1??0?101"));
	}

	static List<String> generateBinaryString(String word) {
		List<String> output = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		generateBinaryString("", 0, word, output, set);
		return output;
	}

	static void generateBinaryString(String currString, int index, String word, List<String> list,
			HashSet<String> set) {
		if (index == word.length()) {
			if (!set.contains(currString)) {
				list.add(currString);
				set.add(currString);
			}
			return;
		}
		char c = word.charAt(index);
		if (c == '?') {
			generateBinaryString(currString + "0", index + 1, word, list, set);
			generateBinaryString(currString + "1", index + 1, word, list, set);
		} else {
			generateBinaryString(currString + c, index + 1, word, list, set);
		}
	}
}
