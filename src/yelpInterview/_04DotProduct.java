package yelpInterview;

import java.util.HashMap;
import java.util.Scanner;

/*
 * Link:https://www.careercup.com/question?id=5678837729853440
 */
public class _04DotProduct {


	public static void main(String a[]){
		Scanner scanner=new Scanner(System.in);
		String inputArray[]=scanner.nextLine().split(" ");
		int k=Integer.parseInt(inputArray[0]);
		int n=Integer.parseInt(inputArray[1]);
		int output=0;
		HashMap<Integer, Integer> elementMap=new HashMap<>();
		for (int i = 0; i < k; i++) {
			inputArray=scanner.nextLine().split(" ");
			int key=Integer.parseInt(inputArray[0]);
			int value=Integer.parseInt(inputArray[1]);
			elementMap.put(key, value);
		}
		for (int i = 0; i < n; i++) {
			inputArray=scanner.nextLine().split(" ");
			int key=Integer.parseInt(inputArray[0]);
			int value=Integer.parseInt(inputArray[1]);
			if(elementMap.containsKey(key))	
				output+=elementMap.get(key)*value;
		}
		System.out.println(output);
	}
}






