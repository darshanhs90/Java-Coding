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
		List<TreeNode> list=new ArrayList<TreeNode>();
		if(n==0)
			return list;
		return generateTrees(1,n);
	}

	private static List<TreeNode> generateTrees(int m, int n) {
		List<TreeNode> list=new ArrayList<TreeNode>();
		if(m>n){
			list.add(null);
			return list;
		}

		for (int i = m; i <=n; i++) {
			List<TreeNode> leftNodes=generateTrees(m,i-1);
			List<TreeNode> rightNodes=generateTrees(i+1,n);
			for (int j = 0; j < leftNodes.size(); j++) {
				for (int k = 0; k < rightNodes.size(); k++) {
					TreeNode tn=new TreeNode(i);
					tn.left=leftNodes.get(j);
					tn.right=rightNodes.get(k);
					list.add(tn);
				}
			}
		}
		return list;
	}

}
