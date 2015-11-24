package GeeksforGeeksPractice;

import java.util.Stack;

/*
 * Link : http://www.geeksforgeeks.org/reverse-alternate-levels-binary-tree/
 */
public class _0046ReverseAlternateLevels {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		
		tn.left.left.left=new TreeNode(8);
		tn.left.left.right=new TreeNode(9);
		
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(11);
		
		tn.right.left.left=new TreeNode(12);
		tn.right.left.right=new TreeNode(13);
		
		tn.right.right.left=new TreeNode(14);
		tn.right.right.right=new TreeNode(15);
		
		levelOrderTraversal(tn);
		alterNateLevels(tn);
		levelOrderTraversal(tn);
		
	}
	static Stack<Integer> stack=new Stack<Integer>();
	private static void alterNateLevels(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 0; i <=height; i++) {
			if(i%2!=0)
				changeLeaves(tn,i);
		}
	}

	private static void changeLeaves(TreeNode tn, int i) {
		printNodesArray(tn,i);
		replaceNodesArray(tn,i);
	}

	private static void replaceNodesArray(TreeNode tn, int level) {
		if(tn!=null)
		{
			if(level==0)
			{
				(tn.value)=stack.pop();
			}
			replaceNodesArray(tn.left, level-1);
			replaceNodesArray(tn.right, level-1);
		}
		
	}

	private static void printNodesArray(TreeNode tn, int level) {
		if(tn!=null)
		{
			if(level==0)
			{
				stack.push(tn.value);
			}
			printNodesArray(tn.left, level-1);
			printNodesArray(tn.right, level-1);
		}
	}

	private static void levelOrderTraversal(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 0; i <=height; i++) {
			printNodes(tn,i);
			System.out.println(i+"->");
		}
	}

	private static int getHeight(TreeNode tn) {
		return tn!=null?1+Math.max(getHeight(tn.left), getHeight(tn.right)):0;
	}

	private static void printNodes(TreeNode tn, int level) {
		if(tn!=null)
		{
			if(level==0)
				System.out.print(tn.value+"//");
			printNodes(tn.left, level-1);
			printNodes(tn.right, level-1);
		}
	}

	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
