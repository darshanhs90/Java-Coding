package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * http://www.geeksforgeeks.org/amazon-interview-set-24/
 * Reverse bits in a binary
 */;
 public class _01AmazonInterview_24_04 {
	 public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer inputNumber=Integer.parseInt(scanner.nextLine());
		scanner.close();
		String binaryInput=Integer.toBinaryString(inputNumber);
		System.out.println("Output is "+reverseBits(binaryInput));
	 }

	private static String reverseBits(String binaryInput) {
		String input=(binaryInput);
		input=input.replaceAll("0","2");
		input=input.replaceAll("1","0");
		input=input.replaceAll("2","1");		
		return input;
	}

	

 }