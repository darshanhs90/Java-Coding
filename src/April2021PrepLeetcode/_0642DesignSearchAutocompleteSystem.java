package April2021PrepLeetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _0642DesignSearchAutocompleteSystem {

	public static void main(String[] args) {
		AutocompleteSystem acs = new AutocompleteSystem(
				new String[] { "i love you", "island", "ironman", "i love leetcode" }, new int[] { 5, 3, 2, 2 });

		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
		System.out.println(acs.input(' '));
		System.out.println(acs.input('a'));
		System.out.println(acs.input('#'));
		System.out.println(acs.input('i'));
	}

	static class AutocompleteSystem {
		Trie tr;
		String str;

		public AutocompleteSystem(String[] sentences, int[] times) {
			tr = new Trie();
			str = "";
			for (int i = 0; i < times.length; i++) {
				tr.addWord(sentences[i], times[i]);
			}
		}

		public List<String> input(char c) {
			if (c == '#') {
				tr.addWord(str, 1);
				str = "";
				return new ArrayList<String>();
			} else {
				str += c;
				return tr.searchWord(str);
			}
		}
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			this.root = new TrieNode(' ');
		}

		public void addWord(String str, int count) {
			TrieNode tn = this.root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				tn.childWords.compute(str, (k, v) -> v == null ? count : v + count);
				if (tn.childrens[index] == null) {
					tn.childrens[index] = new TrieNode(c);
				}
				tn = tn.childrens[index];
			}
			tn.childWords.compute(str, (k, v) -> v == null ? count : v + count);
		}

		public List<String> searchWord(String str) {
			TrieNode tn = this.root;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				if (tn.childrens[index] == null) {
					return new ArrayList<String>();
				}
				tn = tn.childrens[index];
			}

			HashMap<String, Integer> map = tn.childWords;
			PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					int count1 = map.get(o1);
					int count2 = map.get(o2);
					if (count1 == count2)
						return o1.compareTo(o2);
					return count2 - count1;
				}
			});

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				pq.offer(entry.getKey());
			}

			List<String> output = new ArrayList<String>();
			while (!pq.isEmpty() && output.size() < 3) {
				output.add(pq.poll());
			}
			return output;
		}
	}

	static class TrieNode {
		TrieNode[] childrens;
		char val;
		HashMap<String, Integer> childWords;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[27];
			this.childWords = new HashMap<String, Integer>();
		}
	}
}
