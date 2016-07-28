package eBayPrep;

import java.util.HashMap;

public class _208ImplementTrie{
	static class TrieNode{
		char c;
		boolean isLeaf=false;
		HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
		public TrieNode() {}
		public TrieNode(char c) {
			this.c=c;
		}

	}
	private TrieNode root;
	public _208ImplementTrie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c1=word.charAt(i);
			TrieNode t;
			if(children.containsKey(c1))
			{
				t=children.get(c1);
			}
			else{
				t=new TrieNode(c1);
				children.put(c1, t);
			}
			children=t.children;
			if(i==word.length()-1)
				t.isLeaf=true;
		}
	}

	public boolean search(String word) {
		TrieNode t = searchTrieNode(word);
        if(t != null && t.isLeaf) 
            return true;
        else
            return false;
	}

	private TrieNode searchTrieNode(String word) {
		HashMap<Character, TrieNode> children=root.children;
		TrieNode pointer=null;
		for (int i = 0; i < word.length(); i++) {
			char c1=word.charAt(i);
			if(children.containsKey(c1))
			{
				pointer=children.get(c1);
				children=pointer.children;
			}
			else
				return null;
		}
		return pointer;
	}

	public boolean startsWith(String prefix) {
		return searchTrieNode(prefix)!=null;
	}
	
	public static void main(String[] args) {
		_208ImplementTrie a=new _208ImplementTrie();
		a.insert("ab");
		System.out.println(a.search("a"));
		System.out.println(a.search("ab"));
		System.out.println(a.startsWith("a"));
		System.out.println(a.startsWith("ab"));
		
	}
}

