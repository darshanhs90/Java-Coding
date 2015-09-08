package geeksforgeeks;

import java.util.Stack;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;





/*
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * Inorder Tree Traversal without Recursion
 */;
 public class _01DataStructures_BinaryTree_15 {
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
		 inOrderStack(binaryTree1);
	 }

	 private static void inOrderStack(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 inOrderStack(binaryTree1.rootNode);
	 }

	 private static void inOrderStack(Node node) {
		 Stack<Node> stack=new Stack<Node>();
		 Node current=node;
		 while(true){
			 if(current!=null){
				 stack.push(current);
				 current=current.left;
			 }
			 else if(current==null && !stack.isEmpty()){
				 current=stack.pop();
				 System.out.print(current.data+",");
				 current=current.right;
			 }
			 else {
				 System.exit(1);
				 break;
			 }
		 }
	 }




 }