package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.Stack;


/*
 * http://www.geeksforgeeks.org/in-place-convert-a-given-binary-tree-to-doubly-linked-list/
 * Convert a given Binary Tree to Doubly Linked List 
 */;
 public class _01DataStructures_BinaryTree_40 {
	 static Stack<Integer> stack=new Stack<Integer>();
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",12);
		 binaryTree1.insert(10,"right",15);
		 binaryTree1.insert(12,"left",25);
		 binaryTree1.insert(12,"right",30);
		 binaryTree1.insert(15,"right",36);

		 binaryTree1.preOrder();
		 Node node=convertToList(binaryTree1);
		 printData(node);
	 }
	 private static void printData(Node node) {
		 while(node!=null){
			 System.out.print(node.data+",");
			 node=node.right;
		 }

	 }
	 private static Node convertToList(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 Node node=  convertToList(binaryTree1.rootNode);
		 while (node.left != null)
			 node = node.left;
		 return (node);
	 }
	 private static Node convertToList(Node node) {
		 if(node==null)
			 return null;
		 if(node.left!=null)
		 {
			 Node left=convertToList(node.left);
			 for (; left.right!=null; left=left.right);
			 left.right =node;
			 node.left=left;
		 }
		 if (node.right!=null)
		 {
			 Node right = convertToList(node.right);
			 for (; right.left!=null; right = right.left);
			 right.left = node;
			 node.right = right;
		 }
		 return node;
	 }

 }
