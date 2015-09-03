package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

import ctci._02linkedList;
import ctci._02linkedList.Node;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-18/
 * Given a linked-list and 2 integers k & m. Reverse the linked-list till k elements
 * and then traverse till m elements and repeat.
 */;
 public class _01AmazonInterview_19_02 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 Integer linkedListSize=Integer.parseInt(scanner.nextLine());
		 Integer k=Integer.parseInt(scanner.nextLine());
		 Integer m=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 _02linkedList linkedList=new _02linkedList();
		 linkedList=buildLinkedList(linkedList,linkedListSize);
		 System.out.print(linkedList.toString());
		 linkedList=reverseElements(linkedList,k,m,linkedListSize);
		 System.out.println();
		 System.out.print(linkedList.toString());
	 }
	 

	 private static _02linkedList reverseElements(_02linkedList linkedList,
			 Integer k, Integer m, Integer linkedListSize) {
		 Node startNode=linkedList.getHeadNode();
		 Node endNode=linkedList.getHeadNode();
		 while(startNode!=null && endNode!=null){
			 Stack<Integer> stack=new Stack<Integer>();
			 for (int i = 0; i < k; i++) {
				 stack.push(startNode.data);
				 startNode=startNode.next;
				 if(startNode.next==null)
					 return linkedList;
			 }
			 for (int i = 0; i < k; i++) {
				 endNode.data=stack.pop();
				 endNode=endNode.next;
			 }
			 for (int i = 0; i < m; i++) {
				 startNode=startNode.next;
				 endNode=endNode.next; 
				 if(startNode.next==null)
					 return linkedList;
			 }
		 }
		 return linkedList;
	 }

	 private static _02linkedList buildLinkedList(_02linkedList linkedList,
			 Integer linkedListSize) {
		 for (int i = 0; i < linkedListSize; i++) {
			 linkedList.add(new Random().nextInt(linkedListSize*3));
		 }
		 return linkedList;
	 }

 }