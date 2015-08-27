package ctci;



/*Implementation of CTCI */
public class _14Traversals{

	public void preOrder(Node node){
		if(node!=null){
			System.out.println(node.data);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	public void inOrder(Node node){
		if(node!=null){
			inOrder(node.left);
			System.out.println(node.data);
			inOrder(node.right);
		}
	}
	public void postOrder(Node node){
		if(node!=null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.data);
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