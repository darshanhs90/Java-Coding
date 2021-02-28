package FacebookPrep;

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
		HashMap<String, Integer> map;
		Trie trie;
		String currString;

		public AutocompleteSystem(String[] sentences, int[] times) {
			map = new HashMap<String, Integer>();
			trie = new Trie();
			for (int i = 0; i < times.length; i++) {
				trie.insertWord(sentences[i]);
				map.put(sentences[i], times[i]);
			}
			currString = "";
		}

		public List<String> input(char c) {
			if (c == '#') {
				if (map.containsKey(currString)) {
					map.compute(currString, (k, v) -> v == null ? 1 : v + 1);
				} else {
					trie.insertWord(currString);
					map.put(currString, 1);
				}
				currString = "";
				return new ArrayList<String>();
			} else {
				currString += c;
				List<String> list = trie.search(currString);

				List<WordPair> words = new ArrayList<WordPair>();
				for (int i = 0; i < list.size(); i++) {
					String word = list.get(i);
					words.add(new WordPair(word, map.get(word)));
				}

				Collections.sort(words, new Comparator<WordPair>() {

					@Override
					public int compare(WordPair o1, WordPair o2) {
						int val = o2.count - o1.count;
						if (val == 0)
							return o1.str.compareTo(o2.str);
						return val;
					}
				});

				List<String> output = new ArrayList<String>();
				for (int i = 0; i < Math.min(3, words.size()); i++) {
					output.add(words.get(i).str);
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

		public void insertWord(String str) {
			TrieNode tn = this.root;
			tn.childWords.add(str);
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c == ' ' ? 26 : c - 'a';

				if (tn.childrens[index] == null) {
					tn.childrens[index] = new TrieNode(c);
				}
				tn = tn.childrens[index];
				tn.childWords.add(str);
			}
		}

		public List<String> search(String str) {
			TrieNode tn = this.root;
			tn.childWords.add(str);
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c == ' ' ? 26 : c - 'a';

				if (tn.childrens[index] == null) {
					return new ArrayList<String>();
				}
				tn = tn.childrens[index];
			}
			return tn.childWords;
		}

	}

	static class TrieNode {
		char val;
		TrieNode[] childrens;
		List<String> childWords;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[27];
			this.childWords = new ArrayList<String>();
		}
	}
}
