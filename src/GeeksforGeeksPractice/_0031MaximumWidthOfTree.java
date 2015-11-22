package GeeksforGeeksPractice;

import GeeksforGeeksPractice._0022VerticalSumInTree.TreeNode;

public class _0031MaximumWidthOfTree {

	public static void main(String[] args) {

		TreeNode tn=new TreeNode(1);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(3);
		tn.left.left=new TreeNode(4);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(6);
		tn.right.right=new TreeNode(7);
		System.out.println(width(tn));

	}

	private static int width(TreeNode tn) {
		if(tn!=null)
		{	
			int max=0;
			int height=getHeight(tn);
			for (int i = 0; i <=height; i++) {
				int result=getCount(tn,i);
				System.out.println(i+"//"+result);
				if(result>max)
					max=result;
			}
			return max;
		}
		return 0;
	}

	private static int getCount(TreeNode tn, int i) {
		if(tn!=null)
		{
			if(i==1){
				System.out.print("<-"+tn.val+"->");
				return 1;
			}
			return getCount(tn.left, i-1)+getCount(tn.right, i-1);
		}
		return 0;
	}

	private static int getHeight(TreeNode tn) {
		if(tn!=null){
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		}
		return 0;
	}

	

	
}
