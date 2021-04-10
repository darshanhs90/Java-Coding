package April2021Leetcode;

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

	public static class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "";
			List<String> list = new ArrayList<String>();
			serializeHelper(root, list);
			return String.join(",", list);
		}

		public void serializeHelper(TreeNode root, List<String> list) {
			if (root == null) {
				list.add("#");
				return;
			}
			list.add(root.val + "");
			serializeHelper(root.left, list);
			serializeHelper(root.right, list);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.isEmpty())
				return null;
			Queue<String> q = new LinkedList<String>(Arrays.asList(data.split(",")));
			return deserializeHelper(q);
		}

		public TreeNode deserializeHelper(Queue<String> q) {
			if (q.isEmpty()) {
				return null;
			}

			if (q.peek().equals("#")) {
				q.poll();
				return null;
			}

			TreeNode tn = new TreeNode(Integer.parseInt(q.poll()));
			tn.left = deserializeHelper(q);
			tn.right = deserializeHelper(q);
			return tn;
		}
	}
}
