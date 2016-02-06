package hackerRank.DataStructures.Trees;

/*
 * Link:https://www.hackerrank.com/challenges/tree-postorder-traversal
 */

public class _02PostOrderTraversal {

	void Postorder(Node root) {
		if(root!=null)
		{
			Postorder(root.left);
			Postorder(root.right);
			System.out.print(root.data+" ");
		}
	}


	class Node {
		int data;
		Node left;
		Node right;
	}
}
