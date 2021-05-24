package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0336PalindromePairs {

	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(palindromePairs(new String[] { "bat", "tab", "cat" }));
		System.out.println(palindromePairs(new String[] { "a", "" }));
	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		Trie tr = new Trie();
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			tr.addWord(words[i], i);
		}

		for (int i = 0; i < words.length; i++) {
			tr.searchWord(words[i], i, output);
		}
		return output;
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void addWord(String word, int index) {
			TrieNode tn = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				String str = word.substring(0, i);
				if (isPalindrome(str)) {
					tn.palIndex.add(index);
				}

				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode();
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.pos = index;
			tn.palIndex.add(index);
		}

		public void searchWord(String word, int index, List<List<Integer>> list) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				if (tn.pos != -1 && tn.pos != index && isPalindrome(word.substring(i, word.length() - 1))) {
					list.add(new ArrayList<Integer>(Arrays.asList(index, tn.pos)));
				}

				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return;
				}
				tn = tn.childrens[c - 'a'];
			}

			List<Integer> palIndex = tn.palIndex;
			for (int num : palIndex) {
				if (num != index) {
					list.add(new ArrayList<Integer>(Arrays.asList(index, num)));
				}
			}
		}

		public boolean isPalindrome(String str) {
			return new StringBuilder(str).reverse().toString().equals(str);
		}
	}

	static class TrieNode {
		TrieNode[] childrens;
		int pos = -1;
		List<Integer> palIndex;

		public TrieNode() {
			this.childrens = new TrieNode[26];
			this.palIndex = new ArrayList<Integer>();
		}
	}

}
