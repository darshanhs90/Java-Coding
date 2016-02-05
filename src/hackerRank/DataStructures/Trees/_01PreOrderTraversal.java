package hackerRank.DataStructures.Trees;

/*
 * Link:https://www.hackerrank.com/challenges/tree-preorder-traversal
 */

public class _01PreOrderTraversal {

	void Preorder(Node root) {
		if(root!=null)
		{
			System.out.print(root.data+" ");
			Preorder(root.left);
			Preorder(root.right);
		}
	}


	class Node {
		int data;
		Node left;
		Node right;
	}
}
