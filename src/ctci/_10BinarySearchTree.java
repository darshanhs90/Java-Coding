package ctci;



/*Implementation of CTCI */
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

	class Node{
		int data;
		Node left=null;
		Node right=null;
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
