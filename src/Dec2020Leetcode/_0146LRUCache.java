package Dec2020Leetcode;

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
		HashMap<Integer, Node> map;
		Node dummyHead, dummyTail;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			map = new HashMap<Integer, Node>();
			dummyHead = new Node(-1, -1);
			dummyTail = new Node(-1, -1);
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				Node n = map.get(key);
				deleteNode(n);
				addNodeToHead(key, n.val);
				return n.val;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				Node n = map.get(key);
				deleteNode(n);
				addNodeToHead(key, value);
			} else {
				if (map.size() == capacity) {
					deleteNode(dummyTail.prev);
				}
				addNodeToHead(key, value);
			}
		}

		private void addNodeToHead(int key, int value) {
			Node newNode = new Node(key, value);
			Node nextNode = dummyHead.next;
			dummyHead.next = newNode;
			newNode.next = nextNode;
			nextNode.prev = newNode;
			newNode.prev = dummyHead;
			map.put(key, newNode);
		}

		private void deleteNode(Node node) {
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			map.remove(node.key);
		}

	}
}
