package May2021PrepLeetcode;

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
		Trie tr;

		/** Initialize your data structure here. */
		public WordDictionary() {
			tr = new Trie();
		}

		public void addWord(String word) {
			tr.addWord(word);
		}

		public boolean search(String word) {
			return tr.searchWord(word);
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

		public Trie() {
			root = new TrieNode(' ');
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
			Queue<TrieNode> q = new LinkedList<TrieNode>();
			q.offer(root);
			for (int i = 0; i < word.length(); i++) {
				if (q.isEmpty())
					return false;
				char c = word.charAt(i);
				int size = q.size();
				for (int j = 0; j < size; j++) {
					TrieNode tn = q.poll();
					if (c == '.') {
						TrieNode[] childs = tn.childrens;
						for (TrieNode child : childs) {
							if (child != null)
								q.offer(child);
						}
					} else {
						if (tn.childrens[c - 'a'] != null) {
							q.offer(tn.childrens[c - 'a']);
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
}
