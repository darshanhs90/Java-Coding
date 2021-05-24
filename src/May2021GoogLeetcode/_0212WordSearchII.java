package May2021GoogLeetcode;

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
		for (String word : words) {
			tr.addWord(word);
		}

		HashSet<String> out = new HashSet<String>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (tr.startsWith(board[i][j] + "")) {
					dfs(i, j, "", board, tr, out, new HashSet<String>());
				}
			}
		}
		return new ArrayList<String>(out);
	}

	public static void dfs(int x, int y, String str, char[][] board, Trie tr, HashSet<String> out,
			HashSet<String> visited) {
		if (visited.contains(x + "/" + y))
			return;

		str += board[x][y];
		visited.add(x + "/" + y);
		if (tr.searchWord(str))
			out.add(str);

		if (x - 1 >= 0 && tr.startsWith(str + board[x - 1][y])) {
			dfs(x - 1, y, str, board, tr, out, visited);
		}

		if (y - 1 >= 0 && tr.startsWith(str + board[x][y - 1])) {
			dfs(x, y - 1, str, board, tr, out, visited);
		}

		if (x + 1 < board.length && tr.startsWith(str + board[x + 1][y])) {
			dfs(x + 1, y, str, board, tr, out, visited);
		}

		if (y + 1 < board[0].length && tr.startsWith(str + board[x][y + 1])) {
			dfs(x, y + 1, str, board, tr, out, visited);
		}
		visited.remove(x + "/" + y);
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void addWord(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode();
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
		TrieNode[] childrens;
		boolean isWord;

		public TrieNode() {
			this.childrens = new TrieNode[26];
		}
	}

}
