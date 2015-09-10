package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;







/*
 * http://www.geeksforgeeks.org/find-depth-of-the-deepest-odd-level-node/
 * Find depth of the deepest odd level leaf node
 */;
 public class _01DataStructures_BinaryTree_50 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(3,"left",5);
		 binaryTree1.insert(3,"right",6);
		 binaryTree1.insert(5,"right",7);
		 binaryTree1.insert(7,"left",9);
		 binaryTree1.insert(6,"right",8);
		 binaryTree1.insert(8,"right",10);
		 binaryTree1.insert(10,"left",11);
		 binaryTree1.preOrder();
		 System.out.println(findDeepestOddLevelLeaf(binaryTree1));
	 }

	 private static int findDeepestOddLevelLeaf(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 return findDeepestOddLevelLeaf(binaryTree1.rootNode);
	 }

	 private static int findDeepestOddLevelLeaf(Node node) {
		 int level=0;
		 if(node!=null){
			 tempQueue queue=new tempQueue();
			 queue.add(node);
			 level=0;
			 while(!queue.isEmpty())
			 {
				 Node n=queue.poll();
				 int nodeLevel=-1;
				 if(n.left==null && n.right==null && (nodeLevel=getLevel(node,n,1))%2!=0)
				 {
					 if(nodeLevel>level){
						 level=nodeLevel;
					 }
				 }
				 if(n.left!=null)
					 queue.add(n.left);
				 if(n.right!=null)
					 queue.add(n.right);
			 }
		 }
		 return level;
	 }

	 private static int getLevel(Node node, Node n, int i) {
		 if(node==null)
			 return 0;
		 if(node.data==n.data)
			 return i;
		 int level=0;
		 if((level=getLevel(node.left,n,i+1))!=0)
			 return level;
		 return getLevel(node.right,n,i+1);
	 }



 }
