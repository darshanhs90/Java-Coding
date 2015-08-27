package ctci;


/*Implementation of Binary Tree */
public class _09BinaryTree{
	private int noOfElements=0;
	private Node rootNode;
	private Node searchedNode;
	public int size(){
		return noOfElements;
	}
	public void insert(int value,String position,int parent){
		if(rootNode==null){
			rootNode=new Node(value, null,null);
			noOfElements++;
			return;
		}
		searchedNode=null;
		getNode(rootNode,parent);
		if(searchedNode!=null){
			if(position.toLowerCase().contentEquals("left")){
				if(searchedNode.left==null){
					searchedNode.left=new Node(value,null,null);
					noOfElements++;
				}else{
					System.out.println("Position already occupied");
				}
			}
			else{
				if(searchedNode.right==null){
					searchedNode.right=new Node(value,null,null);
					noOfElements++;
				}else{
					System.out.println("Position already occupied");
				}
			}
		}
	}

	private void getNode(Node node,int parent) {
		if(node.data==parent){
			searchedNode=node;
			return;
		}
		else{
			if(node.left!=null)
				getNode(node.left, parent);
			if(node.right!=null)
				getNode(node.right, parent);

		}

	}

	public boolean search(int value){
		searchedNode=null;
		getNode(rootNode, value);
		if(searchedNode!=null)
			return true;
		else
			return false;
	}
	public void delete(int value){
		searchedNode=null;
		getNode(rootNode, value);
		if(searchedNode!=null)
		{
			if(searchedNode.left!=null)
			{
				searchedNode.data=searchedNode.left.data;	
				searchedNode=searchedNode.left;	
				noOfElements--;
			}
			else if(searchedNode.right!=null)
			{
				searchedNode.data=searchedNode.right.data;
				searchedNode=searchedNode.right;
				noOfElements--;
			}
		}
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
