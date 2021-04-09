package SnapPrep;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class _00004Autocomplete {
	static class TrieNode {
		char val;
		TrieNode[] childrens;
		HashMap<String, Integer> childWords;

		public TrieNode(char val) {
			this.val = val;
			this.childrens = new TrieNode[27];
			this.childWords = new HashMap<String, Integer>();
		}
	}

	// a-z 27
	static class Trie {
		public static TrieNode rootNode;

		public Trie() {
			rootNode = new TrieNode(' ');
		}

		public void insertWord(String word, int count) {
			TrieNode tn = rootNode;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c == ' ' ? 26 : c - 'a';

				if (tn.childrens[index] == null) {
					tn.childrens[index] = new TrieNode(c);
				}
				if (!tn.childWords.containsKey(word)) {
					tn.childWords.put(word, count);
				} else {
					tn.childWords.put(word, tn.childWords.get(word) + count);
				}
				tn = tn.childrens[index];
			}
			if (!tn.childWords.containsKey(word)) {
				tn.childWords.put(word, count);
			} else {
				tn.childWords.put(word, tn.childWords.get(word) + count);
			}
		}

		public List<String> searchWord(String word, int k) {
			TrieNode tn = rootNode;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				int index = c == ' ' ? 26 : c - 'a';

				if (tn.childrens[index] == null) {
					new ArrayList<String>();
				}
				tn = tn.childrens[index];
			}

			HashMap<String, Integer> map = tn.childWords;

			PriorityQueue<String> pq = new PriorityQueue<String>(k, new Comparator<String>() {
				@Override
				public int compare(String str1, String str2) {
					int count1 = map.get(str1);
					int count2 = map.get(str2);
					return count2 - count1;
				}
			});

			for (Map.Entry<String, Integer> entry : map.entrySet()) {
				pq.add(entry.getKey());
				if (pq.size() > k)
					pq.poll();
			}

			List<String> list = new ArrayList<String>();
			while (!pq.isEmpty()) {
				list.add(pq.poll());
			}
			return list;
		}
	}

	public static class CompleteSystem {
		public static Trie tr;
		public static String str;
		public static int k;

		public CompleteSystem(String[] sentences, int[] count, int k) {
			tr = new Trie();
			str = "";
			this.k = k;
			for (int i = 0; i < sentences.length; i++) {
				tr.insertWord(sentences[i], count[i]);
			}
		}

		public static List<String> addChar(char c) {
			if (c == '#') {
				tr.insertWord(str, 1);
				str = "";
				return new ArrayList<String>();
			} else {
				str += c;
				return tr.searchWord(str, k);
			}
		}
	}

	public static void main(String[] args) {
		// Snap
		// completesystem.addChar('S');
		// completesystem.addChar('n');
		// completesystem.addChar('A');
		// completesystem.addChar('p');
		// completesystem.addChar('#');

	}

}
