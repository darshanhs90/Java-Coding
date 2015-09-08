package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;





/*
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and-without-stack/
 * Inorder Tree Traversal without recursion and without stack
 */;
 public class _01DataStructures_BinaryTree_16 {
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
		 binaryTree1.inOrder();
		 inOrderWithoutStack(binaryTree1);
	 }

	 private static void inOrderWithoutStack(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 inOrderWithoutStack(binaryTree1.rootNode);
	 }

	 private static void inOrderWithoutStack(Node node) {
		 Node current=node;
		 Node pre;
		 while(current!=null)
		 {
			 if(current.left==null){
				 System.out.print(current.data+",");
				 current=current.right;
			 }
			 else{
				 pre=current.left;
				 while(pre.right!=null && pre.right!=current)
					 pre=pre.right;
				 if(pre.right==null){
					 pre.right=current;
					 current=current.left;
				 }
				 else{
					 pre.right=null;
					 System.out.print(current.data+",");
					 current=current.right;
				 }
			 }
		 }
	 }

 }
