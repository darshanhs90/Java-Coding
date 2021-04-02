package Mar2021Leetcode;

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
		HashSet<String> out = new HashSet<String>();
		Trie tr = new Trie();
		for (int i = 0; i < words.length; i++) {
			tr.insertWord(words[i]);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (tr.startsWith(board[i][j] + "")) {
					dfs(i, j, "", board, tr, out, new HashSet<String>());
				}
			}
		}

		return new ArrayList<String>(out);
	}

	public static void dfs(int x, int y, String str, char[][] board, Trie trie, HashSet<String> out,
			HashSet<String> visited) {
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || visited.contains(x + "/" + y)
				|| !trie.startsWith(str+ board[x][y]))
			return;

		if (trie.search(str + board[x][y])) {
			out.add(str + board[x][y]);
		}

		visited.add(x + "/" + y);
		dfs(x - 1, y, str + board[x][y] , board, trie, out, visited);
		dfs(x + 1, y, str + board[x][y], board, trie, out, visited);
		dfs(x, y - 1, str + board[x][y], board, trie, out, visited);
		dfs(x, y + 1, str + board[x][y] , board, trie, out, visited);
		visited.remove(x + "/" + y);
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void insertWord(String word) {
			TrieNode tn = this.root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode(c);
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.isWord = true;
		}

		public boolean search(String word) {
			TrieNode tn = this.root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return false;
				}
				tn = tn.childrens[c - 'a'];
			}
			return tn.isWord;
		}

		public boolean startsWith(String word) {
			TrieNode tn = this.root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return false;
				}
				tn = tn.childrens[c - 'a'];
			}
			return true;
		}
	}

	static class TrieNode {
		char val;
		TrieNode[] childrens;
		boolean isWord;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[26];
		}
	}
}
