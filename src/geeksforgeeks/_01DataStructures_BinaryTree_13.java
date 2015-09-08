package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;





/*
 * http://www.geeksforgeeks.org/diameter-of-a-binary-tree/
 * Diameter of a Binary Tree
 */;
 public class _01DataStructures_BinaryTree_13 {
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
		 binaryTree1.preOrder();
		 System.out.println(getDiameter(binaryTree1));
	 }

	 private static int getDiameter(_01DataStructures_BinaryTree_00 binaryTree1) {
		 return getDiameter(binaryTree1.rootNode);
	 }

	 private static int getDiameter(Node node) {
		 if(node==null)
			 return 0;
		 else{
			 int leftHeight=height(node.left);
			 int rightHeight=height(node.right);
			 int leftDiameter=getDiameter(node.left);
			 int rightDiameter=getDiameter(node.right);
			 if((leftHeight+rightHeight+1)>((leftDiameter>rightDiameter)?leftDiameter:rightDiameter))
				 return (leftHeight+rightHeight+1);
			 else
				 return ((leftDiameter>rightDiameter)?leftDiameter:rightDiameter);
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