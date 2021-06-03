package May2021GoogLeetcode;

import java.util.ArrayList;
import java.util.List;

public class _0425WordSquares {

	public static void main(String[] args) {
		System.out.println(wordSquares(new String[] { "area", "lead", "wall", "lady", "ball" }));
		System.out.println(wordSquares(new String[] { "abat", "baba", "atan", "atal" }));
	}

	public static List<List<String>> wordSquares(String[] words) {

		List<List<String>> output = new ArrayList<List<String>>();
		Trie tr = new Trie();
		for (int i = 0; i < words.length; i++) {
			tr.addWord(words[i]);
		}
		int length = words[0].length();
		List<String> list = new ArrayList<String>();
		for (String str : words) {
			list.add(str);
			dfs(length, tr, list, output);
			list.remove(list.size() - 1);
		}
		return output;
	}

	public static void dfs(int length, Trie tr, List<String> list, List<List<String>> output) {
		if (list.size() == length) {
			output.add(new ArrayList<String>(list));
			return;
		}

		int index = list.size();
		StringBuilder prefix = new StringBuilder();
		for (String str : list) {
			prefix.append(str.charAt(index));
		}

		List<String> matchingPrefixes = tr.prefixSearch(prefix.toString());
		for (String newPrefix : matchingPrefixes) {
			list.add(newPrefix);
			dfs(length, tr, list, output);
			list.remove(list.size() - 1);
		}
	}

	static class TrieNode {
		List<String> startsWith;
		TrieNode[] childrens;

		public TrieNode() {
			this.startsWith = new ArrayList<String>();
			this.childrens = new TrieNode[26];
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void addWord(String str) {
			TrieNode tn = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode();
				}
				tn.startsWith.add(str);
				tn = tn.childrens[c - 'a'];
			}
		}

		public List<String> prefixSearch(String str) {
			TrieNode tn = root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return new ArrayList<String>();
				}
				tn = tn.childrens[c - 'a'];
			}
			return tn.startsWith;
		}
	}

}
