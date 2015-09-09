package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 * Maximum width of a binary tree
 */;
 public class _01DataStructures_BinaryTree_21 {
	 static _01DataStructures_BinaryTree_00 tree=new _01DataStructures_BinaryTree_00();

	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(3,"right",8);
		 binaryTree1.insert(8,"left",6);
		 binaryTree1.insert(8,"right",7);
		 binaryTree1.preOrder();
		 System.out.println(getMaxWidthLevelOrder(binaryTree1));
	 }

	 private static int getHeight(Node node) {
		 if(node==null)
			 return 0;
		 else
		 {
			 int leftHeight=getHeight(node.left);
			 int rightHeight=getHeight(node.right);
			 return 1+((leftHeight>rightHeight)?leftHeight:rightHeight);
		 }
	 }

	 private static int getMaxWidthLevelOrder(_01DataStructures_BinaryTree_00 binaryTree1) {
		 return getMaxWidthLevelOrder(binaryTree1.rootNode);
	 }

	 private static int getMaxWidthLevelOrder(Node node) {
		 int maxWidth=0;
		 for (int i = 1; i <= getHeight(node); i++) {
			 int width=getWidth(node,i);
			 if(width>maxWidth)
				 maxWidth=width;
		 }
		 return maxWidth;
	 }

	 private static int getWidth(Node node, int level) {
		 if(node==null)
			 return 0;
		 if(level==1)
			 return 1;
		 else if(level>1)
			 return getWidth(node.left,level-1)+getWidth(node.right,level-1);
		 else
			 return 0;
	 }

 }
