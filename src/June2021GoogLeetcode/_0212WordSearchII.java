package June2021GoogLeetcode;

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
		if (board == null || board.length == 0 || words.length == 0 || words == null)
			return new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();
		Trie tr = new Trie();
		for (int i = 0; i < words.length; i++) {
			tr.addWord(words[i]);
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (tr.startsWith(board[i][j] + "")) {
					dfs(i, j, board, board[i][j] + "", set, tr, new HashSet<String>());
				}
			}
		}
		return new ArrayList<String>(set);
	}

	public static void dfs(int x, int y, char[][] board, String curr, HashSet<String> out, Trie tr,
			HashSet<String> visited) {
		if (!tr.startsWith(curr))
			return;
		if (tr.searchWord(curr))
			out.add(curr);
		visited.add(x + "/" + y);

		if (x - 1 >= 0 && !visited.contains(x - 1 + "/" + y)) {
			dfs(x - 1, y, board, curr + board[x - 1][y], out, tr, visited);
		}

		if (y - 1 >= 0 && !visited.contains(x + "/" + (y - 1))) {
			dfs(x, y - 1, board, curr + board[x][y - 1], out, tr, visited);
		}

		if (x + 1 < board.length && !visited.contains(x + 1 + "/" + y)) {
			dfs(x + 1, y, board, curr + board[x + 1][y], out, tr, visited);
		}

		if (y + 1 < board[0].length && !visited.contains(x + "/" + (y + 1))) {
			dfs(x, y + 1, board, curr + board[x][y + 1], out, tr, visited);
		}

		visited.remove(x + "/" + y);

	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
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
