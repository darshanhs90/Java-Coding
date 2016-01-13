package hackerRank.Algorithms.Strings;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
/*
 * Link:https://www.hackerrank.com/challenges/funny-string
*/
public class _02FunnyString {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String inputString=scanner.nextLine();
			boolean continueNext=true;
			int length=inputString.length();
			ArrayList<Integer> differenceList=new ArrayList<>();
			for (int j = 0; j < inputString.length()-1; j++) {
				differenceList.add(inputString.charAt(j)-inputString.charAt(j+1));
			}
			int counter=0;
			for (int j = inputString.length()-1; j >0; j--) {
				int difference=inputString.charAt(j)-inputString.charAt(j-1);
				if(Math.abs(difference)!=Math.abs(differenceList.get(counter)))
				{
					continueNext=false;
					break;
				}
				counter++;
			}
			if(continueNext)
				System.out.println("Funny");
			else
				System.out.println("Not Funny");
		}
	}
}
