package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/print-binary-tree-vertical-order/
 * Print a Binary Tree in Vertical Order
 */;
 public class _01DataStructures_BinaryTree_58 {	 
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(3,"left",6);
		 binaryTree1.insert(3,"right",7);
		 binaryTree1.insert(6,"right",8);
		 binaryTree1.insert(7,"right",9);	 
		 binaryTree1.preOrder();
		 printVerticalOrder(binaryTree1);
	 }

	private static void printVerticalOrder(
			_01DataStructures_BinaryTree_00 binaryTree1) {
		 printVerticalOrder(binaryTree1.rootNode);
	}

	private static void printVerticalOrder(Node rootNode) {
		// TODO Auto-generated method stub
		
	}
 }
