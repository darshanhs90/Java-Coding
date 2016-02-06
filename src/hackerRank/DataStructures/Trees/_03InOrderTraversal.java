package hackerRank.DataStructures.Trees;

/*
 * Link:https://www.hackerrank.com/challenges/tree-inorder-traversal
 */

public class _03InOrderTraversal {

	void Inorder(Node root) {
		if(root!=null)
		{
			Inorder(root.left);
			System.out.print(root.data+" ");
			Inorder(root.right);
		}
	}


	class Node {
		int data;
		Node left;
		Node right;
	}
}
