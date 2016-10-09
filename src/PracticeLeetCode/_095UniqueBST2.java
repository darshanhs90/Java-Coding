package PracticeLeetCode;

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
			//preOrder(tn);
			System.out.println();
		}
	}

	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> outputList=new ArrayList<>();
		if(n==0)
			return outputList;
		return helper(1,n);
	}

	private static List<TreeNode> helper(int m, int n) {
		List<TreeNode> list=new ArrayList<>();
		if(m>n)
		{
			list.add(null);
			return list;
		}
		for (int i = m; i <=n; i++) {
			List<TreeNode> left=helper(m, i-1);
			List<TreeNode> right=helper(i+1, n);
			for (int j = 0; j < left.size(); j++) {
				for (int j2 = 0; j2 < right.size(); j2++) {
					TreeNode curr=new TreeNode(i);
					curr.left=left.get(j);
					curr.right=right.get(j2);
					list.add(curr);
				}
			}
		}
		return list;
	}
}
