package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;





/*
 * http://www.geeksforgeeks.org/deepest-left-leaf-node-in-a-binary-tree/
 * Deepest left leaf node in a binary tree
 */;
 public class _01DataStructures_BinaryTree_47 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(3,"left",5);
		 binaryTree1.insert(3,"right",6);
		 binaryTree1.insert(5,"right",7);
		 binaryTree1.insert(6,"right",8);
		 binaryTree1.insert(7,"left",9);
		 binaryTree1.insert(8,"right",10);
		 binaryTree1.preOrder();
		 findDeepestLeftLeaf(binaryTree1);
	 }

	 private static void findDeepestLeftLeaf(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 Node result=null;
		 findDeepestLeftLeaf(binaryTree1.rootNode,0,0,false,result);
		 return ;
	 }

	 private static void findDeepestLeftLeaf(Node node, int level, int maxLevel,
			 boolean isLeft, Node result) {
		 if(node==null)
			 return ;
		 if(isLeft && node.left==null && node.right==null && level>maxLevel)
		 {
			 result=node;
			 maxLevel=level;
			 System.out.println(node.data);
			 return;
		 }
		 findDeepestLeftLeaf(node.left,level+1,maxLevel,true,result);
		 findDeepestLeftLeaf(node.right,level+1,maxLevel,false,result);
	 }
 }
