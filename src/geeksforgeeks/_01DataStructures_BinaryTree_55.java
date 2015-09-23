package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 * Print all nodes that are at distance k from a leaf node
 */;
 public class _01DataStructures_BinaryTree_55 {
	 static int path[];
	 static boolean[] visited;
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(3,"left",6);
		 binaryTree1.insert(3,"right",7);
		 binaryTree1.insert(6,"right",8);
		 binaryTree1.preOrder();
		 printDistanceNodes(binaryTree1,1);

	 }
	 private static void printDistanceNodes(
			 _01DataStructures_BinaryTree_00 binaryTree1, int k) {
		 int height=getHeight(binaryTree1.rootNode);
		 path=new int[height];
		 visited=new boolean[height];
		 Arrays.fill(visited,true);
		 printDistanceNodes(binaryTree1.rootNode,path,visited,0,k);
	 }


	 private static void printDistanceNodes(Node node, int[] path,boolean[] visited,int pathLen, int k) {
		 if(node==null)
			 return;
		 else
		 {

			 path[pathLen]=node.data;
			 visited[pathLen]=false;
			 pathLen++;
			 if(node.left==null && node.right==null && pathLen-k-1>=0 && visited[pathLen-k-1]==false)
			 {
				 System.out.println(path[pathLen-k-1]);
				 visited[pathLen-k-1]=true;
				 return;
			 }
			 printDistanceNodes(node.left,path,visited,pathLen,k);
			 printDistanceNodes(node.right,path,visited,pathLen,k);
		 }

	 }
	 private static int getHeight(Node node) {
		 if(node!=null)
		 {
			 int leftHeight=getHeight(node.left);
			 int rightHeight=getHeight(node.right);
			 return 1+((leftHeight>rightHeight)?leftHeight:rightHeight);
		 }
		 return 0;
	 }

 }
