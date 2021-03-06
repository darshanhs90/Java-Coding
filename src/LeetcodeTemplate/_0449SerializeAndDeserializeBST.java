package LeetcodeTemplate;

import java.util.Arrays;
import java.util.LinkedList;
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
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
		
		}
	}
}
