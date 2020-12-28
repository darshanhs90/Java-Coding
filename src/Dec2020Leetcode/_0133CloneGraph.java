package Dec2020Leetcode;

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
			return null;
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		HashSet<Node> visited = new HashSet<Node>();
		populateNodes(node, map, visited);
		visited = new HashSet<Node>();
		populateChildrens(node, map, visited);
		return map.get(node);
	}

	public static void populateNodes(Node node, HashMap<Node, Node> map, HashSet<Node> visited) {
		if (visited.contains(node))
			return;
		if (!map.containsKey(node)) {
			Node n = new Node(node.val);
			map.put(node, n);
		}

		visited.add(node);
		for (Node child : node.neighbors) {
			populateNodes(child, map, visited);
		}
	}

	public static void populateChildrens(Node node, HashMap<Node, Node> map, HashSet<Node> visited) {
		if (visited.contains(node))
			return;
		Node newNode = map.get(node);

		visited.add(node);
		for (Node child : node.neighbors) {
			newNode.neighbors.add(map.get(child));
			populateChildrens(child, map, visited);
		}
	}

}
