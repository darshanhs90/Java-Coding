package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/foldable-binary-trees/
 * Foldable Binary Trees
 */;
 public class _01DataStructures_BinaryTree_22 {
	 static _01DataStructures_BinaryTree_00 tree=new _01DataStructures_BinaryTree_00();

	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",7);
		 binaryTree1.insert(7,"right",9);
		 binaryTree1.insert(10,"right",15);
		 binaryTree1.insert(15,"left",11);
		 binaryTree1.preOrder();
		 System.out.println(checkTreeFold(binaryTree1));
	 }

	 private static boolean checkTreeFold(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 return checkTreeFold(binaryTree1.rootNode);
	 }

	 private static boolean checkTreeFold(Node node) {
		 if(node==null)
			 return true;
		 mirror(node.left);
		 boolean result=isStructureSame(node.left,node.right);
		 mirror(node.left);
		 return result;
	 }

	 private static boolean isStructureSame(Node left, Node right) {
		 if(left==null && right==null)
			 return true;
		 else if(left!=null && right!=null 
				 && isStructureSame(left.left,right.left)
				 && isStructureSame(left.right,right.right))
			 return true;
		 else		 
			 return false;
	 }

	 private static void mirror(Node node) {
		 if(node!=null){
			 mirror(node.left);
			 mirror(node.right);
			 Node temp=node.left;
			 node.left=node.right;
			 node.right=temp;
		 }
	 }


 }
