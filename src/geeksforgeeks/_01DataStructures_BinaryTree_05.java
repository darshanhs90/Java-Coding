package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

/*
 * http://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 * Write an Efficient C Function to Convert a Binary Tree into its Mirror Tree
 */;
 public class _01DataStructures_BinaryTree_05 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",11);
		 binaryTree1.insert(10,"right",12);
		 binaryTree1.insert(11,"left",13);
		 binaryTree1.insert(11,"right",14);
		 binaryTree1.insert(12,"left",15);
		 binaryTree1.insert(12,"right",16);
		 binaryTree1.preOrder();
		 getMirror(binaryTree1);
		 binaryTree1.preOrder();
	 }

	private static void getMirror(_01DataStructures_BinaryTree_00 binaryTree1) {
		getMirror(binaryTree1.rootNode);
	}

	private static void getMirror(_01DataStructures_BinaryTree_00.Node node) {
		if(node!=null){
			getMirror(node.left);
			getMirror(node.right);
			Node temp=node.left;
			node.left=node.right;
			node.right=temp;
		}
	}
 }
