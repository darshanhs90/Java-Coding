package GeeksforGeeksPractice;

import java.util.HashMap;

public class _0022VerticalSumInTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		getVerticalSum(tn);
	}
	static HashMap<Integer,Integer> levelSum=new HashMap<>();
	private static void getVerticalSum(TreeNode tn) {
		getVerticalSumUtil(tn,0);
		for (int i = 0; i < levelSum.values().toArray().length; i++) {
			System.out.println(levelSum.values().toArray()[i]);
		}
	}
	private static void getVerticalSumUtil(TreeNode tn, int level) {
		if(tn==null)
			return;
		if(!levelSum.containsKey(level))
		{
			levelSum.put(level, tn.val);
		}
		else
		{
			levelSum.put(level, levelSum.get(level)+tn.val);
		}
		getVerticalSumUtil(tn.left,level-1);
		getVerticalSumUtil(tn.right,level+1);
	}

}
