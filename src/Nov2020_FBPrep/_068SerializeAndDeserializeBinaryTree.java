package Nov2020_FBPrep;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class _068SerializeAndDeserializeBinaryTree {

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
			String out = serializeNode(root);
			if (out.length() > 1)
				out = out.substring(0, out.length() - 1);
			return out;
		}

		// Encodes a tree to a single string.
		public String serializeNode(TreeNode root) {
			if (root == null)
				return "#,";
			String leftString = serializeNode(root.left);
			String rightString = serializeNode(root.right);

			return root.val + "," + leftString + rightString;
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			Queue<String> q = new LinkedList<String>();
			q.addAll(Arrays.asList(data.split(",")));

			return deserialize(q);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(Queue<String> q) {
			if (q.isEmpty() || q.peek().contentEquals("#")) {
				if (!q.isEmpty())
					q.poll();
				return null;
			}
			TreeNode tn = new TreeNode(Integer.parseInt(q.poll()));
			tn.left = deserialize(q);
			tn.right = deserialize(q);
			return tn;
		}
	}

}
