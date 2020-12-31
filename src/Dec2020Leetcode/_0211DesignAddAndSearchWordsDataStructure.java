package Dec2020Leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

		wordDictionary = new WordDictionary();
		wordDictionary.addWord("at");
		wordDictionary.addWord("and");
		wordDictionary.addWord("an");
		wordDictionary.addWord("add");
		System.out.println(wordDictionary.search("a")); // return False
		System.out.println(wordDictionary.search(".at")); // return False
		wordDictionary.addWord("bat");
		System.out.println(wordDictionary.search(".at")); // return True
		System.out.println(wordDictionary.search("an.")); // return True
		System.out.println(wordDictionary.search("a.d.")); // return False
		System.out.println(wordDictionary.search("b.")); // return False
		System.out.println(wordDictionary.search("a.d")); // return True
		System.out.println(wordDictionary.search(".")); // return False

	}

	static class WordDictionary {
		Trie trie;

		/** Initialize your data structure here. */
		public WordDictionary() {
			trie = new Trie();
		}

		public void addWord(String word) {
			trie.insert(word);
		}

		public boolean search(String word) {
			return trie.startsWith(word);
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

	static class Trie {
		TrieNode root;

		/** Initialize your data structure here. */
		public Trie() {
			this.root = new TrieNode(' ');
		}

		/** Inserts a word into the trie. */
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

		/**
		 * Returns if there is any word in the trie that starts with the given prefix.
		 */
		public boolean startsWith(String prefix) {
			TrieNode tn = this.root;
			Queue<TrieNode> q = new LinkedList<TrieNode>();
			q.offer(tn);
			int index = 0;
			while (!q.isEmpty() && index < prefix.length()) {
				int size = q.size();
				for (int i = 0; i < size; i++) {
					TrieNode curr = q.poll();
					char c = prefix.charAt(index);
					if (c != '.') {
						if (curr.childrens[c - 'a'] == null)
							continue;
						if (index == prefix.length() - 1) {
							if (curr.childrens[c - 'a'].isWord)
								return true;
						} else {
							q.offer(curr.childrens[c - 'a']);
						}
					} else {
						for (TrieNode child : curr.childrens) {
							if (child != null) {
								if (index == prefix.length() - 1) {
									if (child.isWord)
										return true;
								} else {
									q.offer(child);
								}
							}
						}
					}
				}
				index++;
			}
			return false;
		}
	}
}
