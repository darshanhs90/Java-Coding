package geeksforgeeks;

import java.util.Arrays;
import java.util.LinkedList;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-12/
 * Linked list is given as below (with elements as 1, 2 and 3), sort this in one pass.
 * 3->2->2->1->2->3->1
 */;
 public class _01AmazonInterview_12_03 {
	 public static void main(String[] args) {
		 LinkedList<Integer> linkedList=new LinkedList<Integer>();
		 linkedList.add(3);
		 linkedList.add(2);
		 linkedList.add(2);
		 linkedList.add(1);
		 linkedList.add(2);
		 linkedList.add(3);
		 linkedList.add(1);
		 System.out.println(Arrays.toString(linkedList.toArray()));
		 int oneCount=0,twoCount=0,threeCount=0;
		 for (int i = 0; i < linkedList.size(); i++) {
			 if(linkedList.get(i)==1)
				 oneCount++;
			 else if(linkedList.get(i)==2)
				 twoCount++;
			 else
				 threeCount++;
		 }
		 linkedList.clear();
		 for (int i = 0; i < oneCount; i++) {
			 linkedList.add(1);
		 } 
		 for (int i = 0; i < twoCount; i++) {
			 linkedList.add(2);
		 } 
		 for (int i = 0; i < threeCount; i++) {
			 linkedList.add(3);
		 } 	 
		 System.out.println(Arrays.toString(linkedList.toArray()));
	 }
 }