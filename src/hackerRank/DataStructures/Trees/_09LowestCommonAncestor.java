package hackerRank.DataStructures.Trees;

/*
 * Link:https://www.hackerrank.com/challenges/tree-level-order-traversal
 */

public class _09LowestCommonAncestor {
	class Node {
		int data;
		Node left;
		Node right;
	}

	static Node lca(Node root,int v1,int v2)
	{
		if(root==null)
			return root;
		if(root.data==v1||root.data==v2)
			return root;
		Node left=lca(root.left,v1,v2);
		Node right=lca(root.right,v1,v2);
		if(left==null && right==null)
			return null;
		else if(left!=null && right!=null)
			return root;
		else 
			return left!=null?left:right;
	}

}
