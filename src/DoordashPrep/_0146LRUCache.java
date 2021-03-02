package DoordashPrep;

import java.util.HashMap;

public class _0146LRUCache {

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
		System.out.println(lRUCache.get(2)); // return 1 (found)
	}

	static class Node {
		int key, val;
		Node next, prev;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	static class LRUCache {
		int capacity;
		Node dummyHead, dummyTail;
		HashMap<Integer, Node> map;

		public LRUCache(int capacity) {
			map = new HashMap<Integer, Node>();
			this.capacity = capacity;
			dummyHead = new Node(-1, -1);
			dummyTail = new Node(-1, -1);
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
		}

		public void moveNodeToHead(Node node) {
			deleteNode(node);
			insertNode(node.key, node.val);
		}

		public void deleteNode(Node node) {
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			map.remove(node.key);
		}

		public void insertNode(int key, int value) {
			Node node = new Node(key, value);
			Node next = dummyHead.next;
			Node prev = dummyHead;

			prev.next = node;
			node.prev = prev;

			node.next = next;
			next.prev = node;

			map.put(key, node);
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				moveNodeToHead(node);
				return node.val;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				node.val = value;
				moveNodeToHead(node);
			} else {
				if (map.size() == this.capacity) {
					deleteNode(dummyTail.prev);
				}
				insertNode(key, value);
			}
		}
	}
}
