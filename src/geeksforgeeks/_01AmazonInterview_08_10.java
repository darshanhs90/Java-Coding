package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8/
 * given the numerator and denominator of a fraction, 
 * find the quotient and the remainder without using divide and mod (‘/’, ’%’ )operators
 */;
 public class _01AmazonInterview_08_10 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int numerator=Integer.parseInt(scanner.nextLine());
		 int denominator=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int quotient=0;
		 while(numerator>denominator){
			 quotient++;
			 numerator-=denominator;
		 }
		 if(numerator-denominator==0){
			 quotient++;
		 }
		 else{
			 numerator+=denominator;
		 }
		 int remainder=numerator-denominator;
		 System.out.println("Quotient is : "+(quotient));
		 System.out.println("Remainder is : "+remainder);
	 }
 }