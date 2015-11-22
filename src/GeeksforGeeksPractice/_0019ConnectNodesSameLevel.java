package GeeksforGeeksPractice;

public class _0019ConnectNodesSameLevel {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(8);
		tn.right=new TreeNode(2);
		tn.left.left=new TreeNode(3);
		tn.left.right=new TreeNode(5);
		tn.right.left=new TreeNode(1);
		tn.right.right=new TreeNode(30);
		tn.next=null;
		//connect(tn);
		connectRecursive(tn);
		preOrder(tn);
	}
	private static void connectRecursive(TreeNode tn) {
		if(tn!=null)
		{
			if(tn.left!=null)
			{
				tn.left.next=tn.right;
			}
			if(tn.right!=null)
			{
				tn.right.next=(tn.next!=null)?tn.next.left:null;
			}
			connectRecursive(tn.left);
			connectRecursive(tn.right);
		}
		
	}
	static TreeNode temp;
	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{	
			if(tn.next==null)
				System.out.println(tn.val+"//null");
			else
				System.out.println(tn.val+"//"+tn.next.val);
			preOrder(tn.left);
			preOrder(tn.right);
		}
	}
	private static void connect(TreeNode tn) {
		int height=getHeight(tn);
		for (int i = 0; i <=height; i++) {
			temp=null;
			connectNodes(tn,i);
			System.out.println();
		}
	}
	private static void connectNodes(TreeNode tn, int i) {
		if(tn!=null)
		{
			if(i==1){
				System.out.print(tn.val+"/");
				if(temp!=null)
					tn.next=temp;
				else{
					tn.next=null;
				}
				temp=tn;
			}
			connectNodes(tn.right,i-1);
			connectNodes(tn.left,i-1);
		}
	}
	private static int getHeight(TreeNode tn) {
		if(tn!=null)
		{
			return 1+Math.max(getHeight(tn.left), getHeight(tn.right));
		}
		return 0;
	}
	
}
