package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;





/*
 * http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 * How to determine if a binary tree is height-balanced
 */;
 public class _01DataStructures_BinaryTree_14 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,50);
		 binaryTree1.insert(50,"left",7);
		 binaryTree1.insert(50,"right",2);
		 binaryTree1.insert(7,"left",3);
		 binaryTree1.insert(7,"right",5);
		 binaryTree1.insert(2,"left",1);
		 binaryTree1.insert(2,"right",30);
		 binaryTree1.insert(30,"right",32);
		 binaryTree1.insert(32,"right",34);
		 binaryTree1.preOrder();
		 System.out.println(checkBalance(binaryTree1));
	 }

	 private static boolean checkBalance(_01DataStructures_BinaryTree_00 binaryTree1) {
		 return checkBalance(binaryTree1.rootNode);
	 }

	 private static boolean checkBalance(Node node) {
		 if(node==null)
			 return true;
		 else{
			 int leftHeight=height(node.left);
			 int rightHeight=height(node.right);
			 if(Math.abs(leftHeight-rightHeight)<=1 && checkBalance(node.left) && checkBalance(node.right)){
				 return true;
			 }
			 else{
				 return false;
			 }
		 }
	 }

	 private static int height(Node node) {
		 if(node!=null)
		 {
			 int leftHeight=height(node.left);
			 int rightHeight=height(node.right);
			 return 1+((leftHeight>rightHeight)?leftHeight:rightHeight);
		 }
		 else
			 return 0;
	 }


 }