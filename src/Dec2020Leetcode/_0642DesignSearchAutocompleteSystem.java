package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _0642DesignSearchAutocompleteSystem {

	public static void main(String[] args) {
		AutocompleteSystem acs = new AutocompleteSystem(
				new String[] { "i love you", "island", "ironman", "i love leetcode" }, new int[] { 5, 3, 2, 2 });

		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
	}

	static class WordPair {
		String str;
		Integer count;

		public WordPair(String str, Integer count) {
			this.str = str;
			this.count = count;
		}
	}

	static class AutocompleteSystem {
		String searchString;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		Trie trie;

		public AutocompleteSystem(String[] sentences, int[] times) {
			searchString = "";
			trie = new Trie();
			for (int i = 0; i < times.length; i++) {
				trie.insertString(sentences[i]);
				map.put(sentences[i], times[i]);
			}
		}

		public List<String> input(char c) {
			if (c == '#') {
				if (map.containsKey(searchString)) {
					map.put(searchString, map.get(searchString) + 1);
				} else {
					trie.insertString(searchString);
					map.put(searchString, 1);
				}
				searchString = "";
				return new ArrayList<String>();
			} else {
				searchString += c;
				List<String> list = trie.fetchStrings(searchString);
				List<WordPair> wordList = new ArrayList<WordPair>();

				for (int i = 0; i < list.size(); i++) {
					wordList.add(new WordPair(list.get(i), map.get(list.get(i))));
				}

				Collections.sort(wordList, new Comparator<WordPair>() {

					@Override
					public int compare(WordPair o1, WordPair o2) {
						// TODO Auto-generated method stub
						int val = o2.count - o1.count;
						if (val == 0)
							return o1.str.compareTo(o2.str);
						return val;
					}
				});

				List<String> output = new ArrayList<String>();
				for (int i = 0; i < Math.min(3, wordList.size()); i++) {
					output.add(wordList.get(i).str);
				}
				return output;
			}
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void insertString(String str) {
			TrieNode tn = this.root;
			tn.childStrings.add(str);
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c == ' ' ? 26 : c - 'a';
				if (tn.childrens[index] == null) {
					tn.childrens[index] = new TrieNode(c);
				}
				tn = tn.childrens[index];
				tn.childStrings.add(str);
			}
		}

		public List<String> fetchStrings(String str) {
			TrieNode tn = this.root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c == ' ' ? 26 : c - 'a';
				if (tn.childrens[index] == null) {
					return new ArrayList<String>();
				}
				tn = tn.childrens[index];
			}
			return tn.childStrings;
		}
	}

	static class TrieNode {
		char val;
		TrieNode[] childrens;
		List<String> childStrings;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[27];
			this.childStrings = new ArrayList<String>();
		}
	}
}
