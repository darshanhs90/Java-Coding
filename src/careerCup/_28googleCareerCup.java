package careerCup;

/*
 * Link: http://www.careercup.com/question?id=296113
 * Find the next in order node of given node in binary tree. Write the program of same. pointer to parent node is given.
 * http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 */
public class _28googleCareerCup {
	public static void main(String[] args) {

		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(22);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(12);
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(14);
		inOrder(tn);
		System.out.println();
		System.out.println(findInOrderSuccessor(tn.left));
		System.out.println(findInOrderSuccessor(tn.left.right.left));
		System.out.println(findInOrderSuccessor(tn.left.right.right));
	}


	private static TreeNode findInOrderSuccessor(TreeNode tn) {


		if(tn.right!=null)
		{
			while(tn.left!=null)
			{
				tn=tn.left;
			}
			return tn;
		}
		TreeNode tempNode=tn.parent;

		while(tempNode.parent!=null && tempNode.parent.right==tempNode)
		{
			tempNode=tempNode.parent;
		}
		if(tempNode!=null)
			if(tempNode.parent.left==tempNode && tempNode.parent.right!=tempNode)
				return tempNode.parent;

		return null;
	}


	private static void inOrder(TreeNode tn) {
		if(tn!=null)
		{	
			inOrder(tn.left);
			System.out.print(tn.val+"/");
			inOrder(tn.right);
		}

	}


	static class TreeNode{
		TreeNode left,right,parent;
		int val;
		public TreeNode(int val) {
			this.val=val;
		}
	}

}
