package Dec2020Leetcode;

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
		List<String> output = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		Trie tr = new Trie();
		for (String word : words) {
			tr.insert(word);
		}

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (tr.startsWith(board[i][j] + "")) {
					dfs(i, j, "", tr, board, output, set, visited);
				}
			}
		}
		return output;
	}

	public static void dfs(int x, int y, String currString, Trie tr, char[][] board, List<String> output,
			HashSet<String> set, boolean[][] visited) {
		if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || visited[x][y])
			return;

		String newWord = currString + board[x][y];

		if (!tr.startsWith(newWord))
			return;

		if (tr.search(newWord)) {
			if (!set.contains(newWord)) {
				output.add(newWord);
				set.add(newWord);
			}
		}

		visited[x][y] = true;
		dfs(x - 1, y, newWord, tr, board, output, set, visited);
		dfs(x + 1, y, newWord, tr, board, output, set, visited);
		dfs(x, y - 1, newWord, tr, board, output, set, visited);
		dfs(x, y + 1, newWord, tr, board, output, set, visited);
		visited[x][y] = false;
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
