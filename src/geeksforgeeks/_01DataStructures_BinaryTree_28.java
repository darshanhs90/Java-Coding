package geeksforgeeks;

import geeksforgeeks._01DataStructures_BinaryTree_00.Node;
import ctci._05queue;



/*
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level/
 * Connect nodes at same level
 */;
 public class _01DataStructures_BinaryTree_28 {
	 public static void main(String[] args) {
		 _01DataStructures_BinaryTree_00 binaryTree1=new _01DataStructures_BinaryTree_00();
		 binaryTree1.insert(null,null,1);
		 binaryTree1.insert(1,"left",2);
		 binaryTree1.insert(1,"right",3);
		 binaryTree1.insert(2,"left",4);
		 binaryTree1.insert(2,"right",5);
		 binaryTree1.insert(3,"right",6);
		 binaryTree1.preOrder();
		 connectNodes(binaryTree1);
		 printConnections(binaryTree1);
	 }

	 private static void printConnections(
			 _01DataStructures_BinaryTree_00 binaryTree1) {
		 printConnections(binaryTree1.rootNode);
	 }

	 private static void printConnections(
			 geeksforgeeks._01DataStructures_BinaryTree_00.Node node) {
		 if(node!=null)
		 {	
			 System.out.print(node.data+",");
			 Node mainNode=node;
			 while(mainNode.nextRight!=null){
				 System.out.print(mainNode.nextRight.data+",");
				 mainNode=mainNode.nextRight;
			 }
			 if(node.left!=null)
				 printConnections(node.left);
			 else if(node.right!=null)
				 printConnections(node.right);
		 }

	 }

	 private static void connectNodes(_01DataStructures_BinaryTree_00 binaryTree1) {
		 leveOrderTraversal(binaryTree1.rootNode);
		 System.out.println();
	 }

	 private static void leveOrderTraversal(Node node) {
		 if(node!=null){
			 tempQueue1 queue=new tempQueue1();
			 _05queue levelsQueue=new _05queue();
			 Node n=node;
			 int mainlevel=1,level=1;
			 while(n!=null){
				 System.out.print(n.data+"/"+level+",");
				 if(n.left!=null){
					 queue.add(n.left);
					 levelsQueue.add(getLevel(node,n.left));
				 }
				 if(n.right!=null){
					 queue.add(n.right);
					 levelsQueue.add(getLevel(node,n.right));
				 }

				 level=levelsQueue.poll();
				 Node temp=n;
				 n=queue.poll();
				 if(level==mainlevel)
					 temp.nextRight=n;
				 else
					 mainlevel=level;
			 }
		 }

	 }

	 private static int getLevel(
			 geeksforgeeks._01DataStructures_BinaryTree_00.Node node,
			 geeksforgeeks._01DataStructures_BinaryTree_00.Node left) {

		 return getLevel(node,left.data,1);
	 }

	 private static int getLevel(
			 geeksforgeeks._01DataStructures_BinaryTree_00.Node node,
			 Integer data, int level) {
		 if(node==null)
			 return 0;
		 if(node.data==data)
			 return level;
		 int downLevel=getLevel(node.left,data,level+1);
		 if(downLevel!=0)
			 return downLevel;
		 downLevel=getLevel(node.right,data,level+1);
		 return downLevel;

	 }


 }
 class tempQueue1 {
	 Node headNode;
	 Node exitNode;
	 int noOfElements=0;
	 public _01DataStructures_BinaryTree_00.Node poll(){//Retrieves and removes the head of this queue, or returns null if this queue is empty.
		 _01DataStructures_BinaryTree_00.Node returnData=null;
		 if(headNode!=null)
		 {
			 returnData=headNode.data;
			 headNode=headNode.next;
			 noOfElements--;
		 }
		 return returnData;
	 }
	 public _01DataStructures_BinaryTree_00.Node peek(){//Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
		 if(headNode!=null)
			 return headNode.data;
		 return null;
	 }
	 public Boolean isEmpty(){
		 return noOfElements==0?true:false;
	 }
	 public void clear(){
		 noOfElements=0;
		 headNode=exitNode=null;
	 }
	 public void add(_01DataStructures_BinaryTree_00.Node value){
		 if(headNode==null){
			 headNode=new Node();
			 headNode.data=value;
			 exitNode=headNode;
		 }
		 else{
			 Node newNode=new Node();
			 newNode.data=value;
			 exitNode.next=newNode;
			 exitNode=newNode;
		 }
		 noOfElements++;
	 }
	 public _01DataStructures_BinaryTree_00.Node remove(){//Retrieves and removes the head of this queue. This method differs from poll only in that it throws an exception if this queue is empty.
		 _01DataStructures_BinaryTree_00.Node returnData=null;
		 if(headNode!=null)
		 {
			 returnData=headNode.data;
			 headNode=headNode.next;
			 noOfElements--;
		 }
		 return returnData;
	 }
	 public Boolean contains(_01DataStructures_BinaryTree_00.Node value){
		 Node pointerNode=new Node();
		 pointerNode=headNode;
		 while(pointerNode!=null){
			 if(pointerNode.data==value)
				 return true;
			 pointerNode=pointerNode.next;
		 }
		 return false;
	 }
	 public int size(){
		 return noOfElements;
	 }
	 public String toString(){
		 StringBuilder outputStringBuilder=new StringBuilder();
		 Node pointerNode=new Node();
		 pointerNode=headNode;
		 while(pointerNode!=null){
			 outputStringBuilder.append(pointerNode.data+"\n");
			 pointerNode=pointerNode.next;
		 }
		 return outputStringBuilder.toString();
	 }




	 class Node{
		 _01DataStructures_BinaryTree_00.Node data;
		 Node next;
		 Integer level=0;
		 public _01DataStructures_BinaryTree_00.Node getData() {
			 return data;
		 }
		 public void setData(_01DataStructures_BinaryTree_00.Node data) {
			 this.data = data;
		 }
		 public Node getNext() {
			 return next;
		 }
		 public void setNext(Node next) {
			 this.next = next;
		 }

	 }
 }
