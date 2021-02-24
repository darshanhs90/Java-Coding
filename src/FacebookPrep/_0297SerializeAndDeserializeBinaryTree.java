package FacebookPrep;

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
			
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			
		}
	}

}
