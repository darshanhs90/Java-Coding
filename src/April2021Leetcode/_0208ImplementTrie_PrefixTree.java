package April2021Leetcode;

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

	static class Trie {
		
		/** Initialize your data structure here. */
		public Trie() {
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
		}

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
		}
	}

}
