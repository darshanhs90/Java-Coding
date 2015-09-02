package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-12/
 *  An expression is given.
 * [] can enclosed [], {} and ()
 * {} can enclosed {}, ()
 * () can enclosed only ()
 * Check that brackets in the expression are valid or not according to enclosing condition and opening closing condition.
 */;
 public class _01AmazonInterview_12_04 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputString=scanner.nextLine();
		 scanner.close();
		 System.out.println(inputString);
		 System.out.println("Input string balance condition ? "+checkBalance(inputString));
	 }

	 private static boolean checkBalance(String inputString) {
		 Boolean flowerBrace=false,squareBrace=false,smallBrace=false;
		 int squareCounter=0,flowerCounter=0,smallCounter=0;
		 for (int i = 0; i < inputString.length(); i++) {
			 char character=inputString.charAt(i);
			 if(character=='['){
				 if(flowerBrace||smallBrace)
					 return false;
				 squareBrace=true;
				 squareCounter++;
			 }else if(character=='{'){
				 if(smallBrace)
					 return false;
				 flowerBrace=true;
				 flowerCounter++;
			 }else if(character=='('){
				 smallBrace=true;
				 smallCounter++;
			 }else if(character==']'){
				 squareCounter--;
				 if(squareCounter==0)
					 squareBrace=false;
			 }else if(character=='}'){
				 flowerCounter--;
				 if(flowerCounter==0)
					 flowerBrace=false;
			 }else if(character==')'){
				 smallCounter--;
				 if(smallCounter==0)
					 smallBrace=false;
			 }

		 }
		 return (smallCounter==0 && flowerCounter==0 && squareCounter==0)?true:false;
	 }
 }