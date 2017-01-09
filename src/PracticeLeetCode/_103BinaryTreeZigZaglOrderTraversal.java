package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

import PracticeLeetCode._102BinaryTreeLevelOrderTraversal.TreeNode;

public class _103BinaryTreeZigZaglOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.right.right=new TreeNode(3);
		tn.right.left=new TreeNode(4);
		tn.left.right=new TreeNode(4);
		System.out.println(zigzagLevelOrder(tn));
		tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(2);
		tn.right.right=new TreeNode(3);
		tn.left.right=new TreeNode(3);
		System.out.println(zigzagLevelOrder(tn));
	}
	a
}
