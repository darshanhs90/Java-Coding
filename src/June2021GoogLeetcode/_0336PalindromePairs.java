package June2021GoogLeetcode;

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
		List<List<Integer>> out = new ArrayList<List<Integer>>();
		Trie tr = new Trie();
		for (int i = 0; i < words.length; i++) {
			tr.addWord(words[i], i);
		}

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
			tn.index = index;
			tn.palIndex.add(index);
		}

		public void searchWord(String word, int index, List<List<Integer>> out) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				String str = word.substring(i, word.length());
				if (tn.index != -1 && tn.index != index && isPalindrome(str)) {
					out.add(new ArrayList<Integer>(Arrays.asList(index, tn.index)));
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

		public boolean isPalindrome(String word) {
			return new StringBuilder(word).reverse().toString().equals(word);
		}

	}

	static class TrieNode {
		TrieNode[] childrens;
		int index;
		List<Integer> palIndex;

		public TrieNode() {
			this.childrens = new TrieNode[26];
			this.index = -1;
			this.palIndex = new ArrayList<Integer>();
		}
	}

}
