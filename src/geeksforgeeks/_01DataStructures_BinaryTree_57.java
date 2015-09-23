package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * Print all nodes at distance k from a given node
 */;
 public class _01DataStructures_BinaryTree_57 {
	 static int path[];
	 static ArrayList<int[]> mainPathList=new ArrayList<int[]>();
	 static ArrayList<int[]> pathListDown=new ArrayList<int[]>();
	 
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,20);
		 binaryTree1.insert(20,"left",8);
		 binaryTree1.insert(20,"right",22);
		 binaryTree1.insert(8,"left",4);
		 binaryTree1.insert(8,"right",12);
		 binaryTree1.insert(12,"left",10);
		 binaryTree1.insert(12,"right",14);
		 binaryTree1.preOrder();
		 printNodes(binaryTree1,8,2);

	 }
	 private static void printNodes(_01DataStructures_BinaryTree_00 binaryTree1,
			 int nodeData, int distance) {
		 Node n=getNode(binaryTree1.rootNode,nodeData);//usage ?
		 printNodes(binaryTree1.rootNode,8,2);
		 System.out.println("**********");
		 printNodesDown(n,8,2);
		 for (int i = 0; i < pathListDown.size(); i++) {
			 System.out.println(Arrays.toString(pathListDown.get(i)));
		 }
	 }
	 private static void printNodesDown(Node n, int i, int j) {
		 path=new int[getHeight(n)];
		 getRootLeafPathDown(n,path,0);
	 }
	 private static void getRootLeafPathDown(Node node, int[] path, int pathLen) {
		 if(node!=null){
			 path[pathLen]=node.data;
			 pathLen++;
			 if(node.left==null && node.right==null){
				 pathListDown.add(Arrays.copyOfRange(path, 0, pathLen));
			 }
			 getRootLeafPathDown(node.left, path, pathLen);
			 getRootLeafPathDown(node.right, path, pathLen);
		 }

	 }
	 private static void printNodes(Node node, int nodeData, int distance) {
		 //get root to leaf paths for all nodes
		 path=new int[getHeight(node)];
		 getRootLeafPath(node,path,0);
		 for (int i = 0; i < mainPathList.size(); i++) {
			 System.out.println(Arrays.toString(mainPathList.get(i)));
		 }
	 }
	 private static void getRootLeafPath(Node node, int[] path, int pathLen) {
		 if(node!=null){
			 path[pathLen]=node.data;
			 pathLen++;
			 if(node.left==null && node.right==null){
				 mainPathList.add(Arrays.copyOfRange(path, 0, pathLen));
			 }
			 getRootLeafPath(node.left, path, pathLen);
			 getRootLeafPath(node.right, path, pathLen);
		 }
	 }
	 private static int getHeight(Node node) {
		 if(node!=null){
			 int leftHeight=getHeight(node.left);
			 int rightHeight=getHeight(node.right);
			 return 1+((leftHeight>rightHeight)?leftHeight:rightHeight);
		 }
		 return 0;
	 }
	 private static Node getNode(Node node,int nodeData) {
		 if(node!=null)
		 {
			 if(node.data==nodeData)
				 return node;
			 else{
				 Node n=getNode(node.left,nodeData);
				 if(n!=null)
					 return n;
				 else
					 return getNode(node.right,nodeData);
			 }
		 }
		 return null;
	 }

 }
