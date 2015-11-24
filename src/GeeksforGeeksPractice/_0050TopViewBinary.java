package GeeksforGeeksPractice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Link : http://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
 */
public class _0050TopViewBinary {
	public static void main(String[] args) {
/*		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);*/
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.right=new TreeNode(4);
		tn.left.right.right=new TreeNode(5);
		tn.left.right.right.right=new TreeNode(6);		
		printTopView(tn,0);	
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
	private static void printTopView(TreeNode tn,int level) {
		Queue<TreeNode> elementQueue=new LinkedList<>();
		Queue<Integer> levelQueue=new LinkedList<>();
		if(tn!=null)
		{	
			elementQueue.add(tn);
			levelQueue.add(0);
			while(!elementQueue.isEmpty()){
				tn=elementQueue.poll();
				level=levelQueue.poll();
				if(!elementMap.containsKey(level))
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
