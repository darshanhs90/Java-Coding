package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;




/*
 * http://www.geeksforgeeks.org/write-a-c-program-to-calculate-size-of-a-tree/
 * Write a C program to Calculate Size of a tree
 */;
 public class _01DataStructures_BinaryTree_11 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",8);
		 binaryTree1.insert(10,"right",2);
		 binaryTree1.insert(8,"left",3);
		 binaryTree1.insert(8,"right",5);
		 binaryTree1.insert(2,"left",2);
		 binaryTree1.preOrder();
		 System.out.println(findSize(binaryTree1));
	 }

	 private static int findSize(_01DataStructures_BinaryTree_00 binaryTree1) {
		 return findSize(binaryTree1.rootNode);
	 }

	 private static int findSize(Node node) {
		 if(node!=null){
			 return findSize(node.left)+findSize(node.right)+1;
		 }
		 return 0;
	 }


 }