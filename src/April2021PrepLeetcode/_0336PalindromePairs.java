package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _0336PalindromePairs {
// http://www.allenlipeng47.com/blog/index.php/2016/03/15/palindrome-pairs/
	public static void main(String[] args) {
		System.out.println(palindromePairs(new String[] { "abcd", "dcba", "lls", "s", "sssll" }));
		System.out.println(palindromePairs(new String[] { "bat", "tab", "cat" }));
		System.out.println(palindromePairs(new String[] { "a", "" }));

	}

	public static List<List<Integer>> palindromePairs(String[] words) {
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
		char c;
		TrieNode[] childrens;
		List<Integer> palIndex;
		int pos = -1;

		public TrieNode(char c) {
			this.c = c;
			this.childrens = new TrieNode[26];
			this.palIndex = new ArrayList<Integer>();
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode(' ');
		}

		public void addWord(String word, int index) {
			TrieNode tn = root;
			for (int i = word.length() - 1; i >= 0; i--) {
				String str = word.substring(0, i);
				if (isPalindrome(str)) {
					tn.palIndex.add(index);
				}
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null) {
					tn.childrens[c - 'a'] = new TrieNode(c);
				}
				tn = tn.childrens[c - 'a'];
			}
			tn.palIndex.add(index);
			tn.pos = index;
		}

		public void searchWord(String word, int index, List<List<Integer>> out) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				if (root.pos != -1 && root.pos != index) {
					String str = word.substring(i, word.length() - 1);
					if (isPalindrome(str)) {
						out.add(Arrays.asList(new Integer[] { i, root.pos }));
					}
				}
				char c = word.charAt(i);
				if (tn.childrens[c - 'a'] == null)
					return;
				tn = tn.childrens[c - 'a'];
			}

			if (tn != null && tn.palIndex.size() > 0) { // assume 'xyxabc' is in trie,
				for (int j : root.palIndex) {
					if (j != index) {
						out.add(Arrays.asList(new Integer[] { index, j }));
					}
				}
			}
		}

		public boolean isPalindrome(String str) {
			int left = 0, right = str.length() - 1;
			while (left < right) {
				if (str.charAt(left) != str.charAt(right))
					return false;
				left++;
				right--;
			}
			return true;
		}
	}

}
