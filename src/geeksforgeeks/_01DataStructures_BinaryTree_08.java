package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/level-order-tree-traversal/
 * Level Order Tree Traversal
 */;
 public class _01DataStructures_BinaryTree_08 {
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
		 System.out.println(countLeafNodes(binaryTree1));
	 }

	private static int countLeafNodes(_01DataStructures_BinaryTree_00 binaryTree1) {
		return countLeafNodes(binaryTree1.rootNode);
	}

	private static int countLeafNodes(Node node) {
		if(node!=null){
			if(node.left==null && node.right==null){
				return 1;
			}
			else
				return countLeafNodes(node.left)+countLeafNodes(node.right);
		}
		return 0;
	}


 }
