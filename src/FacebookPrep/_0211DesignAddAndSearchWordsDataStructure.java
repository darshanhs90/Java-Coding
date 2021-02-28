package FacebookPrep;

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
			trie.insertNode(word);
		}

		public boolean search(String word) {
			return trie.search(word);
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void insertNode(String str) {
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

		public boolean search(String str) {
			TrieNode tn = this.root;
			Queue<TrieNode> q = new LinkedList<TrieNode>();
			q.offer(tn);
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int size = q.size();
				if (size == 0)
					return false;
				for (int j = 0; j < size; j++) {
					TrieNode tn1 = q.poll();
					if (c == '.') {
						if (tn1.childrens != null) {
							for (int k = 0; k < tn1.childrens.length; k++) {
								if (tn1.childrens[k] != null)
									q.offer(tn1.childrens[k]);
							}
						}
					} else {
						if (tn1.childrens[c - 'a'] != null) {
							q.offer(tn1.childrens[c - 'a']);
						}
					}
				}
			}
			while (!q.isEmpty()) {
				if (q.poll().isWord)
					return true;
			}
			return false;
		}

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

}
