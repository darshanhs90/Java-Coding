package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * Lowest Common Ancestor in a Binary Tree
 */;
 public class _01DataStructures_BinaryTree_53 {
	 static int path[];
	 static ArrayList<int []> arrayList=new ArrayList<int []>();
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(3,"left",6);
		 binaryTree1.insert(3,"right",7);
		 binaryTree1.preOrder();
		 System.out.println(findLCALong(binaryTree1,3,4));
		 System.out.println(findLCAShort(binaryTree1,3,4));

	 }
	 private static int findLCAShort(
			 _01DataStructures_BinaryTree_00 binaryTree1, int i, int j) {
		 return findLCAShort(binaryTree1.rootNode,i,j).data;
	 }
	 private static Node findLCAShort(Node node, int i, int j) {
		 if(node==null)
			 return null;
		 if(node.data==i||node.data==j)
			 return node;
		 Node left=findLCAShort(node.left,i,j);
		 Node right=findLCAShort(node.right,i,j);
		 if(left!=null && right!=null)
			 return node;
		 return left!=null?left:right;
	 }
	 private static int findLCALong(
			 _01DataStructures_BinaryTree_00 binaryTree1, int i, int j) {
		 path=new int[getHeight(binaryTree1.rootNode)];
		 findLCALong(binaryTree1.rootNode,path,3,4,0);
		 int size=(arrayList.get(0).length>arrayList.get(1).length)?arrayList.get(1).length:arrayList.get(0).length;
		 int firstArray[]=arrayList.get(0);
		 int secondArray[]=arrayList.get(1);
		 if(size==1)
			 return firstArray[0];
		 for (int k = 0; k < size; k++) {
			 if(firstArray[k]!=secondArray[k])
				 return firstArray[(k-1)];
		 }
		 return 0;
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
	 private static void findLCALong(Node node,int[] path, int i, int j,int pathLen) {
		 if(node!=null)
		 {
			 if(node.data==i||node.data==j)
			 {
				 arrayList.add(Arrays.copyOfRange(path,0,pathLen));
			 }
			 path[pathLen]=node.data;
			 pathLen++;

			 findLCALong(node.left,path,i,j,pathLen);
			 findLCALong(node.right,path,i,j,pathLen);
		 }
	 }
 }
