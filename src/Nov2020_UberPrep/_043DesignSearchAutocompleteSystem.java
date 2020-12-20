package Nov2020_UberPrep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class _043DesignSearchAutocompleteSystem {

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
	}

	static class Pair {
		String word;
		int frequency;

		public Pair(String word, int frequency) {
			this.word = word;
			this.frequency = frequency;
		}
	}

	static class TrieNode {
		char val;
		TrieNode[] childrens;
		List<Pair> childWords;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[27];
			this.childWords = new ArrayList<Pair>();
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void addWord(String word, int frequency) {
			TrieNode tn = this.root;
			Pair p = new Pair(word, frequency);
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				if (tn.childrens[index] == null) {
					TrieNode newNode = new TrieNode(c);
					tn.childrens[index] = newNode;
				}
				tn = tn.childrens[index];
				tn.childWords.add(p);
			}
		}

		public void updateFrequency(String word, int frequency) {
			TrieNode tn = this.root;
			Pair p = new Pair(word, frequency);
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				tn = tn.childrens[index];
				int removalIndex = 0;
				for (int j = 0; j < tn.childWords.size(); j++) {
					if (tn.childWords.get(j).word.equals(word)) {
						removalIndex = j;
						break;
					}
				}

				tn.childWords.remove(removalIndex);
				tn.childWords.add(p);
			}
		}

		public List<Pair> search(String word) {
			TrieNode tn = this.root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				if (tn.childrens[index] == null) {
					return new ArrayList<Pair>();
				}
				tn = tn.childrens[index];
			}
			return tn.childWords;
		}

	}

	static class AutocompleteSystem {
		String searchTerm = "";
		Trie trie;
		HashMap<String, Integer> map;

		public AutocompleteSystem(String[] sentences, int[] times) {
			trie = new Trie();
			map = new HashMap<String, Integer>();
			for (int i = 0; i < sentences.length; i++) {
				trie.addWord(sentences[i], times[i]);
				map.put(sentences[i], times[i]);
			}
		}

		public List<String> input(char c) {
			if (c == '#') {
				if (map.containsKey(searchTerm)) {
					trie.updateFrequency(searchTerm, map.get(searchTerm) + 1);
					map.put(searchTerm, map.get(searchTerm) + 1);
				} else {
					trie.addWord(searchTerm, 1);
					map.put(searchTerm, 1);
				}
				searchTerm = "";
				return new ArrayList<String>();
			} else {
				searchTerm += c;
				List<Pair> list = trie.search(searchTerm);
				Collections.sort(list, new Comparator<Pair>() {

					@Override
					public int compare(Pair o1, Pair o2) {
						int val = o2.frequency - o1.frequency;
						if (val == 0)
							return o1.word.compareTo(o2.word);
						else
							return val;
					}
				});
				List<String> output = new ArrayList<String>();
				for (int i = 0; i < list.size() && i < 3; i++) {
					output.add(list.get(i).word);
				}
				return output;
			}
		}
	}

}
