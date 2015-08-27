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
	public boolean delete(int value){
		searchedNode=null;
		searchNode(rootNode,value);
		if(searchedNode!=null)
		{
			if(searchedNode.right!=null){
				searchedNode.data=searchedNode.right.data;
				searchedNode=searchedNode.right;
				searchedNode.right=null;
			}
			else{
				searchedNode=searchedNode.left;
				searchedNode.data=searchedNode.left.data;
			}
			noOfElements--;
			return true;
		}
		return  false;
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
		return 0;
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
