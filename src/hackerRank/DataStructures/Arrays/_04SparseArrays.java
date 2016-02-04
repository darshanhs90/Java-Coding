package hackerRank.DataStructures.Arrays;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/sparse-arrays
 */


public class _04SparseArrays {
	public static void main(String[] args) {

		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int noOfStrings=Integer.parseInt(scanner.nextLine());
		HashMap<String, Integer> stringCount=new HashMap<>();
		for (int i = 0; i < noOfStrings; i++) {
			String inputString=scanner.nextLine();
			if(stringCount.containsKey(inputString))
			{
				stringCount.put(inputString, stringCount.get(inputString)+1);
			}
			else{
				stringCount.put(inputString,1);
			}
		}
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			String testInput=scanner.nextLine();
			if(stringCount.containsKey(testInput))
				System.out.println(stringCount.get(testInput));
			else
				System.out.println("0");
		}
	}
}
