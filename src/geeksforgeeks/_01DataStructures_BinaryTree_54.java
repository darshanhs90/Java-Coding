package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/find-distance-two-given-nodes/
 * Find distance between two given keys of a Binary Tree
 */;
 public class _01DataStructures_BinaryTree_54 {
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
		 binaryTree1.insert(6,"right",8);
		 binaryTree1.preOrder();
		 System.out.println(findDistance(binaryTree1,4,6));

	 }
	 private static int findDistance(
			 _01DataStructures_BinaryTree_00 binaryTree1, int i, int j) {
		 path=new int[getHeight(binaryTree1.rootNode)];
		 findDistance(binaryTree1.rootNode,path,0,i,j);
		 System.out.println(Arrays.toString(arrayList.get(0)));
		 System.out.println(Arrays.toString(arrayList.get(1)));
		 return getDistance(arrayList.get(0),arrayList.get(1),i,j);
	 }

	 private static int getDistance(int[] firstPath, int[] secondPath, int firstElement, int secondElement) {
		 int size=(firstPath.length>secondPath.length)?secondPath.length:firstPath.length;
		 int ancestorDistance=0;
		 for (int i = 0; i < size; i++) {
			 if(firstPath[i]!=secondPath[i]){
				 ancestorDistance=i-1;
				 break;
			 }
		 }
		 if(ancestorDistance<0)
			 ancestorDistance=0;
		 int firstDistance=0,secondDistance=0;
		 for (int i = 0; i < firstPath.length; i++) {
			 if(firstPath[i]==firstElement)
				 firstDistance=i;
		 }
		 for (int i = 0; i < secondPath.length; i++) {
			 if(secondPath[i]==secondElement)
				 secondDistance=i;
		 }
		 return firstDistance+secondDistance-(2*ancestorDistance);
	 }
	 private static void findDistance(Node node, int[] path, int pathLen, int data1,
			 int data2) {
		 if(node==null)
			 return;
		 else
		 {
			 path[pathLen]=node.data;
			 pathLen++;
			 if(node.data==data1||node.data==data2)
			 {
				 arrayList.add(Arrays.copyOfRange(path,0,pathLen));
			 }
			 findDistance(node.left,path,pathLen,data1,data2);
			 findDistance(node.right,path,pathLen,data1,data2);
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
