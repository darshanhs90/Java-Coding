package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 */

public class _107BinaryLevelOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	static List<List<Integer>> ArrayList;
	static List<Integer> arrayArrayList;
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		int height=getHeight(root);
		ArrayList=new ArrayList<List<Integer>>();
		for (int i = 1; i <=height; i++) {
			arrayArrayList=new ArrayList<>();
			printNodes(root,i);
			ArrayList.add(arrayArrayList);
		}
		List<List<Integer>> ArrayListNew=new ArrayList<List<Integer>>();

		for (int i = ArrayList.size()-1;i>=0; i--) {
			ArrayListNew.add(ArrayList.get(i));	
		}
		return ArrayListNew;
	}





	private static void printNodes(TreeNode root, int height) {
		if(root==null)
			return;
		if(height==1){
			arrayArrayList.add(root.val);
		}
		else if(height>1){
			printNodes(root.left, height-1);
			printNodes(root.right, height-1);
		}
	}





	private static int getHeight(TreeNode root) {
		int leftHeight=0,rightHeight=0;
		if(root==null)
			return 0;
		if(root.left!=null)
			leftHeight=getHeight(root.left);
		if(root.right!=null)
			rightHeight=getHeight(root.right);
		if(leftHeight>rightHeight)
			return 1+leftHeight;
		else
			return 1+rightHeight;
	}





	public static void main(String[] args) {
		TreeNode rootnode=new TreeNode(3);
		rootnode.left=new TreeNode(9);
		rootnode.right=new TreeNode(20);
		rootnode.right.left=new TreeNode(15);
		rootnode.right.right=new TreeNode(7);
		List<List<Integer>> ArrayList=levelOrderBottom(rootnode);
		for (int i = 0; i < ArrayList.size(); i++) {
			System.out.println(Arrays.toString(ArrayList.get(i).toArray()));
		}
	}
}