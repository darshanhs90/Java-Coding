package GeeksforGeeksPractice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Link : http://www.geeksforgeeks.org/bottom-view-binary-tree/
 */
public class _0049BottomViewOfTree {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(20);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(22);
		tn.right.right=new TreeNode(25);
		tn.left.left=new TreeNode(5);
		tn.left.right=new TreeNode(3);
		tn.left.right.left=new TreeNode(10);
		tn.left.right.right=new TreeNode(14);
		printBottomView(tn,0);	
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
	
	
	private static HashMap<Integer,Integer> elementMap=new HashMap<>();
	private static void printBottomView(TreeNode tn,int level) {
		Queue<TreeNode> elementQueue=new LinkedList<>();
		Queue<Integer> levelQueue=new LinkedList<>();
		if(tn!=null)
		{	
			elementQueue.add(tn);
			levelQueue.add(0);
			while(!elementQueue.isEmpty()){
				tn=elementQueue.poll();
				level=levelQueue.poll();
				elementMap.put(level,tn.value);
				if(tn.left!=null)
				{
					elementQueue.add(tn.left);
					levelQueue.add(level-1);
				}
				if(tn.right!=null)
				{
					elementQueue.add(tn.right);
					levelQueue.add(level+1);
				}
			}
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
