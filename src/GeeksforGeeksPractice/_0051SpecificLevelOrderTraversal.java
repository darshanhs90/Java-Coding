package GeeksforGeeksPractice;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Link : http://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal/
 */
public class _0051SpecificLevelOrderTraversal {
	public static void main(String[] args) {
		TreeNode tn = new TreeNode(1);
		tn.left        = new TreeNode(2);
		tn.right       = new TreeNode(3);
		tn.left.left  = new TreeNode(4);
		tn.left.right = new TreeNode(5);
		tn.right.left  = new TreeNode(6);
		tn.right.right = new TreeNode(7);
		tn.left.left.left  = new TreeNode(8);
		tn.left.left.right  = new TreeNode(9);
		tn.left.right.left  = new TreeNode(10);
		tn.left.right.right  = new TreeNode(11);
		tn.right.left.left  = new TreeNode(12);
		tn.right.left.right  = new TreeNode(13);
		tn.right.right.left  = new TreeNode(14);
		tn.right.right.right  = new TreeNode(15);
		tn.left.left.left.left  = new TreeNode(16);
		tn.left.left.left.right  = new TreeNode(17);
		tn.left.left.right.left  = new TreeNode(18);
		tn.left.left.right.right  = new TreeNode(19);
		tn.left.right.left.left  = new TreeNode(20);
		tn.left.right.left.right  = new TreeNode(21);
		tn.left.right.right.left  = new TreeNode(22);
		tn.left.right.right.right  = new TreeNode(23);
		tn.right.left.left.left  = new TreeNode(24);
		tn.right.left.left.right  = new TreeNode(25);
		tn.right.left.right.left  = new TreeNode(26);
		tn.right.left.right.right  = new TreeNode(27);
		tn.right.right.left.left  = new TreeNode(28);
		tn.right.right.left.right  = new TreeNode(29);
		tn.right.right.right.left  = new TreeNode(30);
		tn.right.right.right.right  = new TreeNode(31);
		levelOrderTraversal(tn);
	}






	private static void levelOrderTraversal(TreeNode tn) {
		Queue<TreeNode> q=new LinkedList<>();
		if(tn!=null)
		{
			
			System.out.println(tn.value);
			if(tn.left!=null){
				//System.out.println(tn.left.value);
				q.add(tn.left);	
			}
			if(tn.right!=null){
				//System.out.println(tn.right.value);
				q.add(tn.right);
			}			
			while(!q.isEmpty())
			{
				tn=q.poll();
				System.out.print(tn.value+"->");
				if(!q.isEmpty()){
					TreeNode tn1=q.poll();
					System.out.print(tn1.value+"->");
					TreeNode tnLeft=tn.left;
					TreeNode tnRight=tn.right;
					TreeNode tn1Left=tn1.left;
					TreeNode tn1Right=tn1.right;
					if(tnLeft!=null)
						q.add(tnLeft);
					if(tn1Right!=null)
						q.add(tn1Right);
					if(tnRight!=null)
						q.add(tnRight);
					if(tn1Left!=null)
						q.add(tn1Left);						
				}
			}
		}
	}






	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value) {
			this.value=value;
		}		
	}


}
