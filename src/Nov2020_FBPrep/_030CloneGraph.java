package Nov2020_FBPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _030CloneGraph {
	static public class Node {
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
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);

		n1.neighbors.add(n2);
		n1.neighbors.add(n4);

		n2.neighbors.add(n1);
		n2.neighbors.add(n3);

		n3.neighbors.add(n2);
		n3.neighbors.add(n4);

		n4.neighbors.add(n1);
		n4.neighbors.add(n3);
		System.out.println(n1);
		System.out.println(n1.neighbors.get(0));
		System.out.println(n1.neighbors.get(1));
		n1 = cloneGraph(n1);
		System.out.println(n1);
		System.out.println(n1.neighbors.get(0));
		System.out.println(n1.neighbors.get(1));

	}

	public static Node cloneGraph(Node node) {
		if (node == null)
			return node;
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		populateMap(node, map);
		populateChildrens(map);
		return map.get(node);
	}

	public static void populateChildrens(HashMap<Node, Node> map) {
		for (Map.Entry<Node, Node> entry : map.entrySet()) {
			Node originalNode = entry.getKey();
			Node newNode = map.get(originalNode);
			for(Node child: originalNode.neighbors)
			{
				newNode.neighbors.add(map.get(child));
			}
		}
	}

	public static void populateMap(Node node, HashMap<Node, Node> map) {
		if (node == null || map.containsKey(node))
			return;
		Node newNode = new Node(node.val);
		map.put(node, newNode);
		for (Node n : node.neighbors) {
			populateMap(n, map);
		}
	}
}
