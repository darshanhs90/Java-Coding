package Feb2021Leetcode;

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

	static class AutocompleteSystem {
		HashMap<String, Integer> wordCountMap;
		String currString;
		Trie trie;

		public AutocompleteSystem(String[] sentences, int[] times) {
			trie = new Trie();
			wordCountMap = new HashMap<String, Integer>();
			currString = "";
			for (int i = 0; i < times.length; i++) {
				trie.addWord(sentences[i]);
				wordCountMap.put(sentences[i], times[i]);
			}
		}

		public List<String> input(char c) {
			if (c == '#') {
				if (!wordCountMap.containsKey(currString)) {
					trie.addWord(currString);
				}
				wordCountMap.compute(currString, (k, v) -> v == null ? 1 : v + 1);

				currString = "";
				return new ArrayList<String>();
			} else {
				currString += c;
				List<String> list = trie.searchWord(currString);

				List<WordPair> wordList = new ArrayList<WordPair>();
				for (String word : list) {
					wordList.add(new WordPair(word, wordCountMap.get(word)));
				}

				Collections.sort(wordList, new Comparator<WordPair>() {

					@Override
					public int compare(WordPair o1, WordPair o2) {
						// TODO Auto-generated method stub
						int count = o2.count - o1.count;
						if (count == 0)
							return o1.str.compareTo(o2.str);
						return count;
					}
				});
				list = new ArrayList<String>();

				for (int i = 0; i < Math.min(wordList.size(), 3); i++) {
					list.add(wordList.get(i).str);
				}
				return list;
			}
		}
	}

	static class WordPair {
		String str;
		int count;

		public WordPair(String str, int count) {
			this.str = str;
			this.count = count;
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode(' ');
		}

		public void addWord(String str) {
			TrieNode currNode = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				currNode.childrens.add(str);
				if (currNode.childNodes[index] == null) {
					currNode.childNodes[index] = new TrieNode(c);
				}

				currNode = currNode.childNodes[index];
			}
			currNode.childrens.add(str);
		}

		public List<String> searchWord(String str) {
			TrieNode currNode = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				if (currNode.childNodes[index] == null) {
					return new ArrayList<String>();
				}

				currNode = currNode.childNodes[index];
			}
			return currNode.childrens;
		}
	}

	static class TrieNode {
		char val;
		TrieNode[] childNodes;
		List<String> childrens;

		public TrieNode(char val) {
			this.val = val;
			this.childNodes = new TrieNode[27];
			this.childrens = new ArrayList<String>();
		}
	}

}
