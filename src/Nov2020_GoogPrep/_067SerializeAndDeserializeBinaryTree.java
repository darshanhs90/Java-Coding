package Nov2020_GoogPrep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _067SerializeAndDeserializeBinaryTree {

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
		System.out.println(ans);
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
			String serializedString = serializeHelper(root);
			return serializedString.substring(0, serializedString.length() - 1);
		}

		// Encodes a tree to a single string.
		public String serializeHelper(TreeNode root) {
			if (root == null) {
				return "#,";
			}
			String leftSerialise = serializeHelper(root.left);
			String rightSerialise = serializeHelper(root.right);
			return root.val + "," + leftSerialise + rightSerialise;
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] parts = data.split(",");
			Queue<String> q = new LinkedList<String>();
			q.addAll(Arrays.asList(parts));
			return helper(q);
		}

		// Decodes your encoded data to tree.
		public TreeNode helper(Queue<String> q) {
			if (q.isEmpty())
				return null;
			if (q.peek().contentEquals("#")) {
				q.poll();
				return null;
			}
			TreeNode tn = new TreeNode(Integer.parseInt(q.poll()));
			tn.left = helper(q);
			tn.right = helper(q);
			return tn;
		}
	}
}
