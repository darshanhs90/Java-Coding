package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;




/*
 * http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 * Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
 * Question: Given an arbitrary binary tree, convert it to a binary tree that holds
 * Children Sum Property. You can only increment data values in any node
 * (You cannot change structure of tree and cannot decrement value of any node).
 */;
 public class _01DataStructures_BinaryTree_12 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,50);
		 binaryTree1.insert(50,"left",7);
		 binaryTree1.insert(50,"right",2);
		 binaryTree1.insert(7,"left",3);
		 binaryTree1.insert(7,"right",5);
		 binaryTree1.insert(2,"left",1);
		 binaryTree1.insert(2,"right",30);
		 binaryTree1.preOrder();
		 convertTree(binaryTree1);
		 binaryTree1.preOrder();
	 }

	 private static void convertTree(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 convertTree(binaryTree1.rootNode);
	 }

	 private static void convertTree(Node node) {

		 int leftData=0,rightData=0,diff;
		 if(node!=null){
			 convertTree(node.left);
			 convertTree(node.right);
			 if(node.left==null)
				 leftData=0;
			 else
				 leftData=node.left.data;
			 if(node.right==null)
				 rightData=0;
			 else
				 rightData=node.right.data;
			 diff=leftData+rightData-node.data;
			 if(diff>0){
				 node.data+=diff;
			 }
			 else if(diff<0){
				 increment(node,-diff);
			 }

		 }

	 }

	private static void increment(Node node, int diff) {
		if(node.left!=null){
			node.left.data+=diff;
			increment(node.left,diff);
		}
		else if(node.right!=null){
			node.right.data+=diff;
			increment(node.right,diff);
		}
		
	}


 }