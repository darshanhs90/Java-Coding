package yelpInterview;

import java.util.Arrays;
import java.util.Scanner;

public class _02wordsReversal {


	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in);
		String str=scanner.nextLine();
		String inputArray[]=str.split(" ");
		System.out.println(Arrays.toString(inputArray));
		StringBuilder sb=new StringBuilder();
		for (int i =inputArray.length-1; i >=0; i--) {
			if(i!=0)
				sb.append(inputArray[i]+" ");
			else 
				sb.append(inputArray[i]);
		}
		System.out.println(sb.toString());
		System.out.println(Reverse(str));
	}
	private static String Reverse(String str) {
		char charArray[] = str.toCharArray();
		for (int i = 0; i <str.length(); i++){
			if(charArray[i] == ' ')
				return Reverse(str.substring(i + 1)) + str.substring(0, i) + " ";
		}

		return str + " ";
	}
}






