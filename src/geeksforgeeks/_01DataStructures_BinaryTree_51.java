package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;







/*
 * http://www.geeksforgeeks.org/difference-between-sums-of-odd-and-even-levels/
 * Difference between sums of odd level and even level nodes of a Binary Tree
 */;
 public class _01DataStructures_BinaryTree_51 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,5);
		 binaryTree1.insert(5,"left",2);
		 binaryTree1.insert(5,"right",6);
		 binaryTree1.insert(2,"left",1);
		 binaryTree1.insert(2,"right",4);
		 binaryTree1.insert(4,"left",3);
		 binaryTree1.insert(6,"right",8);
		 binaryTree1.insert(8,"left",7);
		 binaryTree1.insert(8,"right",9);
		 binaryTree1.preOrder();
		 System.out.println(getDifferenceOddLevelEvenLevel(binaryTree1));
	 }

	 private static int getDifferenceOddLevelEvenLevel(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 return getDifferenceOddLevelEvenLevel(binaryTree1.rootNode);
	 }

	 private static int getDifferenceOddLevelEvenLevel(Node node) {
		 int oddSum=0;
		 int evenSum=0;
		 tempQueue queue=new tempQueue();
		 queue.add(node);
		 while(!queue.isEmpty()){
			 Node n =queue.poll();
			 if(getDepth(node,n,1)%2==0)
			 {
				 evenSum+=n.data;
			 }
			 else{
				 oddSum+=n.data;
			 }
			 if(n.left!=null)
				 queue.add(n.left);
			 if(n.right!=null)
				 queue.add(n.right);

		 }		
		 return oddSum-evenSum;
	 }

	 private static int getDepth(Node node, Node n, int level) {
		 if(node==null)
			 return 0;
		 if(node.data==n.data)
			 return level;
		 int downLevel=getDepth(node.left,n,level+1);
		 if(downLevel!=0)
			 return downLevel;
		 downLevel=getDepth(node.right,n,level+1);
		 return downLevel;
	 }

 }
