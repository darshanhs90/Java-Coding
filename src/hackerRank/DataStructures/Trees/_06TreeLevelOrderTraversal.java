package hackerRank.DataStructures.Trees;

/*
 * Link:https://www.hackerrank.com/challenges/tree-level-order-traversal
 */

public class _06TreeLevelOrderTraversal {
	class Node {
		int data;
		Node left;
		Node right;
	}
	void LevelOrder(Node root)
	{
		int height=getHeight(root);
		for(int i=0;i<=height;i++){
			getNodes(root,i);
		}
	}

	void getNodes(Node node,int level)
	{
		if(node!=null)
		{
			if(level==1)
				System.out.print(node.data+" ");
			else
			{
				getNodes(node.left,level-1);
				getNodes(node.right,level-1);
			}
		}

	}

	int getHeight(Node node){
		return node!=null?1+Math.max(getHeight(node.left),getHeight(node.right)):0;
	}   

}
