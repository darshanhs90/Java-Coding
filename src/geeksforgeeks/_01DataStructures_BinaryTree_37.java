package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.Stack;


/*
 * http://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/
 * Boundary Traversal of binary tree
 */;
 public class _01DataStructures_BinaryTree_37 {
	 static Stack<Integer> stack=new Stack<Integer>();
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,20);
		 binaryTree1.insert(20,"left",8);
		 binaryTree1.insert(8,"left",4);
		 binaryTree1.insert(8,"right",12);
		 binaryTree1.insert(12,"left",10);
		 binaryTree1.insert(12,"right",14);
		 binaryTree1.insert(20,"right",22);
		 binaryTree1.insert(22,"right",25);
		 binaryTree1.inOrder();
		 traverseBoundary(binaryTree1);
	 }

	 private static void traverseBoundary(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 traverseBoundary(binaryTree1.rootNode);
	 }

	 private static void traverseBoundary(Node node) {
		 if(node!=null){
			 printBoundaryLeft(node);
			 printLeaves(node.left);
			 printLeaves(node.right);
			 printBoundaryRight(node.right);

		 }
	 }

	 private static void printBoundaryRight(Node node) {
		 if(node!=null){	
			 printBoundaryLeft(node.right);
			 if(node.left!=null || node.right!=null)
				 System.out.print(node.data+",");
		 }

	 }

	 private static void printBoundaryLeft(Node node) {
		 if(node!=null){	
			 if(node.left!=null || node.right!=null)
				 System.out.print(node.data+",");
			 printBoundaryLeft(node.left);
		 }
	 }

	 private static void printLeaves(Node node) {
		 if(node!=null)
		 {
			 if(node.left==null && node.right==null)
				 System.out.print(node.data+",");
			 printLeaves(node.left);
			 printLeaves(node.right);
		 }

	 }



 }
