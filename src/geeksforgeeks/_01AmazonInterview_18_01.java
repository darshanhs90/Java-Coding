package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-18/
 * Binary complement of a number.
 */;
 public class _01AmazonInterview_18_01 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int inputNumber=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 String binaryInput=Integer.toBinaryString(inputNumber);
		 System.out.println(binaryInput);
		 binaryInput= binaryInput.replace('1','2');
		 binaryInput=binaryInput.replace('0','1');
		 binaryInput=binaryInput.replace('2','0');
		 System.out.println(binaryInput); 
	 }
 }