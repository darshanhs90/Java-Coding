package Feb2021Leetcode;

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
		int key, value;
		Node prev, next;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}

	}

	static class LRUCache {
		Node dummyHead, dummyTail;
		HashMap<Integer, Node> map;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			dummyHead = new Node(-1, -1);
			dummyTail = new Node(-1, -1);
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
			map = new HashMap<Integer, Node>();
		}

		public void addNode(int key, int value) {
			Node newNode = new Node(key, value);
			Node nextNode = dummyHead.next;

			dummyHead.next = newNode;
			newNode.next = nextNode;

			nextNode.prev = newNode;
			newNode.prev = dummyHead;
			map.put(key, newNode);
		}

		public void removeNode(Node node) {
			Node prevNode = node.prev;
			Node nextNode = node.next;

			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			map.remove(node.key);
		}

		public void moveNodeToHead(Node node) {
			removeNode(node);
			addNode(node.key, node.value);
		}

		public int get(int key) {
			if (!map.containsKey(key))
				return -1;

			Node node = map.get(key);
			moveNodeToHead(node);
			return node.value;
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				node.value = value;
				moveNodeToHead(node);
			} else {
				if (this.map.size() == this.capacity) {
					removeNode(dummyTail.prev);
					addNode(key, value);
				} else {
					addNode(key, value);
				}
			}
		}
	}
}
