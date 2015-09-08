package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;



/*
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 * Write C Code to Determine if Two Trees are Identical
 */;
 public class _01DataStructures_BinaryTree_02 {
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
		 _01DataStructures_BinaryTree_00 binaryTree2=new _01DataStructures_BinaryTree_00();
		 binaryTree2.insert(null,null,10);
		 binaryTree2.insert(10,"left",11);
		 binaryTree2.insert(10,"right",12);
		 binaryTree2.insert(11,"left",13);
		 binaryTree2.insert(11,"right",14);
		 binaryTree2.insert(12,"left",15);
		 binaryTree2.insert(12,"right",18);
		 binaryTree1.preOrder();
		 System.out.println(checkTree(binaryTree1,binaryTree2));
	 }

	 private static boolean checkTree(_01DataStructures_BinaryTree_00 binaryTree1,
			 _01DataStructures_BinaryTree_00 binaryTree2) {
		 if(binaryTree1.size()==0 || binaryTree2.size()==0||binaryTree1.size()!=binaryTree2.size())
			 return false;
		 else
			 return checkTree(binaryTree1.rootNode,binaryTree2.rootNode);
	 }

	 private static boolean checkTree(Node node1, Node node2) {
		 if(node1!=null && node2!=null){
			 boolean b1=(node1.data==node2.data);
			 boolean b2=checkTree(node1.left,node2.left);
			 boolean b3=checkTree(node1.right,node2.right);
			 return (b1&&b2&&b3);
		 }
		 else if(node1!=null && node2==null || node1==null && node2!=null){
			 return false;
		 }
		 else
			 return true;
	 }
 }