package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;







/*
 * http://www.geeksforgeeks.org/check-leaves-level/
 * Check if all leaves are at same level
 */;
 public class _01DataStructures_BinaryTree_49 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,12);
		 binaryTree1.insert(12,"left",5);
		 binaryTree1.insert(12,"right",7);
		 binaryTree1.insert(5,"left",3);
		 //binaryTree1.insert(7,"right",1);
		 binaryTree1.preOrder();
		 System.out.println(checkLeavesLevel(binaryTree1));
	 }

	 private static boolean checkLeavesLevel(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 return checkLeavesLevel(binaryTree1.rootNode);
	 }

	 private static boolean  checkLeavesLevel(Node node) {
		 tempQueue queue =new tempQueue();
		 if(node!=null){
			 queue.add(node);
			 int depth=0;
			 while(!queue.isEmpty()){
				 Node n=queue.poll();
				 if(n.left==null && n.right==null)
				 {
					 int nodeDepth=getDepth(node,n,1);
					 if(depth==0)
						 depth=nodeDepth;
					 else{
						 if(nodeDepth!=depth)
							 return false;
					 }
				 }
				 if(n.left!=null)
					 queue.add(n.left);
				 if(n.right!=null)
					 queue.add(n.right); 
			 }
			 return true;
		 }
		 return false;
	 }

	 private static int getDepth(Node node, Node n, int i) {
		 if(node==null)
			 return 0;
		 if(node.data==n.data)
			 return i;
		 int downLevel=getDepth(node.left,n,i+1);
		 if(downLevel!=0)
			 return downLevel;
		 downLevel=getDepth(node.right,n,i+1);
		 return downLevel;
	 }


 }
