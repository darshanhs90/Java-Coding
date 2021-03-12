package Feb2021Leetcode;

import java.util.HashSet;

public class _0079WordSearch {

	public static void main(String[] args) {
		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "SEE"));

		System.out.println(exist(new char[][] { new char[] { 'A', 'B', 'C', 'E' }, new char[] { 'S', 'F', 'C', 'S' },
				new char[] { 'A', 'D', 'E', 'E' } }, "ABCB"));

		System.out.println(exist(new char[][] { new char[] { 'a' } }, "a"));
	}

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0)
			return false;

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0)) {
					if (wordExists(i, j, 0, word, board, new HashSet<String>()))
						return true;
				}
			}
		}
		return false;
	}

	public static boolean wordExists(int x, int y, int index, String word, char[][] board,
			HashSet<String> visited) {
		if (index == word.length())
			return true;
		if (x < 0 || y < 0 || x >= board.length || y >= board[0].length || index > word.length()
				|| visited.contains(x + "/" + y) || word.charAt(index) != board[x][y])
			return false;
		visited.add(x + "/" + y);
		boolean out = false;
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		for (int i = 0; i < dirs.length; i++) {
			out = out || wordExists(x + dirs[i][0], y + dirs[i][1], index + 1, word, board, visited);
		}
		visited.remove(x + "/" + y);
		return out;
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
				if (tn.childrens[c - 'A'] == null) {
					tn.childrens[c - 'A'] = new TrieNode(c);
				}
				tn = tn.childrens[c - 'A'];
			}
			tn.isWord = true;
		}

		public boolean searchWord(String word) {
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
		boolean isWord;
		TrieNode[] childrens;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[26];
		}
	}
}
