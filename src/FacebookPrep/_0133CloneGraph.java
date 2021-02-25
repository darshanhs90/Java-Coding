package FacebookPrep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
		HashSet<Node> visited = new HashSet<Node>();
		populateNodeMap(node, nodeMap, visited);

		populateChildNodes(node, nodeMap);
		return nodeMap.get(node);
	}

	public static void populateNodeMap(Node node, HashMap<Node, Node> nodeMap, HashSet<Node> visited) {
		if (visited.contains(node))
			return;

		Node newNode = new Node(node.val);
		nodeMap.put(node, newNode);
		visited.add(node);
		for (Node childNode : node.neighbors) {
			populateNodeMap(childNode, nodeMap, visited);
		}
	}

	public static void populateChildNodes(Node node, HashMap<Node, Node> nodeMap) {
		Queue<Node> q = new LinkedList<Node>();
		HashSet<Node> visited = new HashSet<Node>();
		q.offer(node);
		visited.add(node);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node n = q.poll();
				Node newNode = nodeMap.get(n);
				for (int j = 0; j < n.neighbors.size(); j++) {
					Node oldNeighbor = n.neighbors.get(j);
					Node newNeighbor = nodeMap.get(oldNeighbor);
					newNode.neighbors.add(newNeighbor);
					if (!visited.contains(oldNeighbor)) {
						visited.add(oldNeighbor);
						q.offer(oldNeighbor);
					}
				}
			}
		}
	}
}
