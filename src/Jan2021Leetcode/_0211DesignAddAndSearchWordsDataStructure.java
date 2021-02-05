package Jan2021Leetcode;

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
			tr.addNode(word);
		}

		public boolean search(String word) {
			return tr.search(word);
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void addNode(String str) {
			TrieNode tn = this.root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c - 'a';
				if (tn.childrens[index] == null) {
					tn.childrens[index] = new TrieNode(c);
				}
				tn = tn.childrens[index];
			}
			tn.isWord = true;
		}

		public boolean search(String str) {
			TrieNode tn = this.root;
			Queue<TrieNode> q = new LinkedList<TrieNode>();
			q.offer(tn);
			int i = 0;
			for (i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (q.size() == 0)
					return false;
				int size = q.size();
				if (c == '.') {
					for (int j = 0; j < size; j++) {
						TrieNode child = q.poll();
						for (TrieNode childNode : child.childrens) {
							if (childNode != null)
								q.offer(childNode);
						}
					}
				} else {
					for (int j = 0; j < size; j++) {
						TrieNode child = q.poll();
						int index = c - 'a';
						if (child.childrens[index] != null) {
							q.offer(child.childrens[index]);
						}
					}
				}
			}

			while(!q.isEmpty())
			{
				if(q.peek().isWord)
					return true;
				q.poll();
			}
			
			return false;
		}

	}

	static class TrieNode {
		char val;
		TrieNode[] childrens;
		boolean isWord = false;;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[26];
		}
	}

}
