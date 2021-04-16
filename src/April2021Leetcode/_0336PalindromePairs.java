package April2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0336PalindromePairs {

	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(palindromePairs(new String[] { "bat", "tab", "cat" }));
		System.out.println(palindromePairs(new String[] { "a", "" }));
	}

	/*public static List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> ans = new ArrayList<>();
		Trie trie = new Trie();
		for (int i = 0; i < words.length; i++) {
			trie.addWord(words[i], i);
		}
		for (int i = 0; i < words.length; i++) {
			trie.searchWord(words[i], i, ans);
		}
		return ans;
	}

	static class TrieNode {
		TrieNode[] childrens;
		int index;
		List<Integer> palindromeIndexes;

		public TrieNode() {
			this.childrens = new TrieNode[26];
			this.index = -1;
			this.palindromeIndexes = new ArrayList<Integer>();
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode();
		}

		public void addWord(String word, int index) {
			TrieNode tn = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				if (isPalindrome(word, 0, i)) {
					tn.palindromeIndexes.add(index);
				}

				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode();
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.palindromeIndexes.add(index);
			tn.index = index;
		}

		public void searchWord(String word, int index, List<List<Integer>> out) {
			TrieNode tn = root;
			for (int j = 0; j < word.length() && tn != null; j++) {
				if (tn.index >= 0 && tn.index != index && isPalindrome(word, j, word.length() - 1)) {
					out.add(Arrays.asList(new Integer[] { index, root.index }));
				}

				char c = word.charAt(j);
				if (tn.childrens[c - 'a'] == null)
					return;

				tn = tn.childrens[c - 'a'];
			}

			if (root != null && root.palindromeIndexes.size() > 0) { // assume 'xyxabc' is in trie, now try 'cba'
				for (int j : root.palindromeIndexes) {
					if (j != index) {
						out.add(Arrays.asList(new Integer[] { index, j }));
					}
				}
			}

		}

		public boolean isPalindrome(String word, int left, int right) {
			while (left < right) {
				if (word.charAt(left) != word.charAt(right))
					return false;
				left++;
				right--;
			}
			return true;
		}

	}*/
	private static class TrieNode {
	    TrieNode[] next;
	    int index;
	    List<Integer> list;
	    	
	    TrieNode() {
	    	next = new TrieNode[26];
	    	index = -1;
	    	list = new ArrayList<>();
	    }
	}
	    
	public static List<List<Integer>> palindromePairs(String[] words) {
	    List<List<Integer>> res = new ArrayList<>();

	    TrieNode root = new TrieNode();
			
	    for (int i = 0; i < words.length; i++) {
	        addWord(root, words[i], i);
	    }
			
	    for (int i = 0; i < words.length; i++) {
	        search(words, i, root, res);
	    }
	    
	    return res;
	}
	    
	private static void addWord(TrieNode root, String word, int index) {
	    for (int i = word.length() - 1; i >= 0; i--) {
	        int j = word.charAt(i) - 'a';
					
	        if (root.next[j] == null) {
	            root.next[j] = new TrieNode();
	        }
					
	        if (isPalindrome(word, 0, i)) {
	            root.list.add(index);
	        }
					
	        root = root.next[j];
	    }
	    	
	    root.list.add(index);
	    root.index = index;
	}
	    
	private static void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
	    for (int j = 0; j < words[i].length(); j++) {	
	    	if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
	    	    res.add(Arrays.asList(i, root.index));
	    	}
	    		
	    	root = root.next[words[i].charAt(j) - 'a'];
	      	if (root == null) return;
	    }
	    	
	    for (int j : root.list) {
	    	if (i == j) continue;
	    	res.add(Arrays.asList(i, j));
	    }
	}
	    
	private static boolean isPalindrome(String word, int i, int j) {
	    while (i < j) {
	    	if (word.charAt(i++) != word.charAt(j--)) return false;
	    }
	    	
	    return true;
	}

}
