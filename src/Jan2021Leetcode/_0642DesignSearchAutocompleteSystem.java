package Jan2021Leetcode;

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
		String word;
		int count;

		public WordPair(String word, int count) {
			this.word = word;
			this.count = count;
		}
	}

	static class AutocompleteSystem {
		HashMap<String, Integer> wordCount;
		Trie tr;
		String currSearchString;

		public AutocompleteSystem(String[] sentences, int[] times) {
			this.wordCount = new HashMap<String, Integer>();
			tr = new Trie();
			currSearchString = "";
			for (int i = 0; i < times.length; i++) {
				tr.insertWord(sentences[i]);
				wordCount.put(sentences[i], times[i]);
			}
		}

		public List<String> input(char c) {
			if (c == '#') {
				if (wordCount.containsKey(currSearchString)) {
					wordCount.put(currSearchString, wordCount.get(currSearchString) + 1);
				} else {
					wordCount.put(currSearchString, 1);
					tr.insertWord(currSearchString);
				}
				currSearchString = "";
				return new ArrayList<String>();
			} else {
				currSearchString += c;
				List<String> wordList = tr.searchWord(currSearchString);
				List<WordPair> pairs = new ArrayList<WordPair>();
				for (String str : wordList) {
					pairs.add(new WordPair(str, wordCount.get(str)));
				}

				Collections.sort(pairs, new Comparator<WordPair>() {

					@Override
					public int compare(WordPair o1, WordPair o2) {
						if (o1.count == o2.count)
							return o1.word.compareTo(o2.word);
						return o2.count - o1.count;
					}
				});

				List<String> output = new ArrayList<String>();
				for (int i = 0; i < Math.min(3, pairs.size()); i++) {
					output.add(pairs.get(i).word);
				}
				return output;
			}
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode(' ');
		}

		public void insertWord(String word) {
			TrieNode tn = root;
			tn.childWords.add(word);
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c == ' ' ? 26 : c - 'a';
				if (tn.childrens[index] == null) {
					tn.childrens[index] = new TrieNode(c);
				}
				tn = tn.childrens[index];
				tn.childWords.add(word);
			}
		}

		public List<String> searchWord(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
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
		boolean isWord;
		List<String> childWords;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[27];
			this.childWords = new ArrayList<String>();
		}
	}
}
