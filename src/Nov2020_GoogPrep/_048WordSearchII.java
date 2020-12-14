package Nov2020_GoogPrep;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _048WordSearchII {

	public static void main(String[] args) {
		System.out.println(findWords(
				new char[][] { new char[] { 'o', 'a', 'a', 'n' }, new char[] { 'e', 't', 'a', 'e' },
						new char[] { 'i', 'h', 'k', 'r' }, new char[] { 'i', 'f', 'l', 'v' } },
				new String[] { "oath", "pea", "eat", "rain" }));

		System.out.println(
				findWords(new char[][] { new char[] { 'a', 'b' }, new char[] { 'c', 'd' } }, new String[] { "abcd" }));

		System.out.println(findWords(new char[][] { new char[] { 'a' } }, new String[] { "a" }));
	}

	public static List<String> findWords(char[][] board, String[] words) {
		Trie tr = new Trie();
		for (int i = 0; i < words.length; i++) {
			tr.insert(words[i]);
		}
		List<String> list = new ArrayList<String>();
		HashSet<String> set = new HashSet<String>();

		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs("", i, j, board, visited, tr, list, set);
			}
		}
		return list;
	}

	public static void dfs(String currString, int x, int y, char[][] board, boolean[][] visited, Trie tr,
			List<String> list, HashSet<String> set) {
		if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || visited[x][y])
			return;
		currString += board[x][y];
		if (!tr.checkWordStartsWith(currString))
			return;
		if (tr.search(currString)) {
			if (!set.contains(currString)) {
				set.add(currString);
				list.add(currString);
			}
		}
		visited[x][y] = true;
		dfs(currString, x - 1, y, board, visited, tr, list, set);
		dfs(currString, x + 1, y, board, visited, tr, list, set);
		dfs(currString, x, y - 1, board, visited, tr, list, set);
		dfs(currString, x, y + 1, board, visited, tr, list, set);
		visited[x][y] = false;
	}

	static class TrieNode {
		char val;
		TrieNode[] childrens;
		boolean isWord = false;

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

		public boolean checkWordStartsWith(String word) {
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

}
