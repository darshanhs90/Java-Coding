package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/print-nodes-distance-k-leaf-node/
 */
public class _0045DistanceKLeafNodes {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.left.right=new TreeNode(8);
		tn.right.right=new TreeNode(7);
		printNodesAtDist(tn,2,path,0);
		System.out.println("***************");
		printNodesAtDist(tn,1,path,0);		
	}
	static int path[]=new int[10];
	private static void printNodesAtDist(TreeNode tn, int dist, int[] path, int pathLen) {
		if(tn!=null)
		{
			path[pathLen]=tn.value;
			pathLen++;
			if(tn.left==null && tn.right==null)
			{	
				int[] temp=Arrays.copyOfRange(path, 0, pathLen);
				System.out.println(temp[temp.length-dist-1]);
			}
			printNodesAtDist(tn.left, dist, path, pathLen);
			printNodesAtDist(tn.right, dist, path, pathLen);
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
