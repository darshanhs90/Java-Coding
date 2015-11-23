package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/sum-numbers-formed-root-leaf-paths/
 */
public class _0042SumRootLeafPathNumbers {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(6);
		tn.left=new TreeNode(3);
		tn.right=new TreeNode(5);
		tn.left.left=new TreeNode(2);
		tn.left.right=new TreeNode(5);
		tn.right.right=new TreeNode(4);
		tn.left.right.left=new TreeNode(7);
		tn.left.right.right=new TreeNode(4);
		System.out.println(findSum(tn));
	}
	
	static int[] path;
	static int sum;
	private static int findSum(TreeNode tn) {
		path=new int[10];
		getPaths(tn,path,0);
		return sum;
	}

	private static void getPaths(TreeNode tn, int[] path, int pathLen) {
		if(tn!=null)
		{
			path[pathLen]=tn.value;
			pathLen++;
			if(tn.left==null && tn.right==null){
				sum+=getSum(path,pathLen);
			}
			getPaths(tn.left, path, pathLen);
			getPaths(tn.right, path, pathLen);
		}		
	}
	
	private static int getSum(int[] path2, int pathLen) {
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < pathLen; i++) {
			sb.append(path2[i]);
		}
		return Integer.parseInt(sb.toString());
	}

	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
