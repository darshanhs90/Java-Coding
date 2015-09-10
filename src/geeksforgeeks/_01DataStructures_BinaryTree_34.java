package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/construct-a-special-tree-from-given-preorder-traversal/
 * Construct a special tree from given preorder traversal
 * 				***********Code HAS BUG*************
 */;
 public class _01DataStructures_BinaryTree_34 {
	 public static void main(String[] args) {
		 int pre[] = {10, 30, 20, 5, 15};
		 char preLN[] = {'N', 'N', 'L', 'L', 'L'};
		 Node root=buildTree(pre,preLN,0,pre.length-1);
		 preOrder(root);
	 }
	 private static Node buildTree(int[] pre, char[] preLN, int i, int j) {
		 int index=i;
		 if(i==j)
			 return null;
		 _01DataStructures_BinaryTree_00 tree=new _01DataStructures_BinaryTree_00();
		 Node n=tree.new Node(pre[index],null,null);
		 index++;
		 if(preLN[index]=='N'){
			 n.left=buildTree(pre,preLN,index,j);
			 n.right=buildTree(pre,preLN,index,j);
		 }
		 return n;
	 }
	 private static void preOrder(Node root) {
		 if(root!=null)
		 {
			 System.out.print(root.data+",");
			 preOrder(root.left);
			 preOrder(root.right);
		 }

	 }

 }
