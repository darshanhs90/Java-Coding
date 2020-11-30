package Nov2020_GoogPrep;

import java.util.HashMap;
import java.util.Map;

public class _032CopyListWithRandomPointer {
	static public class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public static void main(String[] args) {
		Node node1 = new Node(7);
		Node node2 = new Node(13);
		Node node3 = new Node(11);
		Node node4 = new Node(10);
		Node node5 = new Node(1);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = null;
		node1.random = null;
		node2.random = node1;
		node3.random = node5;
		node4.random = node3;
		node5.random = node1;

		printNodes(node1);
		node1 = copyRandomList(node1);
		printNodes(node1);
	}

	public static void printNodes(Node ln) {
		while (ln != null) {
			System.out.println(ln + "<->" + ln.next + "<->" + ln.random);
			ln = ln.next;
		}
		System.out.println("************************");
	}

	public static Node copyRandomList(Node head) {
		HashMap<Node, Node> nodeMap = new HashMap<Node, Node>();
		nodeMap.put(null, null);
		populateNodeMap(head, nodeMap);
		populateNextNodesAndChildrens(nodeMap);
		return nodeMap.get(head);
	}

	public static void populateNodeMap(Node head, HashMap<Node, Node> nodeMap) {
		if (head != null) {
			Node newNode = new Node(head.val);
			nodeMap.put(head, newNode);
			populateNodeMap(head.next, nodeMap);
		}
	}

	public static void populateNextNodesAndChildrens(HashMap<Node, Node> nodeMap) {
		for (Map.Entry<Node, Node> entry : nodeMap.entrySet()) {
			if (entry.getKey() != null) {
				Node oldNode = entry.getKey();
				Node newNode = entry.getValue();
				newNode.next = nodeMap.get(oldNode.next);
				newNode.random = nodeMap.get(oldNode.random);
			}
		}
	}
}
