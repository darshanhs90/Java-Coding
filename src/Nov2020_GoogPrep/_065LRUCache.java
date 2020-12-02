package Nov2020_GoogPrep;

import java.util.HashMap;

public class _065LRUCache {

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

		lRUCache = new LRUCache(2);
		System.out.println(lRUCache.get(2));
		lRUCache.put(2, 6);
		System.out.println(lRUCache.get(1));
		lRUCache.put(1, 5);
		lRUCache.put(1, 2);
		System.out.println(lRUCache.get(1));
		System.out.println(lRUCache.get(2));
	}

	static class Node {
		int key, val;
		Node prev, next;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.prev = null;
			this.next = null;
		}
	}

	static class LRUCache {
		Node dummyHead, dummyTail;
		HashMap<Integer, Node> nodeMap;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			dummyHead = new Node(-1, -1);
			dummyTail = new Node(-1, -1);
			dummyHead.next = dummyTail;
			dummyHead.prev = null;
			dummyTail.prev = dummyHead;
			dummyTail.next = null;
			nodeMap = new HashMap<Integer, Node>();
		}

		public int get(int key) {
			if (nodeMap.containsKey(key)) {
				int val = nodeMap.get(key).val;
				moveNodeToHead(key, val);
				return val;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (nodeMap.containsKey(key)) {
				moveNodeToHead(key, value);
			} else {
				if (nodeMap.size() == capacity) {
					deleteNode(dummyTail.prev);
					addNode(key, value);
				} else {
					addNode(key, value);
				}
			}
		}

		private void deleteNode(Node n) {
			Node prevNode = n.prev;
			Node nextNode = n.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			nodeMap.remove(n.key);
		}

		private void addNode(int key, int val) {
			Node newNode = new Node(key, val);
			Node nextNode = dummyHead.next;
			dummyHead.next = newNode;
			newNode.prev = dummyHead;
			newNode.next = nextNode;
			nextNode.prev = newNode;
			nodeMap.put(key, newNode);
		}

		private void moveNodeToHead(int key, int val) {
			deleteNode(nodeMap.get(key));
			addNode(key, val);
		}

	}
}
