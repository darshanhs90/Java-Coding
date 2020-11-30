package Nov2020_FBPrep;

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
		int val, key;
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
		HashMap<Integer, Node> valueMap;
		int capacity;

		public LRUCache(int capacity) {
			this.capacity = capacity;
			dummyHead = new Node(-1, -1);
			dummyTail = new Node(-1, -1);
			dummyHead.next = dummyTail;
			dummyTail.prev = dummyHead;
			valueMap = new HashMap<Integer, Node>();
		}

		public int get(int key) {
			if (valueMap.containsKey(key)) {
				moveNodeToHead(key);
				return valueMap.get(key).val;
			}
			return -1;
		}

		public void put(int key, int value) {
			if (valueMap.containsKey(key)) {
				deleteNode(valueMap.get(key));
				addNewNode(key, value);
			} else {
				if (valueMap.size() == capacity) {
					deleteNode(dummyTail.prev);
				}
				addNewNode(key, value);
			}
		}

		private void moveNodeToHead(int key) {
			int val = valueMap.get(key).val;
			deleteNode(valueMap.get(key));
			addNewNode(key, val);
		}

		private void addNewNode(int key, int value) {
			Node n = new Node(key, value);
			Node nextNode = dummyHead.next;
			dummyHead.next = n;
			n.next = nextNode;
			nextNode.prev = n;
			n.prev = dummyHead;
			valueMap.put(key, n);
		}

		private void deleteNode(Node n) {
			Node prev = n.prev;
			Node next = n.next;
			prev.next = next;
			next.prev = prev;
			valueMap.remove(n.key);
		}
	}
}
