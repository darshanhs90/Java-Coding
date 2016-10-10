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
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> list=new ArrayList<>();
		if(root==null)
			return list;
		findPaths("",root,list);
		return list;
	}
	private static void findPaths(String sb, TreeNode root, List<String> list) {
		if(root==null)
			return;
		if(root.left==null && root.right==null)
		{		  
			if(sb.length()==0)
				sb+=root.val;
			else
				sb+="->"+root.val;
			list.add(sb.toString());
			return;
		}
		if(sb.length()==0)
			sb+=root.val;
		else
			sb+="->"+root.val;
		findPaths(sb, root.left, list);
		findPaths(sb, root.right, list);
	}

}
