package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.List;

public class _046WordSquares {

	public static void main(String[] args) {
		System.out.println(wordSquares(new String[] { "area", "lead", "wall", "lady", "ball" }));
		System.out.println(wordSquares(new String[] { "abat", "baba", "atan", "atal" }));
	}

	static class TrieNode {
		char val;
		boolean isWord;
		TrieNode[] childrens;
		List<String> fullWords;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[26];
			this.fullWords = new ArrayList<String>();
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void addWord(String word) {
			TrieNode tn = this.root;
			tn.fullWords.add(word);
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					TrieNode newNode = new TrieNode(c);
					tn.childrens[c - 'a'] = newNode;
				}
				tn = tn.childrens[c - 'a'];
				if (i != word.length() - 1)
					tn.fullWords.add(word);
			}
		}

		public List<String> searchWordsWithPrefix(String word) {
			TrieNode tn = this.root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return new ArrayList<String>();
				}
				tn = tn.childrens[c - 'a'];
			}
			return tn.fullWords;
		}
	}

	public static List<List<String>> wordSquares(String[] words) {
		Trie trie = new Trie();
		for (int i = 0; i < words.length; i++) {
			trie.addWord(words[i]);
		}
		List<List<String>> output = new ArrayList<List<String>>();
		dfs(trie, "", new ArrayList<String>(), output, words, 0);
		return output;
	}

	public static void dfs(Trie trie, String prefix, List<String> list, List<List<String>> output, String[] words,
			int size) {
		if (size > words[0].length())
			return;

		List<String> prefixWords = trie.searchWordsWithPrefix(prefix);
		for (int i = 0; i < prefixWords.size(); i++) {
			String currWord = prefixWords.get(i);
			list.add(currWord);

			if (size + 1 == words[0].length()) {
				output.add(new ArrayList<String>(list));
			} else {
				String newPrefix = "";
				for (int j = 0; j < list.size(); j++) {
					newPrefix += list.get(j).charAt(size + 1) + "";
				}

				dfs(trie, newPrefix, list, output, words, size + 1);
			}
			list.remove(list.size() - 1);
		}
	}

}
