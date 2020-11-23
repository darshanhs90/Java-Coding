package Nov2020Leetcode;

public class _0208ImplementTrie_PrefixTree {

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("apple");
		System.out.println(trie.search("apple")); // returns true
		System.out.println(trie.search("app")); // returns false
		System.out.println(trie.startsWith("app")); // returns true
		trie.insert("app");
		System.out.println(trie.search("app")); // returns true
	}

	static class TrieNode {
		boolean isWord;
		TrieNode[] childrens;
		char val;

		public TrieNode(char c) {
			this.val = c;
			this.childrens = new TrieNode[26];
		}
	}

	static class Trie {
		TrieNode root;

		/** Initialize your data structure here. */
		public Trie() {
			root = new TrieNode(' ');
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			if (word.length() == 0)
				return;
			TrieNode wordNode = root;

			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (wordNode.childrens[c - 'a'] == null) {
					wordNode.childrens[c - 'a'] = new TrieNode(c);
				}
				wordNode = wordNode.childrens[c - 'a'];
			}
			wordNode.isWord = true;
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			TrieNode wordNode = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (wordNode.childrens[c - 'a'] == null) {
					return false;
				}
				wordNode = wordNode.childrens[c - 'a'];
			}
			return wordNode.isWord;
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode wordNode = root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (wordNode.childrens[c - 'a'] == null) {
					return false;
				}
				wordNode = wordNode.childrens[c - 'a'];
			}
			return true;
		}
	}
}
