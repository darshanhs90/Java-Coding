package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;




/*
 * http://www.geeksforgeeks.org/convert-a-given-tree-to-sum-tree/
 * Convert a given tree to its Sum Tree
 */;
 public class _01DataStructures_BinaryTree_30 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(3,"right",6);
		 binaryTree1.preOrder();
		 checkSumTree(binaryTree1);
		 binaryTree1.preOrder();
	 }

	private static void checkSumTree(_01DataStructures_BinaryTree_00 binaryTree1) {
		checkSumTree(binaryTree1.rootNode);
	}

	private static int checkSumTree(Node node) {
		if(node!=null)
		{
			int leftValue=checkSumTree(node.left);
			int rightValue=checkSumTree(node.right);
			if(leftValue!=0 || rightValue!=0 && node.data!=(leftValue+rightValue)){
				node.data=leftValue+rightValue;
			}
			return node.data;
		}
		else
			return 0;
		
	}
 }
