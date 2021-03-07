package Feb2021Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

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
		populateNeighbors(node, nodeMap, new HashSet<Node>());
		return nodeMap.get(node);
	}

	public static void populateNeighbors(Node node, HashMap<Node, Node> nodeMap, HashSet<Node> visited) {
		if (visited.contains(node))
			return;

		visited.add(node);
		Node newNode = nodeMap.get(node);
		List<Node> neighbors = node.neighbors;
		if (neighbors != null) {
			for (Node child : neighbors) {
				newNode.neighbors.add(nodeMap.get(child));
				populateNodeMap(child, nodeMap);
			}
		}
	}

	public static void populateNodeMap(Node node, HashMap<Node, Node> nodeMap) {
		if (nodeMap.containsKey(node))
			return;

		Node newNode = new Node(node.val);
		nodeMap.put(node, newNode);

		List<Node> neighbors = node.neighbors;
		if (neighbors != null) {
			for (Node child : neighbors) {
				populateNodeMap(child, nodeMap);
			}
		}
	}
}
