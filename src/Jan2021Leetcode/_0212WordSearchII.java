package Jan2021Leetcode;

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
			tr.insert(words[i]);
		}
		HashSet<String> output = new HashSet<String>();
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				String currWord = board[i][j] + "";
				if (tr.startsWith(currWord)) {
					visited[i][j] = true;
					dfs(i, j, tr, board[i][j] + "", board, visited, output);
					visited[i][j] = false;
				}
			}
		}
		return new ArrayList<String>(output);
	}

	public static void dfs(int x, int y, Trie tr, String currWord, char[][] board, boolean[][] visited,
			HashSet<String> output) {

		if (tr.search(currWord))
			output.add(currWord);

		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length && !visited[newX][newY]
					&& tr.startsWith(currWord + board[newX][newY])) {
				visited[newX][newY] = true;
				dfs(newX, newY, tr, currWord + board[newX][newY], board, visited, output);
				visited[newX][newY] = false;
			}
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

	static class Trie {
		TrieNode root;

		/** Initialize your data structure here. */
		public Trie() {
			this.root = new TrieNode(' ');
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			TrieNode tn = this.root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					TrieNode newNode = new TrieNode(c);
					tn.childrens[c - 'a'] = newNode;
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.isWord = true;
		}

		/** Returns if the word is in the trie. */
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

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode tn = this.root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return false;
				}
				tn = tn.childrens[c - 'a'];
			}
			return true;
		}
	}
}
