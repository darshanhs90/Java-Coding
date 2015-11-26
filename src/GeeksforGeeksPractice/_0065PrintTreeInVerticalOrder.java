package GeeksforGeeksPractice;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Link : http://www.geeksforgeeks.org/print-binary-tree-vertical-order-set-2/
 */
public class _0065PrintTreeInVerticalOrder {

	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
	    tn.left = new TreeNode(2);
	    tn.right = new TreeNode(3);
	    tn.left.left = new TreeNode(4);
	    tn.left.right = new TreeNode(5);
	    tn.right.left = new TreeNode(6);
	    tn.right.right = new TreeNode(7);
	    tn.right.left.right = new TreeNode(8);
	    tn.right.right.right = new TreeNode(9);
	    printVerticalOrder(tn,0);
	    int key=0;
		while(true)
		{
			if(elementMap.containsKey(key)||elementMap.containsKey(-1*key))
			{	
				if(elementMap.get(key)!=null)
					System.out.println(elementMap.get(key));
				if(elementMap.get(-key)!=null && key!=-key)
					System.out.println(elementMap.get(-1*key));
				key++;
			}
			else{
				break;
			}
		}
	}
	static HashMap<Integer,ArrayList<Integer>> elementMap=new HashMap<>();
	private static void printVerticalOrder(TreeNode tn,int level) {
		if(tn!=null)
		{
			if(elementMap.containsKey(level))
			{
				ArrayList<Integer> list=elementMap.get(level);
				list.add(tn.value);
				elementMap.put(level, list);
			}
			else{
				ArrayList<Integer> list=new ArrayList<>();
				list.add(tn.value);
				elementMap.put(level, list);
			}
			printVerticalOrder(tn.left, level-1);
			printVerticalOrder(tn.right, level+1);
		}
	}
	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}

}
