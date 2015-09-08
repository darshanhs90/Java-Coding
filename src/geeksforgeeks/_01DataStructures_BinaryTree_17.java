package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;





/*
 * http://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 * Root to leaf path sum equal to a given number
 */;
 public class _01DataStructures_BinaryTree_17 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,50);
		 binaryTree1.insert(50,"left",7);
		 binaryTree1.insert(50,"right",2);
		 binaryTree1.insert(7,"left",3);
		 binaryTree1.insert(7,"right",5);
		 binaryTree1.insert(2,"left",1);
		 binaryTree1.insert(2,"right",30);
		 binaryTree1.preOrder();
		 binaryTree1.inOrder();
		 System.out.println(getRootLeafPathSum(binaryTree1,60));
	 }

	 private static boolean getRootLeafPathSum(
			 _01DataStructures_BinaryTree_00 binaryTree1,int sum) {
		return getRootLeafPathSum(binaryTree1.rootNode,sum);
	 }

	 private static boolean getRootLeafPathSum(Node node,int sum) {
		if(node==null)
			return sum==0;
		else{
			boolean answer=false;
			int subSum=sum-node.data;
			if(subSum==0 && node.left==null && node.right==null)
				return true;
			if(node.left!=null)
				answer=answer|| getRootLeafPathSum(node.left,subSum);
			if(node.right!=null)
				answer=answer|| getRootLeafPathSum(node.right,subSum);
			return answer;
		}	
	 }

 }
