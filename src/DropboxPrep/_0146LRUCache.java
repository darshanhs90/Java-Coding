package DropboxPrep;

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
		int key;
		int value;
		Node next, prev;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

	static class LRUCache {
		HashMap<Integer, Node> nodeMap;
		Node dummyHead, dummyTail;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			this.nodeMap = new HashMap<Integer, Node>();
			this.dummyHead = new Node(-1, -1);
			this.dummyTail = new Node(-1, -1);
			this.dummyHead.next = this.dummyTail;
			this.dummyTail.prev = this.dummyHead;
		}

		public int get(int key) {
			if (nodeMap.containsKey(key)) {
				Node node = nodeMap.get(key);
				moveNodeToHead(node);
				return node.value;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (nodeMap.containsKey(key)) {
				Node node = nodeMap.get(key);
				node.value = value;
				moveNodeToHead(node);
			} else {
				if (this.nodeMap.size() == capacity) {
					deleteNode(dummyTail.prev);
					insertNode(key, value);
				} else {
					insertNode(key, value);
				}
			}
		}

		public void deleteNode(Node node) {
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			nodeMap.remove(node.key);
		}

		public void insertNode(int key, int value) {
			Node node = new Node(key, value);
			Node prev = dummyHead;
			Node next = dummyHead.next;

			prev.next = node;
			node.prev = prev;

			node.next = next;
			next.prev = node;

			nodeMap.put(key, node);
		}

		public void moveNodeToHead(Node node) {
			deleteNode(node);
			insertNode(node.key, node.value);
		}
	}
}
