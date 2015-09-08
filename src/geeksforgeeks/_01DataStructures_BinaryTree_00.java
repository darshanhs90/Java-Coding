package geeksforgeeks;




/*
 * http://www.geeksforgeeks.org/618/
 * Tree Traversals
 */;
 public class _01DataStructures_BinaryTree_00 {
	 Node rootNode,presentNode;
	 int noOfElements=0;
	 public void insert(Integer element,String type,int data){
		 if(rootNode==null){
			 rootNode=new Node(data,null,null);
			 noOfElements++;
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
				 noOfElements++;
			 }
		 }
	 }
	 public void setRightChild(int element,int data){
		 preOrderGetNode(element);
		 if(presentNode!=null)
		 {
			 if(presentNode.right==null){
				 presentNode.right=new Node(data,null,null);
				 noOfElements++;
			 }
		 }
	 }
	 public int size(){
		 return noOfElements;
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
			 if(n.data!=null)//not needed,needed only for tree deletion
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
		 Integer data;
		 Node left,right;
		 public Node(Integer data,Node left,Node right) {
			 this.data=data;
			 this.left=left;
			 this.right=right;
		 }
	 }
 }
