package May2021Leetcode;

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
		List<List<Integer>> output = new ArrayList<List<Integer>>();
		Trie tr = new Trie();
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
			root = new TrieNode();
		}

		public void addWord(String word, int index) {
			TrieNode tn = root;
			for (int i = word.length()-1; i >= 0; i--) {
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
			tn.palIndex.add(index);
			tn.posIndex = index;
		}

		public void searchWord(String word, int index, List<List<Integer>> out) {
			TrieNode tn = root;
			for (int i = 0; i < word.length() && tn != null; i++) {
				if (tn.posIndex != -1 && tn.posIndex != index && isPalindrome(word.substring(i, word.length()))) {
					out.add(new ArrayList<Integer>(Arrays.asList(index, tn.posIndex)));
				}

				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null)
					return;

				tn = tn.childrens[c - 'a'];
			}

			List<Integer> list = tn.palIndex;
			for (Integer val : list) {
				if (val != index) {
					out.add(new ArrayList<Integer>(Arrays.asList(index, val)));
				}
			}
		}

		public boolean isPalindrome(String str) {
			return new StringBuilder(str).reverse().toString().equals(str);
		}
	}

	static class TrieNode {
		int posIndex;
		List<Integer> palIndex;
		TrieNode[] childrens;

		public TrieNode() {
			this.posIndex = -1;
			this.palIndex = new ArrayList<Integer>();
			this.childrens = new TrieNode[26];
		}
	}

}
