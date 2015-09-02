package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-16/
 * Given a number with the number of digits in the range of 10-50,
 * find the next higher permutation of the number.
 * If such a number doesn’t exist, return -1.
 */;
 public class _01AmazonInterview_15_01 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String number=(scanner.nextLine());
		 scanner.close();
		 System.out.println("Number is : "+number);
		 System.out.println("Next Higher permuatation is : "+findNextHighestNumber(number));
	 }

	 private static String findNextHighestNumber(String number) {
		 if(Integer.parseInt(number)<10 || Integer.parseInt(number)>50){
			 return "Number not in range of 10-50";
		 }
		 else{
			String numberArray[]=number.split("");
			if(Integer.parseInt(numberArray[2])>4){
				return "-1";
			}
			else{
				return numberArray[2]+numberArray[1];
			}
			
		 }
	 }
 }