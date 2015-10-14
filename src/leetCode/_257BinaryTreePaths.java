package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Link : https://leetcode.com/problems/binary-tree-paths/
 */

public class _257BinaryTreePaths {
	static int paths[]=new int[100000];
	static List<String> stringList;
	public static List<String> binaryTreePaths(TreeNode root) {
		stringList=new ArrayList<>();
		paths=new int[100000];
		findPaths(root,paths,0);
		return stringList;
	}
	private static void findPaths(TreeNode root, int[] path, int pathLen) {
		if(root==null)
			return;
		path[pathLen]=root.val;
		pathLen++;
		if(root.left==null && root.right==null)
		{
			printPaths(path,pathLen);
		}
		else
		{
			findPaths(root.left, path, pathLen);
			findPaths(root.right, path, pathLen);
		}
	}
	private static void printPaths(int[] path, int pathLen) {

		if(pathLen==1){
			stringList.add(path[0]+"");
			return;
		}
		StringBuilder sb=new StringBuilder();
		int i = 0;
		for (i = 0; i <pathLen-1; i++) {
			sb=sb.append(path[i]+"->");
		}
		sb=sb.append(path[i]);
		stringList.add(sb.toString());
	}
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		/*tn.left.right=new TreeNode(5);
		tn.right=new TreeNode(3);*/
		System.out.println(Arrays.toString(binaryTreePaths(tn).toArray()));



	}
}