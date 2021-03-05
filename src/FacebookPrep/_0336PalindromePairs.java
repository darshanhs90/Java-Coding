package FacebookPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0336PalindromePairs {

	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(palindromePairs(new String[] { "bat", "tab", "cat" }));
		System.out.println(palindromePairs(new String[] { "a", "" }));

	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		TrieNode root = new TrieNode(' ');
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			addWord(words[i], root, i);
		}

		for (int i = 0; i < words.length; i++) {
			searchWord(words[i], root, output, i);
		}
		return output;
	}

	public static boolean isPalindrome(String word) {
		return word.equals(new StringBuilder(word).reverse().toString());
	}

	static class TrieNode {
		char c;
		int wordIndex = -1;
		HashMap<String, Integer> suffixIndexMap = new HashMap<String, Integer>();
		TrieNode[] childrens = new TrieNode[26];

		public TrieNode(char c) {
			this.c = c;
		}
	}

	public static void searchWord(String word, TrieNode root, List<List<Integer>> output, int index) {
		TrieNode tn = root;
		word = new StringBuilder(word).reverse().toString();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (tn.childrens[c - 'a'] == null) {
				return;
			}
			tn = tn.childrens[c - 'a'];
		}

		if (tn.wordIndex != -1) {
			if (index != tn.wordIndex)
				output.add(new ArrayList<Integer>(Arrays.asList(index, tn.wordIndex)));
		}

		if (tn.suffixIndexMap.size() > 0) {
			for (Map.Entry<String, Integer> entry : tn.suffixIndexMap.entrySet()) {
				if (isPalindrome(entry.getKey())) {
					if (index != entry.getValue())
						output.add(new ArrayList<Integer>(Arrays.asList(index, entry.getValue())));
				}
			}
		}
	}

	public static void addWord(String word, TrieNode root, int index) {
		TrieNode tn = root;
		word = new StringBuilder(word).reverse().toString();
		for (int i = 0; i < word.length(); i++) {
			String suffix = word.substring(i);
			if (suffix.length() > 0) {
				tn.suffixIndexMap.put(suffix, index);
			}

			char c = word.charAt(i);
			if (tn.childrens[c - 'a'] == null) {
				tn.childrens[c - 'a'] = new TrieNode(c);
			}

			tn = tn.childrens[c - 'a'];
		}
		tn.wordIndex = index;
	}

}
