package April2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0133CloneGraph {
	// Definition for a Node.
	static class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		node1.neighbors = new ArrayList<Node>(Arrays.asList(node2, node4));
		node2.neighbors = new ArrayList<Node>(Arrays.asList(node1, node3));
		node3.neighbors = new ArrayList<Node>(Arrays.asList(node2, node4));
		node4.neighbors = new ArrayList<Node>(Arrays.asList(node1, node3));
		Node node = cloneGraph(node1);
		System.out.println(node1);
		System.out.println(node);
	}

	public static Node cloneGraph(Node node) {
		if (node == null)
			return node;

		HashMap<Node, Node> nodeMap = new HashMap<Node, Node>();
		populateNodeMap(node, nodeMap);
		populateChildrens(nodeMap);
		return nodeMap.get(node);
	}

	public static void populateNodeMap(Node node, HashMap<Node, Node> nodeMap) {
		if (node == null || nodeMap.containsKey(node))
			return;

		Node newNode = new Node(node.val);
		nodeMap.put(node, newNode);
		for (Node child : node.neighbors) {
			populateNodeMap(child, nodeMap);
		}
	}

	public static void populateChildrens(HashMap<Node, Node> nodeMap) {
		for (Map.Entry<Node, Node> entry : nodeMap.entrySet()) {
			Node oldNode = entry.getKey();
			Node newNode = entry.getValue();
			for (Node child : oldNode.neighbors) {
				newNode.neighbors.add(nodeMap.get(child));
			}
		}
	}

}
