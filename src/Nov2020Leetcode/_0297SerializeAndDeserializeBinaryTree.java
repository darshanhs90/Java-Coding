package Nov2020Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _0297SerializeAndDeserializeBinaryTree {
	static public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);

		Codec ser = new Codec();
		Codec deser = new Codec();
		System.out.println(ser.serialize(root));
		preOrder(root);
		System.out.println();
		TreeNode ans = deser.deserialize(ser.serialize(root));
		preOrder(ans);
		System.out.println();
	}

	public static void preOrder(TreeNode tn) {
		if (tn == null)
			return;
		preOrder(tn.left);
		preOrder(tn.right);
		System.out.print(tn.val + "->");
	}

	static public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "X,";
			String leftTree = serialize(root.left);
			String rightTree = serialize(root.right);
			return root.val + "," + leftTree + rightTree;

		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			Queue<String> nodes = new LinkedList<String>();
			nodes.addAll(Arrays.asList(data.split(",")));
			return deserializeHelper(nodes);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserializeHelper(Queue<String> nodes) {
			String data = nodes.poll();
			if (data.contentEquals("X"))
				return null;

			TreeNode tn = new TreeNode(Integer.parseInt(data));
			tn.left = deserializeHelper(nodes);
			tn.right = deserializeHelper(nodes);
			return tn;

		}
	}

}
