package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * http://www.geeksforgeeks.org/check-given-binary-tree-follows-height-property-red-black-tree/
 * Check if a given Binary Tree is height balanced like a Red-Black Tree
 */;
 public class _01DataStructures_BinaryTree_56 {
	 static int path[];
	 static ArrayList<Integer> heightList=new ArrayList<Integer>();
	 static boolean[] visited;
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,40);
		 binaryTree1.insert(40,"left",10);
		 binaryTree1.insert(40,"right",100);
		 binaryTree1.insert(100,"left",60);
		 binaryTree1.insert(100,"right",150);
		 binaryTree1.insert(60,"left",120);
		 
		 binaryTree1.preOrder();
		 System.out.println(checkBalance(binaryTree1));

	 }
	 private static boolean checkBalance(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 int height=getHeight(binaryTree1.rootNode);
		 path=new int[height];
		 checkBalance(binaryTree1.rootNode,path,0);
		 Object[] heightArray=(heightList.toArray());
		 Arrays.sort(heightArray);
		 System.out.println(Arrays.toString(heightArray));
		 if(heightArray.length==1)
			 if((int)heightArray[0]>1)
				 return false;
			 else
				 return true;
		 if(((int)heightArray[0]-(int)heightArray[1])>1)
			 return false;
		 return true;
	 }


	 private static void checkBalance(Node node, int[] path,int pathLen) {
		 if(node==null)
			 return;
		 else
		 {

			 path[pathLen]=node.data;
			 pathLen++;
			 if(node.left==null && node.right==null )
			 {
				 heightList.add(pathLen);
			 }
			 checkBalance(node.left,path,pathLen);
			 checkBalance(node.right,path,pathLen);
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
