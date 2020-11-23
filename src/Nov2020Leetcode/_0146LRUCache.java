package Nov2020Leetcode;

import java.util.HashMap;

public class _0146LRUCache {

	static class ListNode {
		ListNode prev = null;
		ListNode next = null;
		int key;
		int val;

		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}

	}

	static public class LRUCache {
		HashMap<Integer, ListNode> map;
		ListNode fakeHead, fakeTail;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			map = new HashMap<Integer, ListNode>(capacity);
			fakeHead = new ListNode(-1, -1);
			fakeTail = new ListNode(-1, -1);
			fakeHead.next = fakeTail;
			fakeTail.prev = fakeHead;
		}

		private void addNode(int key, int value) {
			ListNode nextNode = fakeHead.next;
			ListNode newNode = new ListNode(key, value);
			fakeHead.next = newNode;
			newNode.next = nextNode;
			nextNode.prev = newNode;
			newNode.prev = fakeHead;
			map.put(key, newNode);
		}

		private void deleteNode(ListNode node) {
			node.next.prev = node.prev;
			node.prev.next = node.next;
			map.remove(node.key);
		}

		private void moveNodeToHead(int key, int value) {
			deleteNode(map.get(key));
			addNode(key, value);
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				ListNode node = map.get(key);
				deleteNode(node);
				addNode(key, node.val);
				return node.val;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (map.size() < capacity && !map.containsKey(key)) {
				addNode(key, value);
			} else {
				if (map.size() == capacity) {
					if (map.containsKey(key)) {
						moveNodeToHead(key, value);
					} else {
						deleteNode(map.get(fakeTail.prev.key));
						addNode(key, value);
					}
				} else {
					moveNodeToHead(key, value);
				}
			}
		}
	}

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(2);
		lRUCache.put(1, 1); // cache is {1=1}
		lRUCache.put(2, 2); // cache is {1=1, 2=2}
		System.out.println(lRUCache.get(1)); // return 1
		lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
		System.out.println(lRUCache.get(2)); // returns -1 (not found)
		lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
		System.out.println(lRUCache.get(1)); // return -1 (not found)
		System.out.println(lRUCache.get(3)); // return 3
		System.out.println(lRUCache.get(4)); // return 4

		lRUCache = new LRUCache(1);
		lRUCache.put(2, 1); // cache is {1=1}
		System.out.println(lRUCache.get(2)); // return -1 (not found)
	}

}
