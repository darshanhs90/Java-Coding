package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;

/*
 * http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
 * Print all nodes at distance k from a given node
 */;
 public class _01DataStructures_BinaryTree_57 {
	 static int path[];
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,20);
		 binaryTree1.insert(20,"left",8);
		 binaryTree1.insert(20,"right",22);
		 binaryTree1.insert(8,"left",4);
		 binaryTree1.insert(8,"right",12);
		 binaryTree1.insert(12,"left",10);
		 binaryTree1.insert(12,"right",14);
		 binaryTree1.preOrder();
		 printNodes(binaryTree1,8,2);

	 }
	 private static void printNodes(_01DataStructures_BinaryTree_00 binaryTree1,
			 int nodeData, int distance) {
		 Node n=getNode(binaryTree1.rootNode,nodeData);
		 printNodes(n,8,2);
	 }
	 private static void printNodes(Node node, int nodeData, int distance) {
		 //get root to leaf paths for all nodes
		 path=new int[getHeight(node)];
		 getRootLeafPath(node,path,0);

	 }
	 private static void getRootLeafPath(Node node, int[] path, int i) {
		 
		
	}
	private static int getHeight(Node node) {
		if(node!=null){
			
		}
		return 0;
	}
	private static Node getNode(Node node,int nodeData) {
		 if(node!=null)
		 {
			 if(node.data==nodeData)
				 return node;
			 else{
				 Node n=getNode(node.left,nodeData);
				 if(n!=null)
					 return n;
				 else
					 return getNode(node.right,nodeData);
			 }
		 }
		 return null;
	 }

 }
