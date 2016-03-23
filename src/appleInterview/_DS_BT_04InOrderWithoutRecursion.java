package appleInterview;

import java.util.Stack;

public class _DS_BT_04InOrderWithoutRecursion {
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
		inOrderTraversal(n);
	}
	private static void inOrderTraversal(Node n) {
		Stack<Node> stack=new Stack<>();
		while(n!=null)
		{
			stack.push(n);
			n=n.left;
		}
		
		while(!stack.isEmpty())
		{	
			Node n1=stack.pop();
			if(n1.right!=null){
				stack.push(n1.right);
				Node n2=n1.right;
				while(n2!=null && n2.left!=null)
				{
					stack.push(n2);
					n2=n2.left;
				}
			}
			System.out.println(n1.value);
		}
	}

}

