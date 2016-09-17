package LeetCodePerformancePractice;

import java.util.ArrayList;
import java.util.List;

public class _095UniqueBST2 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		List<TreeNode> outputList=generateTrees(3);
		for (int i = 0; i < outputList.size(); i++) {
			TreeNode tn=outputList.get(i);
			preOrder(tn);
			System.out.println();
		}
	}
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.print(tn.val+"/");
			preOrder(tn.right);
		}
	}
	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> outputList=new ArrayList<>();
		if(n==0)
			return outputList;
		return treeHelper(1,n);	
	}
	private static List<TreeNode> treeHelper(int m, int n) {
		List<TreeNode> result=new ArrayList<>();
		if(m>n)
		{
			result.add(null);
			return result;
		}
		for (int i = m; i <=n; i++) {
			List<TreeNode> left=treeHelper(m, i-1);
			List<TreeNode> right=treeHelper(i+1, n);
			for (int j = 0; j < left.size(); j++) {
				for (int j2 = 0; j2 < right.size(); j2++) {
					TreeNode curr=new TreeNode(i);
					curr.left=left.get(j);
					curr.right=right.get(j2);
					result.add(curr);
				}
			}
		}
		return result;
	}


}
