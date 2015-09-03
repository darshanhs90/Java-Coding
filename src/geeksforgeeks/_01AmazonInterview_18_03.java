package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;



/*
 * http://www.geeksforgeeks.org/amazon-interview-set-18/
 * Permutation of a string with and without repetition of characters.
 */;
 public class _01AmazonInterview_18_03 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();
		 scanner.close();
		 printPermutations(inputString);
		 System.out.println();
		 printNonRepeatedPermutations(inputString);
		 
	 }

	private static void printNonRepeatedPermutations(String inputString) {
		String outputString="";
		HashMap<Character,Integer> elementMap=new HashMap<Character, Integer>();
		for (int i = 0; i < inputString.length(); i++) {
			Character elementChar=inputString.charAt(i);
			if(!elementMap.containsKey(elementChar)){
				elementMap.put(elementChar,1);
				outputString+=elementChar;
			}

		}
		printPermutations(outputString);
		
	}
	public static void printPermutations(String str) { 
		printPermutations("", str); 
	}
	
	private static void printPermutations(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++)
	        	printPermutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	    }
	}
 }