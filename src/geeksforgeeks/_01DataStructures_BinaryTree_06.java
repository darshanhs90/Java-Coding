package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/given-a-binary-tree-print-out-all-of-its-root-to-leaf-paths-one-per-line/
 * Given a binary tree, print out all of its root-to-leaf paths one per line.
 */;
 public class _01DataStructures_BinaryTree_06 {
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
		 printPaths(binaryTree1);
	 }
	 static int[] pathArray=new int[3];//set max height here
	 private static void printPaths(_01DataStructures_BinaryTree_00 binaryTree1) {
		 printPaths(binaryTree1.rootNode,pathArray,0);
	 }

	 private static void printPaths(Node node,int[] list,int pathLen) {
		 if(node!=null)
		 {
			list[pathLen]=node.data;
			pathLen++;
		 }
		 if(node.left==null && node.right==null){
			 for (int i = 0; i < list.length; i++) {
				 System.out.print(list[i]+",");
			 }
			 System.out.println();
		 }else{
			 printPaths(node.left,list,pathLen);
			 printPaths(node.right,list,pathLen);

		 }
	 }


 }
