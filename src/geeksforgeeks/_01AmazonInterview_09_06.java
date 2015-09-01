package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8-2/
 *  Given a Singly Linked List which contains integers,
 *   bring odd values in the beginning and even values at the end.
 *    The relative order of odd values, and that of even values should be maintained as it is.
 */;
 public class _01AmazonInterview_09_06 {
	 public static void main(String[] args) {
		 Scanner scanner=new  Scanner(new InputStreamReader(System.in));
		 Integer size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 LinkedList<Integer> inputList=new LinkedList<Integer>();
		 for (int i = 0; i < size; i++) {
			 inputList.add(new Random().nextInt(size*3));
		 }
		 printList(inputList);
		 inputList=reorderList(inputList);
		 printList(inputList);

	 }

	 private static LinkedList<Integer> reorderList(LinkedList<Integer> inputList) {
		LinkedList<Integer> outputList=new LinkedList<Integer>();
		for (int i = 0; i < inputList.size(); i++) {
			int element=inputList.get(i);
			if(element%2!=0)
				outputList.add(element);
		}
		for (int i = 0; i < inputList.size(); i++) {
			int element=inputList.get(i);
			if(element%2==0)
				outputList.add(element);
		}
		return outputList;
	}

	private static void printList(LinkedList<Integer> inputList) {
		 // TODO Auto-generated method stub
		 for (int i = 0; i < inputList.size(); i++) {
			 System.out.print(inputList.get(i)+",");
		 }
		 System.out.println();
	 }


 }