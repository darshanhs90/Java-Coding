package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _070DesignSearchAutocompleteSystem {

	public static void main(String[] args) {
		AutocompleteSystem acs = new AutocompleteSystem(
				new String[] { "i love you", "island", "ironman", "i love leetcode" }, new int[] { 5, 3, 2, 2 });

		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
	}

	static class AutocompleteSystem {
		Trie trie;
		String currSearch = "";

		public AutocompleteSystem(String[] sentences, int[] times) {
			trie = new Trie();
			for (int i = 0; i < sentences.length; i++) {
				trie.insert(sentences[i], times[i]);
			}
		}

		public List<String> input(char c) {
			if (c == '#') {
				trie.insert(currSearch, 1);
				currSearch = "";
				return new ArrayList<String>();
			} else {
				currSearch += c;
				List<StringPair> list = trie.search(currSearch);
				List<String> out = new ArrayList<String>();
				for (StringPair spr : list) {
					out.add(spr.val);
				}
				return out;
			}
		}
	}

	static class StringPair {
		String val;
		int frequency;

		public StringPair(String val, int frequency) {
			this.val = val;
			this.frequency = frequency;
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ', 0);
		}

		private int getIntVal(char c) {
			return c == ' ' ? 26 : c - 'a';
		}

		public void insert(String word, int frequency) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				int charVal = getIntVal(word.charAt(i));
				if (tn.childrens[charVal] == null) {
					tn.childrens[charVal] = new TrieNode(word.charAt(i), 0);
				}
				tn = tn.childrens[charVal];
			}
			tn.frequency += frequency;
		}

		public List<StringPair> search(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				int charVal = getIntVal(word.charAt(i));
				if (tn.childrens[charVal] == null) {
					return new ArrayList<StringPair>();
				}
				tn = tn.childrens[charVal];
			}
			List<StringPair> allPairs = new ArrayList<StringPair>();
			traverse(word, tn, allPairs);

			Collections.sort(allPairs, new Comparator<StringPair>() {

				@Override
				public int compare(StringPair o1, StringPair o2) {
					if (o1.frequency > o2.frequency) {
						return -1;
					} else if (o1.frequency < o2.frequency) {
						return 1;
					} else {
						return o1.val.compareTo(o2.val);
					}
				}
			});

			if (allPairs.size() > 3) {
				return allPairs.subList(0, 3);
			}
			return allPairs;
		}

		public void traverse(String currWord, TrieNode tn, List<StringPair> allPairs) {
			if (tn != null) {
				if (tn.frequency > 0)
					allPairs.add(new StringPair(currWord, tn.frequency));

				for (TrieNode child : tn.childrens) {
					if (child != null) {
						traverse(currWord + child.val, child, allPairs);
					}
				}
			}
		}
	}

	static class TrieNode {
		char val;
		int frequency;
		TrieNode[] childrens;

		public TrieNode(char val, int frequency) {
			this.val = val;
			this.frequency = frequency;
			childrens = new TrieNode[27];
		}

	}
}
