package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-16/
 * Given an array of strings, you need to find the longest running sequence of a character
 * among all possible permutations of the strings in the array.
 * INPUT:
 * ab
 * ba
 * aac
 * OUTPUT:
 * a,3
 */;
 public class _01AmazonInterview_15_02 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int size=Integer.parseInt(scanner.nextLine());
		 String inputArray[]=new String[size];
		 for (int i = 0; i < size; i++) {
			inputArray[i]=scanner.nextLine();
		}
		 scanner.close();
		 System.out.println("Character count : "+findMostCharCount(inputArray));
	 }

	 private static String findMostCharCount(String[] inputArray) {
		 char character=' ',mainCharacter=' ';
		 int charCount=0,maxCount=0;
		 for (int i = 0; i < inputArray.length; i++) {
			String inputStringArray[]=inputArray[i].split("");
			for (int j = 1; j < inputStringArray.length; j++) {
				if(inputStringArray[j].charAt(0)==character){
					charCount++;
				}
				else{
					if(charCount>maxCount){
						maxCount=charCount;
						mainCharacter=character;
					}
					charCount=1;
					character=inputStringArray[j].charAt(0);
				}
			}
		}
		return mainCharacter+" "+maxCount;
	}
 }