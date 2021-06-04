package June2021GoogLeetcode;

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
			for (int i = 0; i < times.length; i++) {
				tr.insertWord(sentences[i], times[i]);
			}
			str = "";
		}

		public List<String> input(char c) {
			if (c == '#') {
				tr.insertWord(str, 1);
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
			this.root = new TrieNode();
		}

		public void insertWord(String word, int count) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				tn.count.compute(word, (k, v) -> v == null ? count : v + count);
				if (tn.childrens[index] == null) {
					tn.childrens[index] = new TrieNode();
				}
				tn = tn.childrens[index];
			}
			tn.count.compute(word, (k, v) -> v == null ? count : v + count);
		}

		public List<String> searchWord(String word) {
			TrieNode tn = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c - 'a';
				if (c == ' ') {
					index = 26;
				}
				if (tn.childrens[index] == null) {
					return new ArrayList<String>();
				}
				tn = tn.childrens[index];
			}
			HashMap<String, Integer> map = tn.count;
			PriorityQueue<String> pq = new PriorityQueue<String>(new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					int count = map.get(o2) - map.get(o1);
					if (count == 0)
						return o1.compareTo(o2);
					return count;
				}
			});

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				pq.offer(entry.getKey());
			}

			List<String> list = new ArrayList<String>();
			while (!pq.isEmpty() && list.size() < 3) {
				list.add(pq.poll());
			}
			return list;
		}
	}

	static class TrieNode {
		TrieNode[] childrens;
		HashMap<String, Integer> count;

		public TrieNode() {
			this.childrens = new TrieNode[27];
			this.count = new HashMap<String, Integer>();
		}
	}

}
