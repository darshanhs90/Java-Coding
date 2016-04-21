package yelpInterview;

import java.util.Stack;

public class _BT04InorderWithoutRecursion {
	static Stack<Node> nodeStack=new Stack<>();
	static class Node{
		Node left,right;
		int value;
		public Node(int value) {
			this.value=value;
		}
	}
	public static void main(String a[]){
		Node n=new Node(1);
		n.left=new Node(2);
		n.right=new Node(3);
		n.left.left=new Node(4);
		n.left.right=new Node(5);
		n.right.left=new Node(6);
		n.right.right=new Node(7);
		inOrder(n);System.out.println();
	}
	private static void inOrder(Node n) {
		if(n!=null){
			addLeftNodes(n);
		}
		while(!nodeStack.isEmpty()){
			Node n1=(nodeStack.pop());
			System.out.println(n1.value);
			addLeftNodes(n1.right);
		}

	}
	private static void addLeftNodes(Node node) {
		if(node==null)
			return;
		while(node!=null)
		{
			nodeStack.push(node);
			node=node.left;
		}
	}

}

