package GeeksforGeeksPractice;

public class _0023MaximumSumLeafToRootPath {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(-2);
		tn.right=new TreeNode(7);
		tn.left.left=new TreeNode(8);
		tn.left.right=new TreeNode(-4);
		System.out.println(maxSumPath(tn));
	}
	static int maxSum=Integer.MIN_VALUE;
	static int path[];
	public static int maxSumPath(TreeNode tn) {
		path=new int[1000];
		findPath(tn,path,0);
		return maxSum;
	}
	private static void findPath(TreeNode tn, int[] path, int pathLen) {
		if(tn==null)
			return;
		path[pathLen]=tn.val;
		pathLen++;
		if(tn.left==null&& tn.right==null)
		{	
			maxSum=getMax(path,pathLen);		
		}
		findPath(tn.left, path, pathLen);
		findPath(tn.right, path, pathLen);	
	}
	private static int getMax(int[] path2, int pathLen) {
		int sum=0;
		for (int i = 0; i < pathLen; i++) {
			sum+=path2[i];
		}
		if(sum>maxSum)
		{
			maxSum=sum;
		}
		return maxSum;
	}
}
