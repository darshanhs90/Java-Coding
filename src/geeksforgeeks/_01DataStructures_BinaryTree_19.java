package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

//Needs Bug Fixes

/*
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * Construct Tree from given Inorder and Preorder traversals
 */;
 public class _01DataStructures_BinaryTree_19 {
	  static int preIndex=0;
	 static _01DataStructures_BinaryTree_00 tree=new _01DataStructures_BinaryTree_00();
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,50);
		 binaryTree1.insert(50,"left",7);
		 binaryTree1.insert(50,"right",2);
		 binaryTree1.insert(7,"left",3);
		 binaryTree1.insert(7,"right",5);
		 binaryTree1.insert(2,"left",1);
		 binaryTree1.insert(2,"right",30);
		 binaryTree1.preOrder();//50,7,3,5,2,1,30,
		 binaryTree1.inOrder();//3,7,5,50,1,2,30,
		 String inOrder[]={"50","7","3","5","2","1","30"};
		 String preOrder[]={"3","7","5","50","1","2","30"};
		 buildTree(inOrder,preOrder,0,inOrder.length-1);
	 }

	 private static Node buildTree(String[] inOrder, String[] preOrder,int start,int end) {
		 if(start>end)
			 return null;
		 System.out.println(preIndex);
		 Node node=tree.new Node(Integer.parseInt(preOrder[preIndex++]),null,null);
		 //preIndex++;
		 if(start==end)
			 return node;
		 int inIndex=findIndex(inOrder,start,end,node.data);
		 node.left=buildTree(inOrder,preOrder,start,inIndex-1);
		 node.right=buildTree(inOrder,preOrder,inIndex+1,end);
		 return node;
	 }

	 private static int findIndex(String[] inOrder, int start, int end,
			 Integer data) {
		 for (int i = start; i <= end; i++) {
			 if(Integer.parseInt(inOrder[i])==data)
				 return i;
		 }
		 return 0;
	 }
 }
