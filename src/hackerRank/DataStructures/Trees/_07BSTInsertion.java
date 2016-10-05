package hackerRank.DataStructures.Trees;

/*
 * Link:https://www.hackerrank.com/challenges/tree-level-order-traversal
 */

public class _07BSTInsertion {
	static class Node {
		int data;
		Node left;
		Node right;
	}
	static Node Insert(Node root,int value)
	{   
		if(root==null){
			Node n=new Node();
			n.data=value;
			return n;
		}
		if(root.data>value)
		{
			root.left=Insert(root.left,value);
		}
		else{
			root.right=Insert(root.right,value);
		}
		return root;
	}

}
