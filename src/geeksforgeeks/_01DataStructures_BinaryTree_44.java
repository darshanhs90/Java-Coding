package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.Stack;


/*
 * http://www.geeksforgeeks.org/print-ancestors-of-a-given-binary-tree-node-without-recursion/
 * Print ancestors of a given binary tree node without recursion
 */;
 public class _01DataStructures_BinaryTree_44 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(5,"left",7);
		 binaryTree1.insert(5,"right",8);
		 binaryTree1.insert(3,"left",6);
		 binaryTree1.preOrder();
		 printAncestors(binaryTree1,8);

	 }

	 private static void printAncestors(
			 _01DataStructures_BinaryTree_00 binaryTree1, int i) {
		 printAncestors(binaryTree1.rootNode,8);
	 }

	 private static void printAncestors(Node node, int i) {
		 if(node==null)
			 return;
		 Stack<Node> stack=new Stack<Node>();
		 while(true)
		 {
			 while(node!=null && node.data!=i)
			 {
				 stack.push(node);
				 node=node.left;
			 }
			 if(node!=null && node.data==i)
				 break;
			 if(stack.peek().right==null)
			 {
				 node=stack.pop();
				 while(!stack.isEmpty() && stack.peek().right==node)
				 {
					 node=stack.pop();
				 }
			 }
			 node=stack.isEmpty()?null:stack.peek().right;
		 }
		 while(!stack.isEmpty()){
			 System.out.print(stack.pop().data+",");
		 }
	 }

 }
