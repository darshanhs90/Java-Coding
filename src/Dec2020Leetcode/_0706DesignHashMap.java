package Dec2020Leetcode;

public class _0706DesignHashMap {
	public static void main(String[] args) {
		MyHashMap hashMap = new MyHashMap();
		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.put(10001, 4);
		System.out.println(hashMap.get(1)); // returns 1
		System.out.println(hashMap.get(3)); // returns -1 
		System.out.println(hashMap.get(10001)); // returns 4 
		hashMap.remove(1); // remove the mapping for 1
		System.out.println(hashMap.get(1)); // returns 1
		hashMap.put(2, 1); // update the existing value
		System.out.println(hashMap.get(2)); // returns 1
		hashMap.remove(2); // remove the mapping for 2
		System.out.println(hashMap.get(2)); // returns -1 (not found)
	}

	static class ListNode {
		int key, val;
		ListNode next;

		public ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	static class MyHashMap {
		ListNode[] nodes;

		/** Initialize your data structure here. */
		public MyHashMap() {
			nodes = new ListNode[10000];
		}

		/** value will always be non-negative. */
		public void put(int key, int value) {
			int index = getHashCode(key);
			if (nodes[index] == null) {
				ListNode ln = new ListNode(-1, -1);
				ln.next = new ListNode(key, value);
				nodes[index] = ln;
			} else {
				ListNode ln = findElement(index, key);
				if (ln != null)
					ln.val = value;
				else {
					ListNode lnPtr = nodes[index];
					ListNode next = lnPtr.next;
					ListNode newNode = new ListNode(key, value);
					lnPtr.next = newNode;
					newNode.next = next;
				}
			}
		}

		public ListNode findElement(int index, int key) {
			ListNode ln = nodes[index].next;

			while (ln != null && ln.key != key)
				ln = ln.next;

			return ln == null ? null : ln;
		}

		public int getHashCode(int key) {
			return key % nodes.length;
		}

		/**
		 * Returns the value to which the specified key is mapped, or -1 if this map
		 * contains no mapping for the key
		 */
		public int get(int key) {
			int index = getHashCode(key);
			if (nodes[index] == null)
				return -1;

			ListNode node = findElement(index, key);
			if (node == null)
				return -1;
			return node.val;
		}

		/**
		 * Removes the mapping of the specified value key if this map contains a mapping
		 * for the key
		 */
		public void remove(int key) {
			int index = getHashCode(key);
			if (nodes[index] == null)
				return;

			ListNode ln = nodes[index];

			while (ln != null && ln.next != null && ln.next.key != key)
				ln = ln.next;

			if (ln != null) {
				if (ln.next != null) {
					ln.next = ln.next.next;
				} else {
					ln.next = null;
				}
			}
		}
	}

}
