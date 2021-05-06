package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0336PalindromePairs {
// http://www.allenlipeng47.com/blog/index.php/2016/03/15/palindrome-pairs/
	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(palindromePairs(new String[] { "bat", "tab", "cat" }));
		System.out.println(palindromePairs(new String[] { "a", "" }));

	}

	public static List<List<Integer>> palindromePairs(String[] words) {
		Trie tr = new Trie();
		for (int i = 0; i < words.length; i++) {
			tr.insertWord(words[i], i);
		}
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		for (int i = 0; i < words.length; i++) {
			tr.searchWord(words[i], i, out);
		}
		return out;
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void insertWord(String word, int index) {
			TrieNode tn = this.root;
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

		public void searchWord(String word, int index, List<List<Integer>> out) {
			TrieNode tn = this.root;

			for (int i = 0; i < word.length(); i++) {
				String str = word.substring(i, word.length());
				if (tn.pos != -1 && tn.pos != index && isPalindrome(str)) {
					out.add(new ArrayList<Integer>(Arrays.asList(index, tn.pos)));
				}
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return;
				}
				tn = tn.childrens[c - 'a'];
			}

			List<Integer> list = tn.palIndex;
			for (int num : list) {
				if (num != index) {
					out.add(new ArrayList<Integer>(Arrays.asList(index, num)));
				}
			}
		}

		public boolean isPalindrome(String str) {
			return new StringBuilder(str).reverse().toString().equals(str);
		}
	}

	static class TrieNode {
		TrieNode[] childrens;
		int pos;
		List<Integer> palIndex;

		public TrieNode() {
			this.childrens = new TrieNode[26];
			this.palIndex = new ArrayList<Integer>();
			this.pos = -1;
		}
	}

}
