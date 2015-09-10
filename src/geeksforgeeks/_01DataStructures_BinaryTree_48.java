package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;






/*
 * http://www.geeksforgeeks.org/print-left-view-binary-tree/
 * Print Left View of a Binary Tree
 */;
 public class _01DataStructures_BinaryTree_48 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,12);
		 binaryTree1.insert(12,"left",10);
		 binaryTree1.insert(12,"right",30);
		 binaryTree1.insert(30,"left",25);
		 binaryTree1.insert(30,"right",40);
		 binaryTree1.preOrder();
		 printLeftViewRecursive(binaryTree1);

	 }

	 private static void printLeftViewRecursive(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 printLeftViewRecursive(binaryTree1.rootNode);
	 }

	 private static void printLeftViewRecursive(Node node) {
		 if(node==null)
			 return;
		 tempQueue queue=new tempQueue();
		 queue.add(node);
		 int depth=0;
		 while(!queue.isEmpty()){
			 Node n=queue.poll();
			 int h=getDepth(node,n,1);
			 if(h>depth){
				 System.out.print(n.data+",");
				 depth=h;
			 }
			 if(n.left!=null)
				 queue.add(n.left);
			 if(n.right!=null)
				 queue.add(n.right); 
		 }

	 }

	 private static int getDepth(Node node, Node n, int i) {

		 if(node!=null){
			 if(node.data==n.data)
				 return i;
			 else
			 {
				 int downLevel=getDepth(node.left,n,i+1);
				 if(downLevel!=0)
					 return downLevel;
				 downLevel=getDepth(node.right,n,i+1);
				 return downLevel;
			 }

		 }
		 return 0;
	 }




 }
