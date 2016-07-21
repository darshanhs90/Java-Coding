package LeetCodePractice;

public class _129SumRootToLeafNumbers {
	public static  class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(0);
		tn.left=new TreeNode(1);
		//tn.right=new TreeNode(3);
		System.out.println(sumNumbers(tn));
	}
	static int[] path=new int[100];
	static int sum=0;
	public static int sumNumbers(TreeNode root) {
		sum=0;
		printNodes(root,"",0);
		return sum;
	}
	private static void printNodes(TreeNode tn, String str, int i) {
		if(tn==null)
			return;
		if(tn.left==null && tn.right==null)
		{	
			path[i]=tn.val;
			str+=tn.val;
			//sum+=Integer.parseInt(str);
			String s="";
			for (int j = 0; j <=i; j++) {
				s+=path[j];
			}
			sum+=Integer.parseInt(s);
			return;
		}
		str+=tn.val;
		path[i]=tn.val;
		printNodes(tn.left, str, i+1);
		printNodes(tn.right, str, i+1);

	}
}

