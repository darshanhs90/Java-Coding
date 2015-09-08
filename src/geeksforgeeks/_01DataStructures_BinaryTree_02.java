package geeksforgeeks;

import geeksforgeeks.BinaryTree2.Node;



/*
 * http://www.geeksforgeeks.org/write-c-code-to-determine-if-two-trees-are-identical/
 * Write C Code to Determine if Two Trees are Identical
 */;
 public class _01DataStructures_BinaryTree_02 {
	 public static void main(String[] args) {
		 BinaryTree2 binaryTree1=new BinaryTree2();
		 binaryTree1.insert(null,null,10);
		 binaryTree1.insert(10,"left",11);
		 binaryTree1.insert(10,"right",12);
		 binaryTree1.insert(11,"left",13);
		 binaryTree1.insert(11,"right",14);
		 binaryTree1.insert(12,"left",15);
		 binaryTree1.insert(12,"right",16);
		 binaryTree1.preOrder();
		 BinaryTree2 binaryTree2=new BinaryTree2();
		 binaryTree2.insert(null,null,10);
		 binaryTree2.insert(10,"left",11);
		 binaryTree2.insert(10,"right",12);
		 binaryTree2.insert(11,"left",13);
		 binaryTree2.insert(11,"right",14);
		 binaryTree2.insert(12,"left",15);
		 binaryTree2.insert(12,"right",18);
		 binaryTree1.preOrder();
		 System.out.println(checkTree(binaryTree1,binaryTree2));
	 }

	 private static boolean checkTree(BinaryTree2 binaryTree1,
			 BinaryTree2 binaryTree2) {
		 if(binaryTree1.size()==0 || binaryTree2.size()==0||binaryTree1.size()!=binaryTree2.size())
			 return false;
		 else
			 return checkTree(binaryTree1.rootNode,binaryTree2.rootNode);
	 }

	 private static boolean checkTree(Node node1, Node node2) {
		 if(node1!=null && node2!=null){
			 boolean b1=(node1.data==node2.data);
			 boolean b2=checkTree(node1.left,node2.left);
			 boolean b3=checkTree(node1.right,node2.right);
			 return (b1&&b2&&b3);
		 }
		 else if(node1!=null && node2==null || node1==null && node2!=null){
			 return false;
		 }
		 else
			 return true;
	 }
 }
 class BinaryTree2{
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
