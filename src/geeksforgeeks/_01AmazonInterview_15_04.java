package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-16/
 * Given a character array find the first element that repeats itself.
 */;
 public class _01AmazonInterview_15_04 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();
		 scanner.close();
		 System.out.println(findRepeatingElementMap(inputString));

	 }
	 private static String findRepeatingElementMap(String inputString) {
		 HashMap<Character,Character> elementMap=new HashMap<Character, Character>();
		 for (int i = 0; i < inputString.length(); i++) {
			 char element=inputString.charAt(i);
			 if(elementMap.containsKey(element))
				 return element+" ";
			 else{
				 elementMap.put(element,element);
			 }
		 }
		 return "No Element is repeating";
	 }


 }