package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8-2/
 * A sentence is given which contains lowercase English letters and spaces. 
 * It may contain multiple spaces. Get first letter of every word and return the result as a string
 * The result should not contain any space
 */;
 public class _01AmazonInterview_09_01 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();
		 scanner.close();
		 inputString = inputString.trim().replaceAll(" +", " ");
		 System.out.println(inputString);
		 System.out.println(getFirstCharacters(inputString));
	 }

	private static String getFirstCharacters(String inputString) {
		String inputStringArray[]=inputString.split(" ");
		String outputString="";
		for (int i = 0; i < inputStringArray.length; i++) {
			outputString+=inputStringArray[i].charAt(0);
		}
		return outputString;
	}
 }