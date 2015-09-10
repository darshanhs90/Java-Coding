package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;



/*
 * http://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
 * Find next right node of a given key
 */;
 public class _01DataStructures_BinaryTree_45 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",2);
		 binaryTree1.insert(10,"right",6);
		 binaryTree1.insert(2,"left",8);
		 binaryTree1.insert(2,"right",4);
		 binaryTree1.insert(6,"right",5);
		 System.out.println(findNextRight(binaryTree1,2));
	 }

	 private static int findNextRight(
			 _01DataStructures_BinaryTree_00 binaryTree1, int data) {
		 return findNextRight(binaryTree1.rootNode,data);
	 }

	 private static int findNextRight(Node node, int data) {
		 tempQueue queue=new tempQueue();
		 queue.add(node);
		 if(node!=null){
			 boolean next=false;
			 while(!queue.isEmpty()){
				 Node n=queue.poll();
				 if(next==true)
					 return n.data;
				 if(n.data==(int)data)
					 next=true;
				 //System.out.println(n.data+",");
				 if(n.left!=null)
					 queue.add(n.left);
				 if(n.right!=null)
					 queue.add(n.right);					
			 }
		 }
		 return -1;
	 }

 }
