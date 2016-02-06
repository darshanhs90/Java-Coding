package hackerRank.DataStructures.Trees;

/*
 * Link:https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
 */

public class _04HeightOfBinaryTree {

	int height(Node root)
	{
		if(root==null)
			return 0;
		return 1+Math.max(height(root.left), height(root.right));
	}


	class Node {
		int data;
		Node left;
		Node right;
	}
}
