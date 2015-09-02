package geeksforgeeks;

import ctci._02linkedList;
import ctci._02linkedList.Node;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-11/
 * Program to swap the kth node from end and kth node from front
 */;
 public class _01AmazonInterview_11_05 {
	 public static void main(String[] args) {
		 _02linkedList linkedList=new _02linkedList();
		 linkedList.add(10);
		 linkedList.add(11);
		 linkedList.add(12);
		 linkedList.add(13);
		 linkedList.add(14);
		 linkedList.add(15);
		 linkedList.add(16);
		 linkedList.add(17);
		 linkedList.add(18);
		 linkedList.add(19);
		 linkedList.add(20);
		 int k=2;//2nd element from start swapped with 2nd element from end
		 System.out.println("Before : "+linkedList.toString());
		 swapElements(linkedList,k);
		 System.out.println("After : "+linkedList.toString());
	 }

	 private static void swapElements(_02linkedList linkedList, int i) {
		 // TODO Auto-generated method stub
		 Node forwardPointer=linkedList.getHeadNode();
		 Node trailingPointer=linkedList.getHeadNode();
		 for (int j = 0; j < i; j++) {
			 forwardPointer=forwardPointer.next;
		 }
		 Node startElementNode=forwardPointer;
		 while(forwardPointer!=null){
			 forwardPointer=forwardPointer.next;
			 trailingPointer=trailingPointer.next;
		 }
		 trailingPointer.data=trailingPointer.data^startElementNode.data;
		 startElementNode.data=trailingPointer.data^startElementNode.data;
		 trailingPointer.data=trailingPointer.data^startElementNode.data;
	 }
 }