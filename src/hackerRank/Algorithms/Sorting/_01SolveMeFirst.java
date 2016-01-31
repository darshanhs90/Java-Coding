package hackerRank.Algorithms.Sorting;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/tutorial-intro
 */
public class _01SolveMeFirst {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int V=Integer.parseInt(scanner.nextLine());
		int n=Integer.parseInt(scanner.nextLine());
		String inputArray[]=scanner.nextLine().split(" ");
		for (int i = 0; i < inputArray.length; i++) {
			if(Integer.parseInt(inputArray[i])==V)
			{
				System.out.println(i);
				break;
			}
		}
	}
}
