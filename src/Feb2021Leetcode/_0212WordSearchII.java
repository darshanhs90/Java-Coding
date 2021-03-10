package Feb2021Leetcode;

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
			for (int j = 0; j < board[0].length; j++) {
				dfs(i, j, board[i][j] + "", board, output, tr, new HashSet<String>());
			}
		}
		return new ArrayList<String>(output);
	}

	public static void dfs(int x, int y, String currString, char[][] board, HashSet<String> output, Trie tr,
			HashSet<String> visited) {

		if (!tr.startsWith(currString))
			return;

		if (tr.searchWord(currString)) {
			output.add(currString);
		}

		visited.add(x + "/" + y);
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };

		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];

			if (newX < 0 || newY < 0 || newX > board.length - 1 || newY > board[0].length - 1
					|| visited.contains(newX + "/" + newY))
				continue;
			dfs(newX, newY, currString + board[newX][newY], board, output, tr, visited);
		}
		visited.remove(x + "/" + y);
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

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void addWord(String str) {
			TrieNode tn = this.root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode(c);
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.isWord = true;
		}

		public boolean searchWord(String str) {
			TrieNode tn = this.root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return false;
				}
				tn = tn.childrens[c - 'a'];
			}
			return tn.isWord;
		}

		public boolean startsWith(String str) {
			TrieNode tn = this.root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					return false;
				}
				tn = tn.childrens[c - 'a'];
			}
			return true;
		}
	}

}