package GeeksforGeeksPractice;

import java.util.Arrays;

/*
 * Link : http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 */
public class _0043LCA {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		System.out.println(lca(tn,4,5));
		System.out.println(lca(tn,4,6));
		System.out.println(lca(tn,3,4));
		System.out.println(lca(tn,2,4));
	}
	
	
	static int[] path,pathFirst,pathSecond;
	private static int lca(TreeNode tn, int firstNode, int secondNode) {
		path=new int[10];
		pathFirst=new int[10];
		pathSecond=new int[10];
		getPath(tn,firstNode,path,0);
		pathSecond=pathFirst;
		getPath(tn,secondNode,path,0);
		System.out.println(Arrays.toString(pathFirst));
		System.out.println(Arrays.toString(pathSecond));
		return findIntersection(pathFirst,pathSecond);
	}



	private static int findIntersection(int[] pathFirst, int[] pathSecond) {
		int length=pathFirst.length>pathSecond.length?pathSecond.length:pathFirst.length;
		for (int i = 0; i <length; i++) {
			if(pathFirst[i]!=pathSecond[i] && i!=0)
			{
				return pathFirst[i-1];
			}	
			else if(pathFirst[i]!=pathSecond[i] && i==0)
			{
				return Integer.MIN_VALUE;
			}
		}
		return pathFirst[length-1];
	}



	private static void getPath(TreeNode tn, int firstNodeValue, int[] path, int pathLen) {
		if(tn!=null)
		{
			path[pathLen]=tn.value;
			pathLen++;
			if(tn.value==firstNodeValue)
			{
				pathFirst=Arrays.copyOfRange(path,0, pathLen);
				return;
			}
			getPath(tn.left, firstNodeValue, path, pathLen);
			getPath(tn.right, firstNodeValue, path, pathLen);
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
