package Jan2021Leetcode;

import java.util.HashMap;

public class _0460LFUCache {

	public static void main(String[] args) {
		LFUCache lfu = new LFUCache(2);
		lfu.put(1, 1);
		lfu.put(2, 2);
		System.out.println(lfu.get(1)); // return 1
		lfu.put(3, 3); // evicts key 2
		System.out.println(lfu.get(2)); // return -1 (not found)
		System.out.println(lfu.get(3)); // return 3
		lfu.put(4, 4); // evicts key 1.
		System.out.println(lfu.get(1)); // return -1 (not found)
		System.out.println(lfu.get(3)); // return 3
		System.out.println(lfu.get(4)); // return 4
	}

	static class LFUCache {
		
		public LFUCache(int capacity) {
		}

		public int get(int key) {
		}

		public void updateNode(Node n) {
		}

		public void put(int key, int value) {
		
		}
	}

}
