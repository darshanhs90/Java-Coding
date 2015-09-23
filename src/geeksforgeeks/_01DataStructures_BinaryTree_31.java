package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

import java.util.HashMap;





/*
 * http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
 * Vertical Sum in a given Binary Tree
 */;
 public class _01DataStructures_BinaryTree_31 {
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
		 getVerticalSum(binaryTree1);
	 }

	 private static void getVerticalSum(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 getVerticalSum(binaryTree1.rootNode);

	 }

	 private static void getVerticalSum(Node node) {
		 if(node==null)
			 return;
		 else
		 {
			 HashMap<Integer,Integer> hdMap=new HashMap<Integer,Integer>();
			 getVerticalSum(node,0,hdMap);
			 if(hdMap!=null)
			 {
				 System.out.println(hdMap.entrySet());
			 }
		 }

	 }

	 private static void getVerticalSum(Node node, int i,
			 HashMap<Integer, Integer> hdMap) {
		 if(node!=null){
			 getVerticalSum(node.left,i-1,hdMap);
			 if(hdMap.containsKey(i)){
				 hdMap.put(i,hdMap.get(i)+node.data);
			 }else{
				 hdMap.put(i,node.data);
			 }
			 getVerticalSum(node.right,i+1,hdMap);
		 }

	 }


 }
