package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/get-level-of-a-node-in-a-binary-tree/
 * Get Level of a node in a Binary Tree
 */;
 public class _01DataStructures_BinaryTree_24 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(3,"left",8);
		 binaryTree1.preOrder();
		 System.out.println(getLevel(binaryTree1,8));
	 }

	 private static int getLevel(_01DataStructures_BinaryTree_00 binaryTree1,
			 int data) {
		 return getLevel(binaryTree1.rootNode,data,1);
	 }

	 private static int getLevel(Node node, int data,int level) {
		 if(node==null)
			 return 0;
		 if(node.data==data)
			 return level;
		 else
		 {

			 int downLevel= getLevel(node.left,data,level+1);
			 if(downLevel!=0)
				 return downLevel;
			 return getLevel(node.right,data,level+1);
		 }
	 }
 }
