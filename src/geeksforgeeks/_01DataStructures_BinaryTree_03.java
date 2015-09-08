package geeksforgeeks;

/*
 * http://www.geeksforgeeks.org/write-a-c-program-to-find-the-maximum-depth-or-height-of-a-tree/
 * Write a C Program to Find the Maximum Depth or Height of a Tree
 */;
 public class _01DataStructures_BinaryTree_03 {
	 public static void main(String[] args) {
		 BinaryTree3 binaryTree1=new BinaryTree3();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",11);
		 binaryTree1.insert(10,"right",12);
		 binaryTree1.insert(11,"left",13);
		 binaryTree1.insert(11,"right",14);
		 binaryTree1.insert(12,"left",15);
		 binaryTree1.insert(12,"right",16);
		 binaryTree1.insert(16,"right",17);		
		 binaryTree1.insert(17,"right",18);
		 binaryTree1.preOrder();
		 System.out.println(getMaxDepth(binaryTree1));
	 }

	 private static int getMaxDepth(BinaryTree3 binaryTree1) {
		 if(binaryTree1.size()==0)
			 return 0;
		 else
			 return getMaxDepth(binaryTree1.rootNode);
	 }

	 private static Integer getMaxDepth(geeksforgeeks.BinaryTree3.Node node) {
		 if(node==null)
		 {
			 return 0;
		 }
		 else{
			 int left=getMaxDepth(node.left);
			 int right=getMaxDepth(node.right);
			 return (left>right)?left+1:right+1;
		 }
	 }

 }
 class BinaryTree3{
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
