package servicenowPrep;

import java.util.HashMap;

public class _051VerticalSum
{
	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode( int value) {
			this.value=value;
		}
	}
	static HashMap<Integer, Integer> levelCount=new HashMap<>();
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(26);
		tn.left=new TreeNode(10);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(6);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(31);
		verticalSum(tn);
		System.out.println(levelCount);
	}

	private static void verticalSum(TreeNode tn) {
		getVerticalSum(tn,0);
	}

	private static void getVerticalSum(TreeNode tn, int currLevel) {
		if(tn==null)
			return;
		if(levelCount.containsKey(currLevel))
		{
			levelCount.put(currLevel, levelCount.get(currLevel)+tn.value);
		}
		else{
			levelCount.put(currLevel,tn.value);
		}
		getVerticalSum(tn.left, currLevel-1);
		getVerticalSum(tn.right, currLevel+1);		
	}




}