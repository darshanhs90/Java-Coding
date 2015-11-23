package GeeksforGeeksPractice;

/*
 * Link : http://www.geeksforgeeks.org/find-next-right-node-of-a-given-key/
 */
public class _0041NextRightNode {
	public static void main(String[] args) {
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(2);
		tn.right=new TreeNode(6);
		tn.left.left=new TreeNode(8);
		tn.left.right=new TreeNode(4);
		tn.right.right=new TreeNode(5);
		System.out.println(findNextRightNode(tn,2));
		System.out.println(findNextRightNode(tn,4));
		System.out.println(findNextRightNode(tn,10));
		System.out.println(findNextRightNode(tn,6));
		System.out.println(findNextRightNode(tn,5));
	}


	static boolean flag;
	static Integer nextNode=null;
	static TreeNode temp=null;
	private static Integer findNextRightNode(TreeNode tn,int i) {
		int height=getHeight(tn);
		flag=false;
		nextNode=null;
		for (int j = 0; j <=height; j++) {
			temp=null;
			getNode(tn,i,j);
			if(flag)
				break;
		}
		return nextNode;
	}


	private static void getNode(TreeNode tn, int value, int level) {
		if(tn!=null)
		{
			if(level==1)
			{
				
				if(temp!=null && tn.value==value)
				{
					nextNode=temp.value;
					flag=true;
				}
				else if(temp==null && tn.value==value){
					nextNode=null;
					flag=true;
				}
				else
				{
					temp=tn;
				}
			}
			getNode(tn.right, value, level-1);
			getNode(tn.left, value, level-1);
		}
	}



	private static int getHeight(TreeNode tn) {
		return tn!=null?1+Math.max(getHeight(tn.left), getHeight(tn.right)):0;
	}



	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
