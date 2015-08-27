package ctci;

import ctci._10BinarySearchTree.Node;


/*Implementation of Depth First Search */
public class _13DFS{
	Node rootNode;
	public void preOrder(){
		System.out.println("********Pre order Starts**********");
		preOrder(rootNode);
		System.out.println("*********Pre order Ends***********");
	}
	private void preOrder(Node node){
		if(node!=null){
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
}