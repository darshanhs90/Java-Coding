package GeeksforGeeksPractice;

import java.util.ArrayList;
import java.util.Arrays;
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
		//12,2,4,3,7
	}
	static HashMap<Integer, Integer> elementMap=new HashMap<>();
	static int max=0,min=0;
	private static void getVerticalSum(TreeNode tn) {
		getSum(tn,0);
		for (int i = min; i <=max; i++) {
			System.out.println(elementMap.get(i));
		}
	}
	private static void getSum(TreeNode tn, int i) {
		if(tn!=null)
		{	
			if(i>max)
				max=i;
			if(i<min)
				min=i;
			if(elementMap.containsKey(i))
			{
				elementMap.put(i,elementMap.get(i)+tn.val);
			}
			else{
				elementMap.put(i,tn.val);
			}
			getSum(tn.left, i-1);
			getSum(tn.right, i+1);
		}
		
	}
	
}
