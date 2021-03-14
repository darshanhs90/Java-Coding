package Feb2021Leetcode;

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
			;
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

		public void addWord(String str) {
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
				for (int j = 0; j < size; j++) {
					tn = q.poll();
					
					if(c == '.')
					{
						TrieNode childs[] = tn.childrens;
						for(TrieNode child : childs)
						{
							if(child!=null)
								q.offer(child);
						}
					}
					else {
						if(tn.childrens[c-'a']!=null)
						{
							q.offer(tn.childrens[c-'a']);
						}
					}
				}
			}
			while(!q.isEmpty())
			{
				if(q.poll().isWord)
					return true;
			}
			return false;
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

}
