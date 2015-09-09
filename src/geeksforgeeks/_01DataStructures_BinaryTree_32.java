package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;





/*
 * http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
 * Find the maximum sum leaf to root path in a Binary Tree
 */;
 public class _01DataStructures_BinaryTree_32 {
	 static int path[],maxSum=0;
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
		 path=new int[getHeight(binaryTree1)];
		 getMaxSum(binaryTree1);
	 }
	private static int getHeight(_01DataStructures_BinaryTree_00 binaryTree1) {
		
		return getHeight(binaryTree1.rootNode);
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
	private static void getMaxSum(_01DataStructures_BinaryTree_00 binaryTree1) {
		getMaxSum(binaryTree1.rootNode,path,0);
		System.out.println("Max Sum is :"+maxSum);
	}
	private static void getMaxSum(Node node, int[] path2, int pathLen) {
		if(node==null)
		{
			return;
		}
		else{
			path[pathLen]=node.data;
			pathLen++;
		}
		if(node.left==null && node.right==null){
			int sum=0;
			for (int i = 0; i < path2.length; i++) {
				sum+=path2[i];
			}
			if(sum>maxSum)
				maxSum=sum;
		}
		else{
			getMaxSum(node.left,path2,pathLen);
			getMaxSum(node.right,path2,pathLen);
		}
		
	}

	

 }
