package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.Stack;


/*
 * http://www.geeksforgeeks.org/morris-traversal-for-preorder/
 * Morris traversal for Preorder
 */;
 public class _01DataStructures_BinaryTree_39 {
	 static Stack<Integer> stack=new Stack<Integer>();
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,20);
		 binaryTree1.insert(20,"left",8);
		 binaryTree1.insert(20,"right",22);
		 binaryTree1.insert(8,"left",4);
		 binaryTree1.insert(8,"right",12);
		 binaryTree1.insert(12,"left",10);
		 binaryTree1.insert(12,"right",14);
		 binaryTree1.insert(22,"right",25);
		 binaryTree1.preOrder();
		 morrisTraversal(binaryTree1);
	 }
	 private static void morrisTraversal(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 morrisTraversal(binaryTree1.rootNode);
	 }
	 private static void morrisTraversal(Node node) {
		 while(node!=null){
			 if(node.left==null){
				 System.out.print(node.data+",");
				 node=(node.right);
			 }
			 else{
				 Node current=node.left;
				 while(current.right!=null && current.right!=node)
				 {
					 current=current.right;
				 }

				 if(current.right==node){
					 current.right=null;
					 node=node.right;
				 }
				 else{
					 System.out.print(node.data+",");
					 current.right=node;
					 node=node.left;
				 }
			 }
		 }
	 }

 }
