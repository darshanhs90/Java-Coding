package LeetCodePerformancePractice;

public class _292NimGame {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public boolean canWinNim(int n) {
        return n%4>0;
    }

}
