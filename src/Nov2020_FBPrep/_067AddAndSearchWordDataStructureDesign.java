package Nov2020_FBPrep;

public class _067AddAndSearchWordDataStructureDesign {

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

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void addWord(String word) {
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
			if (word == null || word.length() == 0)
				return true;
			return searchWordDfs(root, 0, word);
		}

		public boolean searchWordDfs(TrieNode tn, int index, String word) {
			if (index >= word.length()) {
				return tn.isWord;
			}
			char c = word.charAt(index);
			if (c != '.') {
				if (tn.childrens[c - 'a'] == null)
					return false;
				return searchWordDfs(tn.childrens[c - 'a'], index + 1, word);
			} else {
				for (TrieNode child : tn.childrens) {
					if (child != null) {
						if (searchWordDfs(child, index + 1, word))
							return true;
					}
				}
				return false;
			}
		}
	}

	static class TrieNode {
		char val;
		boolean isWord = false;;
		TrieNode[] childrens;

		public TrieNode(char val) {
			this.val = val;
			childrens = new TrieNode[26];
		}
	}

	static class WordDictionary {
		Trie trie;

		/** Initialize your data structure here. */
		public WordDictionary() {
			this.trie = new Trie();
		}

		/** Adds a word into the data structure. */
		public void addWord(String word) {
			trie.addWord(word);
		}

		/**
		 * Returns if the word is in the data structure. A word could contain the dot
		 * character '.' to represent any one letter.
		 */
		public boolean search(String word) {
			return trie.searchWord(word);
		}
	}
}
