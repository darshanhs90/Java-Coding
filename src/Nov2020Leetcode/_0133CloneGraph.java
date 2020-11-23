package Nov2020Leetcode;

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
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		populateMap(map, node);
		HashSet<Node> visited = new HashSet<Node>();
		populateChildrens(map, node, visited);
		return map.get(node);
	}

	public static void populateMap(HashMap<Node, Node> map, Node node) {
		if (node != null && !map.containsKey(node)) {
			Node newNode = new Node(node.val);
			map.put(node, newNode);
			for (Node childNode : node.neighbors) {
				populateMap(map, childNode);
			}
		}
	}

	public static void populateChildrens(HashMap<Node, Node> map, Node node, HashSet<Node> visited) {
		if (node != null && !visited.contains(node)) {
			visited.add(node);
			Node mainNode = map.get(node);

			for (Node childNode : node.neighbors) {
				mainNode.neighbors.add(map.get(childNode));
				populateChildrens(map, childNode, visited);
			}
		}
	}

}
