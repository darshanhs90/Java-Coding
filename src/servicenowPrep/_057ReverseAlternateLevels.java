package servicenowPrep;

import java.util.Stack;

public class _057ReverseAlternateLevels
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}
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
		reverseAlternateLevels(tn);
	}
	private static void preOrder(TreeNode tn) {
		if(tn==null)return;
		System.out.print(tn.value+"/");
		preOrder(tn.left);
		preOrder(tn.right);
	}
	static Stack<Integer> stack;
	private static void reverseAlternateLevels(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 0; i < height; i++) {
			if(i%2!=0){
				stack=new Stack<Integer>();
				populateNodes(tn,i);System.out.println();
				printNodes(tn,i);
				repopulateNodes(tn,i);
				printNodes(tn,i);System.out.println();
			}
		}
	}
	private static void repopulateNodes(TreeNode tn, int i) {
		if(tn==null)return;
		if(i==0)
		{
			tn.value=stack.pop();
			return;
		}
		repopulateNodes(tn.left, i-1);
		repopulateNodes(tn.right, i-1);
	}
	private static void populateNodes(TreeNode tn, int i) {
		if(tn==null)return;
		if(i==0)
		{	
			stack.push(tn.value);
			return;
		}
		populateNodes(tn.left, i-1);
		populateNodes(tn.right, i-1);
	}
	private static void printNodes(TreeNode tn, int i) {
		if(tn==null)return;
		if(i==0)
		{	
			System.out.print(tn.value+"/");
			return;
		}
		printNodes(tn.left, i-1);
		printNodes(tn.right, i-1);
	}
	private static int getHeight(TreeNode tn) {
		return tn==null?0:1+Math.max(getHeight(tn.left), getHeight(tn.right));
	}

}