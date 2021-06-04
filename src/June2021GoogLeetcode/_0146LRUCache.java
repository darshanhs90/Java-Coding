package June2021GoogLeetcode;

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
		int c;
		Node h, t;
		HashMap<Integer, Node> map;

		public LRUCache(int capacity) {
			this.c = capacity;
			h = new Node(-1, -1);
			t = new Node(-1, -1);
			h.next = t;
			t.prev = h;
			map = new HashMap<Integer, Node>();
		}

		public int get(int key) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				moveNodeToHead(node);
				return node.value;
			}
			return -1;
		}

		public void addNode(int key, int value) {
			Node newNode = new Node(key, value);
			Node prev = h;
			Node next = h.next;
			prev.next = newNode;
			newNode.next = next;
			next.prev = newNode;
			newNode.prev = prev;
			map.put(key, newNode);
		}

		public void deleteNode(Node node) {
			Node prev = node.prev;
			Node next = node.next;
			prev.next = next;
			next.prev = prev;
			map.remove(node.key);
		}

		public void moveNodeToHead(Node node) {
			deleteNode(node);
			addNode(node.key, node.value);
		}

		public void put(int key, int value) {
			if (map.containsKey(key)) {
				Node node = map.get(key);
				node.value = value;
				moveNodeToHead(node);
			} else {
				if (map.size() < c) {
					addNode(key, value);
				} else {
					deleteNode(t.prev);
					addNode(key, value);
				}
			}
		}
	}

}
