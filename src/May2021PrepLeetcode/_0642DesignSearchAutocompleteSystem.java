package May2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
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
		HashMap<String, Integer> countMap;
		String currString;
		Trie trie;

		public AutocompleteSystem(String[] sentences, int[] times) {
			countMap = new HashMap<String, Integer>();
			trie = new Trie();
			for (int i = 0; i < times.length; i++) {
				int count = times[i];
				trie.insert(sentences[i]);
				countMap.compute(sentences[i], (k, v) -> v == null ? count : v + count);
			}
			currString = "";
		}

		public List<String> input(char c) {
			if (c == '#') {
				trie.insert(currString);
				countMap.compute(currString, (k, v) -> v == null ? 1 : v + 1);
				currString = "";
				return new ArrayList<String>();
			} else {
				currString += c;
				List<String> list = trie.search(currString);
				Collections.sort(list, new Comparator<String>() {

					@Override
					public int compare(String o1, String o2) {
						int count1 = countMap.get(o1);
						int count2 = countMap.get(o2);
						if (count1 == count2)
							return o1.compareTo(o2);
						return count2 - count1;
					}
				});

				if (list.size() > 3) {
					return list.subList(0, 3);
				}
				return list;
			}
		}
	}

	static class Trie {
		TrieNode rootNode;

		public Trie() {
			this.rootNode = new TrieNode(' ');
		}

		public void insert(String word) {
			TrieNode tn = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				tn.childWords.add(word);
				int index = c == ' ' ? 26 : c - 'a';
				if (tn.childrens[index] == null) {
					tn.childrens[index] = new TrieNode(c);
				}
				tn = tn.childrens[index];
			}
			tn.childWords.add(word);
		}

		public List<String> search(String word) {
			TrieNode tn = this.rootNode;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c == ' ' ? 26 : c - 'a';
				if (tn.childrens[index] == null) {
					return new ArrayList<String>();
				}
				tn = tn.childrens[index];
			}
			return new ArrayList<String>(tn.childWords);
		}
	}

	static class TrieNode {
		char val;
		TrieNode[] childrens;
		HashSet<String> childWords;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[27];
			this.childWords = new HashSet<String>();
		}
	}
}
