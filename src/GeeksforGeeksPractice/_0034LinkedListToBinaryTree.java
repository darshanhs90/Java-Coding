package GeeksforGeeksPractice;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Link : http://www.geeksforgeeks.org/given-linked-list-representation-of-complete-tree-convert-it-to-linked-representation/
 */
public class _0034LinkedListToBinaryTree {

	public static void main(String[] args) {
		LinkedList<Integer> ll=new LinkedList<Integer>();
		ll.add(10);
		ll.add(12);
		ll.add(15);
		ll.add(25);
		ll.add(30);
		ll.add(36);
		convertTOBinaryTree(ll);



	}

	private static void convertTOBinaryTree(LinkedList<Integer> ll) {
		Queue<TreeNode> q=new LinkedList<TreeNode>();
		int listSize=ll.size();
		int listPointer=0;
		TreeNode tn=new TreeNode(ll.get(listPointer));
		q.add(tn);
		while(listPointer<listSize)
		{
			TreeNode temp=q.poll();
			listPointer++;
			TreeNode left = null,right = null;
			if(listPointer<listSize){
				left=new TreeNode(ll.get(listPointer));
				q.add(left);
			}
			listPointer++;
			if(listPointer<listSize){
				right=new TreeNode(ll.get(listPointer));
				q.add(right);
			}
			temp.left=left;
			temp.right=right;
		}
		preOrder(tn);
	}

	private static void preOrder(TreeNode tn) {
		if(tn!=null)
		{
			preOrder(tn.left);
			System.out.println(tn.value);
			preOrder(tn.right);
		}
		
	}

	static class TreeNode{
		int value;
		TreeNode left,right;
		public TreeNode(int value) {
			this.value=value;
		}	
	}




}
