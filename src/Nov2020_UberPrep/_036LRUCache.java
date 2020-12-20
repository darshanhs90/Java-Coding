package Nov2020_UberPrep;

import java.util.HashMap;

public class _036LRUCache {

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
		Node dummyHead = new Node(-1, -1);
		Node dummyTail = new Node(-1, -1);
		HashMap<Integer, Node> keyValueMap;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			this.dummyHead = new Node(-1, -1);
			this.dummyTail = new Node(-1, -1);
			this.keyValueMap = new HashMap<Integer, Node>();
			this.dummyHead.next = this.dummyTail;
			this.dummyTail.prev = this.dummyHead;
		}

		public int get(int key) {
			if (keyValueMap.containsKey(key)) {
				Node valueNode = keyValueMap.get(key);
				int returnValue = valueNode.val;
				deleteNode(valueNode);
				addNode(key, returnValue);
				return returnValue;
			}
			return -1;
		}

		private void deleteNode(Node n) {
			Node prevNode = n.prev;
			Node nextNode = n.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			this.keyValueMap.remove(n.key);
		}

		private void addNode(int key, int value) {
			Node newNode = new Node(key, value);
			Node prevNode = this.dummyHead;
			Node nextNode = this.dummyHead.next;
			prevNode.next = newNode;
			newNode.prev = prevNode;
			newNode.next = nextNode;
			nextNode.prev = newNode;
			this.keyValueMap.put(key, newNode);
		}

		public void put(int key, int value) {
			if (keyValueMap.containsKey(key)) {
				deleteNode(keyValueMap.get(key));
				addNode(key, value);
			} else if (keyValueMap.size() == capacity) {
				deleteNode(dummyTail.prev);
				addNode(key, value);
			} else {
				addNode(key, value);
			}
		}
	}

}
