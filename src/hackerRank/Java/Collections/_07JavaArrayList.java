package hackerRank.Java.Collections;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Link:https://www.hackerrank.com/challenges/java-arraylist
 */

public class _07JavaArrayList {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int noOfLists=Integer.parseInt(scanner.nextLine());
		ArrayList<ArrayList<Integer>> numberList=new ArrayList<>();
		for(int i=0;i<noOfLists;i++){
			ArrayList<Integer> list=new ArrayList<>();
			String inputArray[]=scanner.nextLine().split(" ");
			for (int j = 0; j < inputArray.length; j++) {
				list.add(Integer.parseInt(inputArray[j]));
			}
			numberList.add(list);
		}
		int noOfTestCases=Integer.parseInt(scanner.nextLine());
		for (int i = 0; i < noOfTestCases; i++) {
			int x=scanner.nextInt();
			int y=scanner.nextInt();
			if(numberList.size()-1<x)
			{
				System.out.println("ERROR!");
			}
			else{
				ArrayList<Integer> list=numberList.get(x-1);
				if(list.size()-1<y)
				{
					System.out.println("ERROR!");
				}
				else{
					System.out.println(list.get(y));
				}
			}
		}
	}
}