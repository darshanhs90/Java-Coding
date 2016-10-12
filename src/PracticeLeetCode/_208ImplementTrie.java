package PracticeLeetCode;

import java.util.HashMap;

public class _208ImplementTrie {
	class TrieNode {
		// Initialize your data structure here.
		boolean isLeaf=false;
		HashMap<Character, TrieNode> children;
		public TrieNode() {
			children=new HashMap<>();
		}
	}

	private TrieNode root;

	public _208ImplementTrie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		TrieNode tn=root;
		HashMap<Character, TrieNode> children=root.children;
		for (int i = 0; i < word.length(); i++) {
			char c=word.charAt(i);
			if(children.containsKey(c))
			{
				tn=children.get(c);
				children=tn.children;
			}
			else{
				TrieNode tn1=new TrieNode();
				children.put(c, tn1);
				tn=tn1;
				children=tn1.children;
			}
			if(i==word.length()-1)
				tn.isLeaf=true;
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode tn=findNode(word);
		if(tn!=null && tn.isLeaf==true)
			return true;
		return false;
	}


	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		return findNode(prefix)!=null;
	}


	private TrieNode findNode(String word) {
		TrieNode tn=root; 
		HashMap<Character, TrieNode> children=tn.children;
		int index=0;
		while(tn!=null && index<word.length())
		{
			char c=word.charAt(index);
			if(children.containsKey(c))
			{
				tn=children.get(c);
				children=tn.children;
				index++;
			}
			else{
				return null;
			}
		}
		return tn;
	}



}