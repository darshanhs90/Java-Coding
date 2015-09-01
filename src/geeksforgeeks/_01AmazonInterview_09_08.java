package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8-2/
 * Find integer value of sqrt(N). Do not use any library functions or any mathematical solution.
 */;
 public class _01AmazonInterview_09_08 {
	 public static void main(String[] args) {
		 Scanner scanner=new  Scanner(new InputStreamReader(System.in));
		 Integer inputValue=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int value=1;
		  while((value*value)<inputValue){
			  value++;
		  }
		  System.out.println(value-1);
		  System.out.println(Math.sqrt(inputValue));
		  System.out.println(Math.exp(Math.log(inputValue)/2));
	 }
 }