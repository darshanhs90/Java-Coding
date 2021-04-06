package SnapPrep;

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
					dfs(i, j, board[i][j] + "", tr, board, out, new HashSet<String>());
				}
			}
		}
		return new ArrayList<String>(out);
	}

	public static void dfs(int x, int y, String str, Trie trie, char[][] board, HashSet<String> outSet,
			HashSet<String> visited) {

		if (!trie.startsWith(str))
			return;

		if (trie.searchWord(str)) {
			outSet.add(str);
		}

		visited.add(x + "/" + y);
		int[][] dirs = new int[][] { new int[] { -1, 0 }, new int[] { 1, 0 }, new int[] { 0, -1 }, new int[] { 0, 1 } };
		for (int i = 0; i < dirs.length; i++) {
			int newX = x + dirs[i][0];
			int newY = y + dirs[i][1];
			if (newX < 0 || newY < 0 || newX >= board.length || newY >= board[0].length
					|| visited.contains(newX + "/" + newY))
				continue;
			dfs(newX, newY, str + board[newX][newY], trie, board, outSet, visited);
		}
		visited.remove(x + "/" + y);
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode(' ');
		}

		public void insertWord(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode(c);
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.isWord = true;
		}

		public boolean searchWord(String word) {
			TrieNode tn = root;
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
			TrieNode tn = root;
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
