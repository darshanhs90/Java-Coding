package hackerRank.Java.Strings;

import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-string-token
 */

public class _05JavaStringToken {

	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String inputString=scanner.nextLine().trim();
		if(inputString.length()>0 && inputString.length()<=400000){
			String outputArray[]=(inputString.split("[^a-zA-Z]+"));
			System.out.println(outputArray.length);
			for (int i = 0; i < outputArray.length; i++) {
				System.out.println(outputArray[i]);
			}
		}
		else if(inputString.length()==0)
			System.out.println("0");
	}
}
