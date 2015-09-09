package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;


/*
 * http://www.geeksforgeeks.org/check-if-a-binary-tree-is-subtree-of-another-binary-tree/
 * Check if a binary tree is subtree of another binary tree 
 */;
 public class _01DataStructures_BinaryTree_27 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",4);
		 binaryTree1.insert(10,"right",6);
		 binaryTree1.insert(4,"right",30);
		 binaryTree1.preOrder();
		 _01DataStructures_BinaryTree_00 binaryTree2=new _01DataStructures_BinaryTree_00();
		 binaryTree2.insert(null,null,26);
		 binaryTree2.insert(26,"left",10);
		 binaryTree2.insert(26,"right",3);
		 binaryTree2.insert(3,"right",3);
		 binaryTree2.insert(10,"left",4);
		 binaryTree2.insert(10,"right",6);
		 binaryTree2.insert(4,"right",32);
		 binaryTree2.preOrder();
		 System.out.println(checkSubTree(binaryTree1,binaryTree2));
	 }

	 private static boolean checkSubTree(//checks if bin tree1 is a subset of bin tree2
			 _01DataStructures_BinaryTree_00 binaryTree1,
			 _01DataStructures_BinaryTree_00 binaryTree2) {
		 return checkSubTree(binaryTree1.rootNode,binaryTree2.rootNode);
	 }

	 private static boolean checkSubTree(Node node1, Node node2) {
		 node2=getNode(node1,node2);
		 return checkStructure(node1,node2);
	 }

	 private static boolean checkStructure(Node node1, Node node2) {
		if(node1!=null && node2!=null)
		{
			return (node1.data==node2.data 
					&& checkStructure(node1.left,node2.left)
					&& checkStructure(node1.right,node2.right));
		}
		return true;
	}

	private static Node getNode(Node node1, Node node2) {
		 if(node2!=null){
			 if(node1.data==node2.data)
				 return node2;
			 else if(node2.left!=null)
				 return getNode(node1,node2.left);
			 else
				 return getNode(node1,node2.right);
		 }
		 return null;
	 }


 }
