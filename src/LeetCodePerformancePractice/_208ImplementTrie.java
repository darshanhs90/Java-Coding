package LeetCodePerformancePractice;

import java.util.HashMap;
import java.util.Map;

public class _208ImplementTrie {
	class TrieNode {
		// Initialize your data structure here.
		char c;
		HashMap<Character, TrieNode> childrens=new HashMap<>();
		boolean isLeaf;
		public TrieNode() {

		}
		public TrieNode(char c)
		{
			this.c=c;
		}
	}

	public class Trie {
		private TrieNode root;
		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			HashMap<Character, TrieNode> child=root.childrens;
			for (int i = 0; i < word.length(); i++) {
				if(!child.containsKey(word.charAt(i)))
				{
					child.put(word.charAt(i), new TrieNode(word.charAt(i)));
				}
				if(i==word.length()-1)
					child.get(word.charAt(i)).isLeaf = true;    
				child=child.get(word.charAt(i)).childrens;
			}
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode t=searchUtil(root,word);
			return t!=null && t.isLeaf?true:false;
		}

		private TrieNode searchUtil(TrieNode tn,String word) {
			if(tn==null)			
				return null;
			TrieNode t=null;
			Map<Character, TrieNode> children = root.childrens; 
			for (int i = 0; i < word.length(); i++) {
				if(children.containsKey(word.charAt(i)))
				{
					t=children.get(word.charAt(i));
					children=t.childrens;
				}
				else{
					return null;
				}	
			}
			return t;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			if(searchUtil(root, prefix)==null)
				return false;
			return true;
		}
	}
}
