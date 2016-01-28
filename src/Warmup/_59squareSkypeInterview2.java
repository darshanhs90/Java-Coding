package Warmup;

import java.util.Iterator;
import java.util.Stack;

public class _59squareSkypeInterview2 {

	public static void main(String[] args) {
		BST tree = new BST();
		tree.add(10);
		tree.add(15);
		tree.add(5);

		tree.add(2);

		tree.add(7);
		tree.add(12);
		tree.add(20);
		tree.add(5);

		tree.print();
		System.out.println("---");
		for (int i : tree) {
			System.out.println(i);
		}


		//tree.print();
		System.out.println("done");
	}

	static class TreeNode{
		TreeNode left,right;
		int value;
		public TreeNode(int value)
		{
			this.value=value;
		}
	}

	static class BSTIter implements Iterator<Integer> {
		Stack<TreeNode> stack=new Stack<TreeNode>();

		public BSTIter(TreeNode root) {
			addLeftChild(root);
		}
		public void addLeftChild(TreeNode tn){
			while(tn!=null)
			{
				stack.push(tn);
				tn=tn.left;        
			}
		}
		@Override
		public boolean hasNext() {
			if(stack.isEmpty())
				return false;
			return true;
		}

		@Override
		public Integer next() {
			TreeNode tn=stack.pop();
			addLeftChild(tn.right);
			return tn.value;      
		}
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}

	static class BST implements Iterable<Integer> {

		TreeNode root;

		@Override
		public Iterator<Integer> iterator() {
			return new BSTIter(root);
		}

		public  void add(int value){
			if(root==null)
			{
				root=new TreeNode(value);
			}
			else{
				if(root.value>value)
					root.left= addUtil(root.left,value);    
				else  if(root.value<value)
					root.right=addUtil(root.right,value); 
			}

		}
		public TreeNode addUtil(TreeNode tn,int value){
			if(tn==null)
			{
				tn=new TreeNode(value);
				return tn;
			}
			else{
				if(tn.value>value)
				{
					tn.left=addUtil(tn.left,value);
				}
				else if(tn.value<value)
				{
					tn.right=addUtil(tn.right,value);
				}
			}
			return tn;
		}

		public void print() {
			print(root);
		}

		private void print(TreeNode node) {
			if (node == null) {
				return;
			}

			print(node.left);
			System.out.println(node.value);
			print(node.right);
		}
	}
}
