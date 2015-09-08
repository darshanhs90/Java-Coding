package geeksforgeeks;



/*
 * http://www.geeksforgeeks.org/618/
 * Tree Traversals
 */;
 public class _01DataStructures_BinaryTree_01 {
	 public static void main(String[] args) {
		 BinaryTree1 binaryTree=new BinaryTree1();
		 binaryTree.insert(null,null,10);
		 binaryTree.insert(10,"left",11);
		 binaryTree.insert(10,"right",12);
		 binaryTree.insert(11,"left",13);
		 binaryTree.insert(11,"right",14);
		 binaryTree.insert(12,"left",15);
		 binaryTree.insert(12,"right",16);
		 binaryTree.preOrder();
		 binaryTree.inOrder();
		 binaryTree.postOrder();
	 }
 }
 class BinaryTree1{
	 Node rootNode,presentNode;
	 public void insert(Integer element,String type,int data){
		 if(rootNode==null){
			 rootNode=new Node(data,null,null);
		 }
		 else{
			 if(type.toLowerCase().contentEquals("left")){
				 setLeftChild(element,data);
			 }
			 else{
				 setRightChild(element,data);
			 }
		 }
	 }
	 public void postOrder() {
		 postOrder(rootNode);
		 System.out.println();
	 }
	 private void postOrder(Node n) {
		 if(n!=null){
			 postOrder(n.left);
			 postOrder(n.right); 
			 System.out.print(n.data+",");
		 }
	 }
	 public void inOrder() {
		 inOrder(rootNode);
		 System.out.println();
	 }
	 private void inOrder(Node n) {
		 if(n!=null){
			 inOrder(n.left);			
			 System.out.print(n.data+",");
			 inOrder(n.right); 
		 }
	 }
	 public void setLeftChild(int element,int data){
		 preOrderGetNode(element);
		 if(presentNode!=null)
		 {
			 if(presentNode.left==null){
				 presentNode.left=new Node(data,null,null);
			 }
		 }
	 }
	 public void setRightChild(int element,int data){
		 preOrderGetNode(element);
		 if(presentNode!=null)
		 {
			 if(presentNode.right==null){
				 presentNode.right=new Node(data,null,null);
			 }
		 }
	 }
	 public boolean search(int data){
		 presentNode=null;
		 preOrderGetNode(data);
		 return presentNode==null?false:true;
	 }
	 public void preOrder(){
		 preorder(rootNode);
		 System.out.println();
	 }
	 private void preorder(Node n){
		 if(n!=null){			 
			 System.out.print(n.data+",");
			 preorder(n.left);
			 preorder(n.right);
		 }
	 }

	 public void preOrderGetNode(int data){
		 presentNode=null;
		 preOrderGetNode(rootNode,data);
	 }
	 public void preOrderGetNode(Node n,int data){
		 if(n!=null){
			 if(n.data==data){
				 presentNode=n;
				 return;
			 }
			 preOrderGetNode(n.left,data);
			 preOrderGetNode(n.right,data);
		 }

	 }
	 class Node{
		 int data;
		 Node left,right;
		 public Node(int data,Node left,Node right) {
			 this.data=data;
			 this.left=left;
			 this.right=right;
		 }
	 }
 }
