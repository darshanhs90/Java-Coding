package geeksforgeeks;

import ctci._02linkedList;
import ctci._02linkedList.Node;



/*
 * http://www.geeksforgeeks.org/amazon-interview-set-30/
 * Given a string in the form of a Linked List,
 * check whether the string is palindrome or not. Don’t use extra memory. 
 */;
 public class _01AmazonInterview_30_01 {
	 static Node headNode;
	 public static void main(String[] args) {
		 _02linkedList linkedList=new _02linkedList();
		 linkedList.add(1);
		 linkedList.add(2);
		 linkedList.add(3);
		 linkedList.add(4);
		 linkedList.add(3);
		 linkedList.add(2);
		 linkedList.add(1);
		 System.out.println(checkForPalindrome(linkedList));
		 linkedList=new _02linkedList();
		 linkedList.add(1);
		 linkedList.add(2);
		 linkedList.add(3);
		 linkedList.add(4);
		 linkedList.add(5);
		 linkedList.add(2);
		 linkedList.add(1);
		 System.out.println(checkForPalindrome(linkedList));
	 }

	 private static boolean checkForPalindrome(_02linkedList linkedList) {
		 headNode=linkedList.getHeadNode();
		 return IsPalindrome(headNode);
	 }

	 private static boolean IsPalindrome(Node headerNode) {
		 boolean check=false;
		 if(headerNode!=null){
			 check=IsPalindrome(headerNode.next);
		 }else{
			 return true;
		 }
		 if(check){
			 if(headerNode.data==headNode.data){
				 headNode=headNode.next;
				 return true;
			 }
			 else{
				 return false;
			 }
		 }
		 return check;
	 }
 }