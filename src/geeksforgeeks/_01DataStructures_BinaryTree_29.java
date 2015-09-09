package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;



/*
 * http://www.geeksforgeeks.org/populate-inorder-successor-for-all-nodes/
 * Populate Inorder Successor for all nodes
 */;
 public class _01DataStructures_BinaryTree_29 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(3,"right",6);
		 binaryTree1.inOrder();
		 getInOrderSuccessor(binaryTree1);
		 printInOrderSuccessor(binaryTree1);
	 }

	 private static void printInOrderSuccessor(
			_01DataStructures_BinaryTree_00 binaryTree1) {
		 printInOrderSuccessor(binaryTree1.rootNode);
		
	}

	private static void printInOrderSuccessor(Node node) {
		if(node!=null)
		{
			if(node.next!=null)
				System.out.println(node.data+"//"+node.next.data+",");
			else
				System.out.println(node.data+",");
			
			printInOrderSuccessor(node.left);
			printInOrderSuccessor(node.right);
			
		}
	}

	private static void getInOrderSuccessor(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 getInOrderSuccessor(binaryTree1.rootNode);

	 }
	 static Node next=null;
	 private static void getInOrderSuccessor(Node node) {
		 if(node!=null){
			 getInOrderSuccessor(node.left);
			 node.next=next;
			 next=node;
			 getInOrderSuccessor(node.right);
		 }
	 }
 }
