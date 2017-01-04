package PracticeLeetCode;

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
	    if(num<=0)
	        return false;
		while(num%2==0)
			num=num/2;
		while(num%3==0)
			num=num/3;
		while(num%5==0)
			num=num/5;
		return !(num>1);
	}

}
