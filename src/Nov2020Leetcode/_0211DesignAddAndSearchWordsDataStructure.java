package Nov2020Leetcode;

public class _0211DesignAddAndSearchWordsDataStructure {

	public static void main(String[] args) {
		WordDictionary wordDictionary = new WordDictionary();
		wordDictionary.addWord("bad");
		wordDictionary.addWord("dad");
		wordDictionary.addWord("mad");
		System.out.println(wordDictionary.search("pad")); // return False
		System.out.println(wordDictionary.search("bad")); // return True
		System.out.println(wordDictionary.search(".ad")); // return True
		System.out.println(wordDictionary.search("b..")); // return True
	}

	static class WordDictionary {
		Trie trie;

		/** Initialize your data structure here. */
		public WordDictionary() {
			trie = new Trie();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			trie.insert(word);
		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot
		 * character '.' to represent any one letter.
		 */
		public boolean search(String word) {
			return trie.search(word);
		}
	}

	static class TrieNode {
		boolean isWord;
		char val;
		TrieNode[] childrens;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[26];
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode(' ');
		}

		public void insert(String word) {
			TrieNode wordNode = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (wordNode.childrens[c - 'a'] != null) {
				} else {
					wordNode.childrens[c - 'a'] = new TrieNode(c);
				}
				wordNode = wordNode.childrens[c - 'a'];
			}
			wordNode.isWord = true;
		}

		public boolean search(String word) {
			return searchWord(0, word, root);
		}

		public boolean searchWord(int index, String word, TrieNode node) {
			if (index == word.length())
				return node.isWord;
			char c = word.charAt(index);
			if (c == '.') {
				for (TrieNode childNode : node.childrens) {
					if (childNode != null && searchWord(index + 1, word, childNode))
						return true;
				}
			} else {
				return node.childrens[c - 'a'] != null && searchWord(index + 1, word, node.childrens[c - 'a']);
			}
			return false;
		}
	}
}
