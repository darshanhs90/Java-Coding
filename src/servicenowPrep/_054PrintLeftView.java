package servicenowPrep;

import java.util.Stack;

public class _054PrintLeftView
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(22);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(12);
		tn.right.right=new TreeNode(25);
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(14);	
		printLeftView(tn);
	}
	static boolean printed=false;
	private static void printLeftView(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 0; i < height; i++) {
			printed=false;
			printNodes(tn,i);
		}
	}
	private static void printNodes(TreeNode tn, int i) {
		if(tn==null||printed)
			return;
		if(i==0 && !printed){
			System.out.println(tn.value);
			printed=true;
		}
		printNodes(tn.left, i-1);
		printNodes(tn.right, i-1);
	}
	private static int getHeight(TreeNode tn) {
		return tn==null?0:1+Math.max(getHeight(tn.left), getHeight(tn.right));
	}



}