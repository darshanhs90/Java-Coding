package appleInterview;

import java.util.Iterator;
import java.util.Stack;

public class _09PrepDocListInOrderIterator {
	static class Node{Node left,right;int value;
	public Node( int value){this.value=value;}
	}
	public static void main(String[] args) {
		Node n=new Node(5);
		n.left=new Node(3);
		n.right=new Node(7);
		n.left.left=new Node(1);
		n.left.right=new Node(4);
		n.right.left=new Node(6);
		n.right.right=new Node(8);
		Iteratorn itr=new Iteratorn(n);
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	static class Iteratorn implements Iterator<Integer>{
		Stack<Node> stack=new Stack<>();
		public Iteratorn(Node root) {
			addLeftNodes(root);
		}
		public void addLeftNodes(Node n)
		{
			while(n!=null)
			{
				stack.push(n);
				n=n.left;
			}
		}
		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public Integer next() {
			Node n=stack.pop();
			addLeftNodes(n.right);
			return n.value;
		}

	}
}
