package appleInterview;

import java.util.LinkedList;
import java.util.Queue;

public class _DS_BT_02LevelOrderTreeTraversal {
	static class Node{
		Node left,right;
		int value;
		public Node(int value){
			this.value=value;
		}
	}
	public static void main(String[] args) {
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		levelOrderTraversal(n);
		System.out.println();
		levelOrderQueueTraversal(n);
	}
	private static void levelOrderQueueTraversal(Node n) {
		Queue<Node> q=new LinkedList<>();
		q.add(n);
		while(!q.isEmpty())
		{
			Node n1=(q.poll());
			if(n1!=null)
			{
				System.out.print(n1.value+"->");
				q.add(n1.left);
				q.add(n1.right);
			}
		}
	}
	private static void levelOrderTraversal(Node n) {
		int height=getHeight(n);
		for (int i = 0; i < height; i++) {
			levelTraverse(n,i);
		}
	}
	private static void levelTraverse(Node n, int i) {
		if(n==null)
			return;
		if(i==0)
		{
			System.out.print(n.value+"->");
		}
		else{
			levelTraverse(n.left,i-1);
			levelTraverse(n.right,i-1);
		}
	}
	private static int getHeight(Node n) {
		if(n!=null)
			return 1+Math.max(getHeight(n.left),getHeight(n.right));
		return 0;
	}
}
