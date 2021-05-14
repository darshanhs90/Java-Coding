package May2021Leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _0212WordSearchII {

	public static void main(String[] args) {
		System.out.println(findWords(
				new char[][] { new char[] { 'o', 'a', 'a', 'n' }, new char[] { 'e', 't', 'a', 'e' },
						new char[] { 'i', 'h', 'k', 'r' }, new char[] { 'i', 'f', 'l', 'v' } },
				new String[] { "oath", "pea", "eat", "rain" }));

		System.out.println(
				findWords(new char[][] { new char[] { 'a', 'b' }, new char[] { 'c', 'd' } }, new String[] { "abcb" }));

	}

	public static List<String> findWords(char[][] board, String[] words) {
		Trie tr = new Trie();
		for (int i = 0; i < words.length; i++) {
			tr.addWord(words[i]);
		}
		HashSet<String> output = new HashSet<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (tr.startsWith(board[i][j] + "")) {
					dfs(i, j, tr, board[i][j] + "", board, output, new HashSet<String>());
				}
			}
		}
		return new ArrayList<String>(output);
	}

	public static void dfs(int x, int y, Trie tr, String str, char[][] board, HashSet<String> output,
			HashSet<String> visited) {
		visited.add(x + "/" + y);
		if (tr.searchWord(str))
			output.add(str);

		if (x - 1 >= 0 && !visited.contains(x - 1 + "/" + y) && tr.startsWith(str + board[x - 1][y])) {
			dfs(x - 1, y, tr, str + board[x - 1][y], board, output, visited);
		}

		if (y - 1 >= 0 && !visited.contains(x + "/" + (y - 1)) && tr.startsWith(str + board[x][y - 1])) {
			dfs(x, y - 1, tr, str + board[x][y - 1], board, output, visited);
		}

		if (x + 1 < board.length && !visited.contains(x + 1 + "/" + y) && tr.startsWith(str + board[x + 1][y])) {
			dfs(x + 1, y, tr, str + board[x + 1][y], board, output, visited);
		}

		if (y + 1 < board[0].length && !visited.contains(x + "/" + (y + 1)) && tr.startsWith(str + board[x][y + 1])) {
			dfs(x, y + 1, tr, str + board[x][y + 1], board, output, visited);
		}

		visited.remove(x + "/" + y);
	}

	static class TrieNode {
		char key;
		TrieNode[] childrens;
		boolean isWord;

		public TrieNode(char key) {
			this.key = key;
			this.childrens = new TrieNode[26];
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void addWord(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null)
					tn.childrens[c - 'a'] = new TrieNode(c);
				tn = tn.childrens[c - 'a'];
			}
			tn.isWord = true;
		}

		public boolean searchWord(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null)
					return false;
				tn = tn.childrens[c - 'a'];
			}
			return tn.isWord;
		}

		public boolean startsWith(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null)
					return false;
				tn = tn.childrens[c - 'a'];
			}
			return true;
		}
	}

}
