package PracticeLeetCode;

import java.util.ArrayList;
import java.util.List;

public class _257BinaryTreePaths {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		System.out.println(binaryTreePaths(tn));
	}
	static List<String> outputList;
	public static List<String> binaryTreePaths(TreeNode root) {
		outputList=new ArrayList<>();
		populatePaths("",root);
		return outputList;
	}
	private static void populatePaths(String string, TreeNode root) {
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{
			if(string.length()==0)
			{
				outputList.add(root.val+"");
			}
			else{
				outputList.add(string+"->"+root.val);
			}
		}
		populatePaths(string.length()==0?root.val+"":string+"->"+root.val,root.left);
		populatePaths(string.length()==0?root.val+"":string+"->"+root.val,root.right);
	}

}
