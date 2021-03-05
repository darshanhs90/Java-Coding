package FacebookPortalPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class _0014Trees_NodesInASubtree {

	public static void main(String[] args) {
	}

	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
			val = 0;
			children = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			children = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	static class Query {
		int u;
		char c;

		Query(int u, char c) {
			this.u = u;
			this.c = c;
		}
	}

	// Add any helper functions you may need here

	public static int[] countOfNodes(Node root, ArrayList<Query> queries, String s) {
		// Write your code here
		int[] output = new int[queries.size()];

		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		populateMap(root, map);

		for (int i = 0; i < queries.size(); i++) {
			Query q = queries.get(i);
			if (!map.containsKey(q.u)) {
				output[i] = 0;
				continue;
			}
			Node n = map.get(q.u);
			output[i] = findChildNodes(n, q.c, s);
		}

		return output;
	}

	public static int findChildNodes(Node root, char c, String str) {
		if (root == null)
			return 0;
		int count = 0;
		if (str.charAt(root.val - 1) == c) {
			count++;
		}

		if (root.children != null && root.children.size() > 0) {
			for (Node child : root.children) {
				count += findChildNodes(child, c, str);
			}
		}
		return count;
	}

	public static void populateMap(Node root, HashMap<Integer, Node> map) {
		if (root == null)
			return;
		map.put(root.val, root);
		List<Node> childrens = root.children;
		if (childrens != null && childrens.size() > 0) {
			for (Node child : childrens) {
				populateMap(child, map);
			}
		}
	}
}
