package LeetCodePerformancePractice;

public class _096UniqueBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(numTrees(3));
	}
	public static int numTrees(int n) {
		if(n<=1)
			return 1;
		int[] count=new int[n+1];
		count[0]=1;
		count[1]=1;
		for (int i = 2; i < count.length; i++) {
			for (int j = i-1; j >=0; j--) {
				count[i]+=count[j]*count[i-j-1];
			}
		}
		return count[n];
	}

}
