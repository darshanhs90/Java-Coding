package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
 * Print Ancestors of a given node in Binary Tree
 */;
 public class _01DataStructures_BinaryTree_25 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(4,"left",7);
		 binaryTree1.preOrder();
		 getAncestors(binaryTree1,7);
	 }

	private static void getAncestors(
			_01DataStructures_BinaryTree_00 binaryTree1, int data) {
		getAncestors(binaryTree1.rootNode,data);
	}

	private static boolean getAncestors(Node node, int data) {
		if(node==null)
			return false;
		if(node.data==data)
			return true;
		if(getAncestors(node.left,data)||getAncestors(node.right,data))
		{
			System.out.print(node.data+",");
			return true;
		}
		return false;
	}

	
 }
