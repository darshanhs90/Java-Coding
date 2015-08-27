package ctci;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



/*Implementation of Binary Search Tree */
public class _10BinarySearchTree{
	private Node rootNode,searchedNode;
	private int noOfElements=0;
	public _10BinarySearchTree() {
	}
	public void insert(int value){
		if(rootNode==null){
			rootNode=new Node(value, null, null);
		}
		else{
			insert(rootNode,value);
		}
		noOfElements++;
	}
	private Node insert(Node node,int value){
		if(node==null){
			node=new Node(value, null, null);
			return node;
		}
		else{
			if(node.data>value){
				node.left=insert(node.left,value);
			}
			else if(node.data<value){
				node.right=insert(node.right,value);
			}
			return node;
		}
	}
	public void preOrder(){
		System.out.println("********Pre order Starts**********");
		preOrder(rootNode);
		System.out.println("*********Pre order Ends***********");
	}
	private void preOrder(Node node){
		if(node!=null){
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	public void inOrder(){
		System.out.println("********In order Starts**********");
		inOrder(rootNode);
		System.out.println("*********In order Ends***********");
	}
	private void inOrder(Node node){
		if(node!=null){
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	public void postOrder(){		
		System.out.println("********Post order Starts**********");
		postOrder(rootNode);
		System.out.println("*********Post order Ends***********");
	}
	private void postOrder(Node node){
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
		}
	}
	public void delete(int value){
		if(delete(rootNode,value)!=null)
			noOfElements--;
	}
	private Node delete(Node node,int value){
		if(node==null)
			return node;

		if(node.data>value)
			node.left=delete(node.left,value);
		else if(node.data<value)
			node.right=delete(node.right,value);
		else if(node.left!=null && node.right!=null){
			node.data=findMinimum(node.right).data;
			node.right=delete(node.right,node.data);
		}
		else
		{
			node=(node.left!=null)?node.left:node.right;
		}
		return node;
	}
	private Node findMinimum(Node node) {
		if(node.left==null)
			return node;
		else
			return findMinimum(node.left);
	}
	private void searchNode(Node node,int value) {
		if(node!=null && node.data>value){
			searchNode(node.left,value);
		}
		else if(node!=null && node.data<value){
			searchNode(node.right,value);
		}else{
			searchedNode=node;
		}
	}
	public boolean search(int value){
		searchedNode=null;
		searchNode(rootNode,value);
		if(searchedNode!=null)
			return true;
		return  false;
	}
	public int size(){
		return noOfElements;
	}
	public int height(){

		return height(rootNode);

	}

	private int height(Node node) {
		if(node==null)
			return 0;

		int leftDepth=height(node.left);
		int rightDepth=height(node.right);
		if(leftDepth>rightDepth)
			return leftDepth+1;
		else
			return rightDepth+1;
	}

	public void bfs(){
		bfs(rootNode);
	}
	
	public void dfs(){
		dfs(rootNode);
	}
	
	private void dfs(Node node){//to be checked later
		preOrder();
	}
	

	
	private void bfs(Node node){//same as levelorder
		Queue<Node> q=new Queue<_10BinarySearchTree.Node>() {
			int noOfElements=0;
			LinkedList<Node> l=new LinkedList<Node>();
			@Override
			public int size() {
				// TODO Auto-generated method stub
				return 0;
			}

			@Override
			public boolean isEmpty() {
				return (noOfElements==0)?true:false;
			}

			@Override
			public boolean containsAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean addAll(Collection<? extends Node> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean removeAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean retainAll(Collection<?> c) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public void clear() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public boolean add(Node e) {
				l.add(e);
				noOfElements++;
				return true;
			}

			

			@Override
			public Node remove() {
				noOfElements--;
				return l.removeFirst();
			}

			@Override
			public boolean contains(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Iterator<Node> iterator() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object[] toArray() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public <T> T[] toArray(T[] a) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean remove(Object o) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public boolean offer(Node e) {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public Node poll() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Node element() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Node peek() {
				// TODO Auto-generated method stub
				return null;
			}

			
		};
		q.add(rootNode);
		Node n;
		while(!q.isEmpty()){
			n=q.remove();
			if(n!=null){
				System.out.println(n.data);
				if(n.left!=null)
					q.add(n.left);
				if(n.right!=null)
					q.add(n.right);
			}
		}
	}

	







	class Node{
		int data;
		Node left=null;
		Node right=null;
		boolean visited=false;
		public Node(int data,Node left,Node right) {
			this.data=data;
			this.left=left;
			this.right=right;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}

	}
}
