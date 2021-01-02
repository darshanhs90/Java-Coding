package Dec2020Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
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

	public static void preOrder(TreeNode root) {
		if (root == null)
			return;
		preOrder(root.left);
		System.out.print(root.val + "->");
		preOrder(root.right);
	}

	public static class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "";
			List<String> list = new ArrayList<String>();
			serialiseHelper(root, list);
			return String.join(",", list);
		}

		// Encodes a tree to a single string.
		public void serialiseHelper(TreeNode root, List<String> list) {
			if (root == null) {
				list.add("#");
				return;
			}
			list.add(root.val + "");
			serialiseHelper(root.left, list);
			serialiseHelper(root.right, list);
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			String[] splitArr = data.split(",");
			if (splitArr.length == 0 || data.isEmpty())
				return null;
			Queue<String> q = new LinkedList<String>(Arrays.asList(splitArr));
			return deserialiseHelper(q);
		}

		public TreeNode deserialiseHelper(Queue<String> q) {
			String str = q.poll();
			if (str.equals("#"))
				return null;
			TreeNode tn = new TreeNode(Integer.parseInt(str));
			tn.left = deserialiseHelper(q);
			tn.right = deserialiseHelper(q);
			return tn;
		}
	}

}
