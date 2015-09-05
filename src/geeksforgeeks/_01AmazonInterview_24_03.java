package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * http://www.geeksforgeeks.org/amazon-interview-set-24/
 * Given a number is it divisible by 3 and 5
 */;
 public class _01AmazonInterview_24_03 {
	 public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		Integer inputNumber=Integer.parseInt(scanner.nextLine());
		scanner.close();
		System.out.println(checkNumber(inputNumber));
	 }

	private static boolean checkNumber(Integer inputNumber) {
		// TODO Auto-generated method stub
		if(checkDivisibleBy3(inputNumber))
			if(checkDivisibleBy5(inputNumber))
				return true;
		return false;
	}

	private static boolean checkDivisibleBy3(Integer inputNumber) {
		// TODO Auto-generated method stub
		String inputString=String.valueOf(inputNumber);
		int sum=0;
		for (int i = 0; i <inputString.length(); i++) {
			sum+=Integer.parseInt(inputString.charAt(i)+"");
		}
		if(sum%3==0)
			return true;
		return false;
	}

	private static boolean checkDivisibleBy5(Integer inputNumber) {
		// TODO Auto-generated method stub
		String inputString=String.valueOf(inputNumber);
		if(Integer.parseInt(inputString.charAt(inputString.length()-1)+"")==5 || 
				Integer.parseInt(inputString.charAt(inputString.length()-1)+"")==0)
			return true;
		return false;
	}

 }