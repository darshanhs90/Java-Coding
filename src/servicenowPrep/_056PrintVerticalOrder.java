package servicenowPrep;

import java.util.ArrayList;
import java.util.HashMap;

public class _056PrintVerticalOrder
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}
	static HashMap<Integer, ArrayList<Integer>> levelMap=new HashMap<>();
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		tn.right.left.right=new TreeNode(8);
		tn.right.right.right=new TreeNode(9);
		printVerticalOrder(tn,0);
		System.out.println(levelMap);
	}
	private static void printVerticalOrder(TreeNode tn,int level) {
		if(tn==null)return;
		if(levelMap.containsKey(level))
		{
			ArrayList<Integer> aList=levelMap.get(level);
			aList.add(tn.value);
			levelMap.put(level, aList);
		}
		else{
			ArrayList<Integer> aList=new ArrayList<>();
			aList.add(tn.value);
			levelMap.put(level, aList);
		}	
		printVerticalOrder(tn.left, level-1);
		printVerticalOrder(tn.right, level+1);
	}

}