package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/construct-binary-tree-from-inorder-traversal/
 * Construct Special Binary Tree from given Inorder traversal
 */;
 public class _01DataStructures_BinaryTree_33 {
	 public static void main(String[] args) {
		 int inorder[] = {1, 5, 10, 40, 30, 15, 28, 20};//{5,10,40,30,28};
		 Node root=buildTree(inorder,0,inorder.length-1);
		 preOrder(root);
	 }
	 private static void preOrder(Node root) {
		 if(root!=null)
		 {
			 System.out.print(root.data+",");
			 preOrder(root.left);
			 preOrder(root.right);
		 }
		
	}
	private static Node buildTree(int[] inorder,int start,int end) {
		 if(start>end)
			 return null;
		 int index=findMax(inorder,start,end);
		 _01DataStructures_BinaryTree_00 tree=new _01DataStructures_BinaryTree_00();
		 Node n=tree.new Node(inorder[index],null,null);
		 if(start==end)
			 return n;
		 n.left=buildTree(inorder,start,index-1);
		 n.right=buildTree(inorder,index+1,end);
		 return n;
	 }
	 private static int findMax(int[] inorder, int start, int end) {
		 int max=0;
		 int index=-1;
		 for (int i = start; i <=end; i++) {
			 if(inorder[i]>max){
				 max=inorder[i];
				 index=i;
			 }
		 }
		 return index;
	 }



 }
