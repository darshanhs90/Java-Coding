package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0706DesignHashMap {
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.put(10001, 4);
		System.out.println(hashMap.get(1)); // returns 1
		System.out.println(hashMap.get(3)); // returns -1
		System.out.println(hashMap.get(10001)); // returns 4
		hashMap.remove(1); // remove the mapping for 1
		System.out.println(hashMap.get(1)); // returns -1
		hashMap.put(2, 1); // update the existing value
		System.out.println(hashMap.get(2)); // returns 1
		hashMap.remove(2); // remove the mapping for 2
		System.out.println(hashMap.get(2)); // returns -1 (not found)
	}

	static class Pair {
		int key, value;

		public Pair(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	static class Node {
		List<Pair> subLists;

		public Node() {
			this.subLists = new ArrayList<Pair>();
		}

		public boolean contains(int key) {
			for (int i = 0; i < subLists.size(); i++) {
				if (subLists.get(i).key == key)
					return true;
			}
			return false;
		}

		public void update(int key, int value) {
			for (int i = 0; i < subLists.size(); i++) {
				if (subLists.get(i).key == key) {
					subLists.set(i, new Pair(key, value));
					return;
				}
			}
		}

		public void add(int key, int value) {
			subLists.add(new Pair(key, value));
		}

		public int fetch(int key) {
			for (int i = 0; i < subLists.size(); i++) {
				if (subLists.get(i).key == key)
					return subLists.get(i).value;
			}
			return -1;
		}

		public void remove(int key) {
			for (int i = 0; i < subLists.size(); i++) {
				if (subLists.get(i).key == key) {
					subLists.remove(i);
					return;
				}
			}
		}

	}

	static class MyHashMap {
		List<Node> list;
		int noOfKeys = 2069;

		/** Initialize your data structure here. */
		public MyHashMap() {
			list = new ArrayList<Node>();
			for (int i = 0; i < noOfKeys; i++) {
				list.add(new Node());
			}
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			int newKey = key % noOfKeys;
			if (list.get(newKey).contains(key)) {
				list.get(newKey).update(key, value);
			} else {
				list.get(newKey).add(key, value);
			}
		}

		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map
		 * contains no mapping for the key
		 */
		public int get(int key) {
			int newKey = key % noOfKeys;
			return list.get(newKey).fetch(key);
		}

		/**
		 * Removes the mapping of the specified value key if this map contains a mapping
		 * for the key
		 */
		public void remove(int key) {
			int newKey = key % noOfKeys;
			list.get(newKey).remove(key);
		}
	}

}
