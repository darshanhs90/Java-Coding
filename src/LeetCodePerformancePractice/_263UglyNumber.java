package LeetCodePerformancePractice;

public class _263UglyNumber {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		System.out.println(isUgly(6));
		System.out.println(isUgly(8));
		System.out.println(isUgly(14));
		System.out.println(isUgly(1));
	}
	public static boolean isUgly(int num) {
		if(num==0)
			return false;
		if(num==1)
			return true;
		if(num%2==0)
			return isUgly(num/2);
		if(num%3==0)
			return isUgly(num/3);
		if(num%5==0)
			return isUgly(num/5);
		return false;
	}
}
