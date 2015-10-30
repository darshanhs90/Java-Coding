package GeeksforGeeksPractice;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Fuck You Navaneeth,Try copying the code now
 */
public class _0024BinaryTreeCompleteCheck {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode next;
		TreeNode(int x) { val = x; }
	}
	public static void main(String args[]){
		TreeNode tn=new TreeNode(10);
		tn.left=new TreeNode(-2);
		tn.right=new TreeNode(7);
		tn.left.left=new TreeNode(8);
		tn.left.right=new TreeNode(-4);
		System.out.println(checkBinaryTree(tn));
	}
	private static boolean checkBinaryTree(TreeNode tn) {
		if(tn==null)
			return true;
		Queue<TreeNode> queue=new LinkedList<_0024BinaryTreeCompleteCheck.TreeNode>();
		boolean flag=false;
		queue.add(tn);
		while(!queue.isEmpty())
		{
			TreeNode tempNode=queue.poll();
			if(tempNode.left!=null)
			{
				if(flag==true)
					return false;
				queue.add(tempNode.left);
			}
			else{
				flag=true;
			}

			if(tempNode.right!=null)
			{
				if(flag==true)
					return false;
				queue.add(tempNode.right);
			}
			else{
				flag=true;
			}
		}
		return true;
	}

}
