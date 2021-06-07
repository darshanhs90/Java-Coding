package June2021GoogLeetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class _0449SerializeAndDeserializeBST {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(2);
		tn.left = new TreeNode(1);
		tn.right = new TreeNode(3);
		Codec c = new Codec();
		printNodes(tn);
		System.out.println();
		printNodes(c.deserialize(c.serialize(tn)));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void printNodes(TreeNode tn) {
		if (tn != null) {
			printNodes(tn.left);
			System.out.print(tn.val + "/");
			printNodes(tn.right);
		}
	}

	static public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "";
			List<String> out = new ArrayList<String>();
			serHelper(root, out);
			return String.join(",", out);
		}

		public void serHelper(TreeNode root, List<String> out) {
			if (root == null) {
				out.add("#");
				return;
			}
			out.add(root.val + "");
			serHelper(root.left, out);
			serHelper(root.right, out);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.isEmpty())
				return null;
			return deserHelper(new LinkedList<String>(Arrays.asList(data.split(","))));
		}

		public TreeNode deserHelper(Queue<String> q) {
			if (q.isEmpty())
				return null;
			if (q.peek().equals("#")) {
				q.poll();
				return null;
			}
			TreeNode tn = new TreeNode(Integer.parseInt(q.poll()));
			tn.left = deserHelper(q);
			tn.right = deserHelper(q);
			return tn;
		}
	}
}
