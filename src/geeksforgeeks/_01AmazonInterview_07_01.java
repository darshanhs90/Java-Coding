package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-2/
 * Given two strings, write a function to remove all characters in one string which are present in other string
 * 
 */;
public class _01AmazonInterview_07_01 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		String inputString1=scanner.nextLine();
		String inputString2=scanner.nextLine();
		scanner.close();
		System.out.println("Output string is : "+replaceElements(inputString1,inputString2));
	}

	private static String replaceElements(String inputString1,
			String inputString2) {
		while(inputString1.length()!=0){
		String replaceElement=inputString1.charAt(0)+"";
		inputString2=inputString2.replaceAll(replaceElement,"");
		inputString1=inputString1.replaceAll(replaceElement,"");
		}
		return inputString2;
	}

}