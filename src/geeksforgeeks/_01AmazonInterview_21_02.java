package geeksforgeeks;

import java.math.BigInteger;

import ctci._02linkedList;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-21/
 * Two numbers represented as linked lists. (Bigger than integers). Return a linked list which is the product of the given two linked lists.
 * 1->2->3->Null (123)
 * 2->3-Null (23)
 */;
 public class _01AmazonInterview_21_02 {
	 public static void main(String[] args) {
		 _02linkedList inputNumber1=new  _02linkedList();
		 inputNumber1.add(2);
		 inputNumber1.add(1);
		 inputNumber1.add(4);
		 inputNumber1.add(5);
		 inputNumber1.add(6);
		 inputNumber1.add(7);
		 inputNumber1.add(8);
		 inputNumber1.add(6);
		 inputNumber1.add(4);
		 inputNumber1.add(8);
		 _02linkedList inputNumber2=new  _02linkedList();
		 inputNumber2.add(2);
		 inputNumber2.add(1);
		 inputNumber2.add(4);
		 inputNumber2.add(5);
		 inputNumber2.add(6);
		 inputNumber2.add(7);
		 inputNumber2.add(8);
		 inputNumber2.add(6);
		 inputNumber2.add(4);
		 inputNumber2.add(8);
		 _02linkedList outputNumber=new  _02linkedList();
		 StringBuffer sb=new StringBuffer();
		 for (int i = 0; i < inputNumber1.size(); i++) {
			 sb.append(inputNumber1.get(i));
		 }
		 BigInteger firstNumber=new BigInteger(sb.toString());
		 sb=new StringBuffer();
		 for (int i = 0; i < inputNumber2.size(); i++) {
			 sb.append(inputNumber2.get(i));
		 }
		 BigInteger secondNumber=new BigInteger(sb.toString());
		 System.out.println(firstNumber);
		 System.out.println(secondNumber);
		 secondNumber=secondNumber.multiply(firstNumber);
		 System.out.println(secondNumber);
		 String secondNumberArray[]=secondNumber.toString().split("");
		 for (int i = 1; i < secondNumberArray.length; i++) {
			 outputNumber.add(Integer.parseInt(secondNumberArray[i]));
		 }
		 System.out.println(outputNumber.toString());
	 }



 }