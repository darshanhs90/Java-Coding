package Dec2020Leetcode;

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

	static class Node {
		int key, val, count;
		Node prev, next;

		public Node(int key, int val) {
			this.key = key;
			this.val = val;
			this.count = 1;
		}
	}

	static class DoublyLL {

		Node head, tail;
		int size;

		public DoublyLL() {
			this.head = new Node(-1, -1);
			this.tail = new Node(-1, -1);
			this.head.next = this.tail;
			this.tail.prev = this.head;
			this.size = 0;
		}

		public void addNode(Node n) {
			Node nextNode = this.head.next;
			this.head.next = n;
			n.next = nextNode;
			n.prev = this.head;
			nextNode.prev = n;
			this.size++;
		}

		public void remove(Node n) {
			Node prevNode = n.prev;
			Node nextNode = n.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			this.size--;
		}

		public Node removeLast() {
			if (this.size > 0) {
				Node n = tail.prev;
				this.remove(n);
				return n;
			}
			return null;
		}

	}

	static class LFUCache {
		HashMap<Integer, Node> keyCount = new HashMap<Integer, Node>();
		HashMap<Integer, DoublyLL> countDllList = new HashMap<Integer, DoublyLL>();
		int size = 0, capacity, min;

		public LFUCache(int capacity) {
			this.capacity = capacity;
		}

		public int get(int key) {
			if (capacity > 0 && keyCount.containsKey(key)) {
				Node n = keyCount.get(key);
				updateNode(n);
				return n.val;
			}
			return -1;
		}

		public void updateNode(Node n) {
			int prevCount = n.count;
			DoublyLL oldDll = countDllList.get(prevCount);
			oldDll.remove(n);
			if (min == prevCount && oldDll.size == 0) {
				min = prevCount + 1;
				countDllList.remove(prevCount);
			}

			n.count++;
			DoublyLL newDll = countDllList.getOrDefault(n.count, new DoublyLL());
			newDll.addNode(n);
			countDllList.put(n.count, newDll);
		}

		public void put(int key, int value) {
			if (capacity == 0)
				return;
			Node node;
			if (keyCount.containsKey(key)) {
				node = keyCount.get(key);
				node.val = value;
				updateNode(node);
			} else {
				node = new Node(key, value);
				keyCount.put(node.key, node);
				if (this.size == capacity) {
					DoublyLL lastList = countDllList.get(min);
					keyCount.remove(lastList.removeLast().key);
					size--;
				}

				this.size++;
				min = 1;
				DoublyLL newList = countDllList.getOrDefault(1, new DoublyLL());
				newList.addNode(node);
				countDllList.put(1, newList);
			}
		}
	}

}
