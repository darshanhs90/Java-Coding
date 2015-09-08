package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;



/*
 * http://www.geeksforgeeks.org/check-for-children-sum-property-in-a-binary-tree/
 * Check for Children Sum Property in a Binary Tree.
 */;
 public class _01DataStructures_BinaryTree_10 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",8);
		 binaryTree1.insert(10,"right",2);
		 binaryTree1.insert(8,"left",3);
		 binaryTree1.insert(8,"right",5);
		 binaryTree1.insert(2,"left",2);
		 binaryTree1.preOrder();
		 System.out.println(checkSumProperty(binaryTree1));
	 }

	 private static boolean checkSumProperty(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 return checkSumProperty(binaryTree1.rootNode);
	 }

	 private static boolean checkSumProperty(Node node) {
		 int leftData=0,rightData=0;
		 if(node==null || (node.right==null && node.left==null)){
			 return true;
		 }
		 else{
			 if(node.left!=null)
				 leftData=node.left.data;
			 if(node.right!=null)
				 rightData=node.right.data;
			 if(node.data==(leftData+rightData) && checkSumProperty(node.left) && checkSumProperty(node.right)){
				 return true;
			 }
			 else
				 return false;
		 }
	 }
 }