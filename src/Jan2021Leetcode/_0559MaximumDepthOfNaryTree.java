package Jan2021Leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0559MaximumDepthOfNaryTree {
	static class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	};

	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		n1.children = new ArrayList<Node>();
		n1.children.add(n2);
		n1.children.add(n3);
		n1.children.add(n4);
		n3.children = new ArrayList<Node>();
		n3.children.add(n5);
		n3.children.add(n6);
		System.out.println(maxDepth(n1));
	}

	public static int maxDepth(Node root) {
	}
}
