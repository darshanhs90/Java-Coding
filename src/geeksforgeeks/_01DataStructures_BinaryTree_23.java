package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
 * Print nodes at k distance from root
 */;
 public class _01DataStructures_BinaryTree_23 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(3,"left",8);
		 binaryTree1.preOrder();
		 printNodesAtDistance(binaryTree1,2);
	 }

	 private static void printNodesAtDistance(
			 _01DataStructures_BinaryTree_00 binaryTree1, int k) {
		 printNodesAtDistance(binaryTree1.rootNode,k);
	 }

	 private static void printNodesAtDistance(Node node, int k) {
		 if(node==null)
			 return;
		 if(k==0)
			 System.out.print(node.data+",");
		 else{
			 printNodesAtDistance(node.left,k-1);
			 printNodesAtDistance(node.right,k-1);
		 }
	 }
 }
