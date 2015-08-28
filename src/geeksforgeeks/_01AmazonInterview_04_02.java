package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-3/
 * An array of n integers is there in which the range of elements is n,
 * i.e., the difference between maximum and minimum number is n. Find the repeating numbers.
 * Was also asked to find number of times each number is repeated.
 */
public class _01AmazonInterview_04_02 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		int n=Integer.parseInt(scanner.nextLine());
		scanner.close();
		int inputArray[]=new int[n];
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=new Random().nextInt(n);
			System.out.print(inputArray[i]+" ");
		}
		System.out.println();
		HashMap<Integer,Integer> inputMap=new HashMap<Integer,Integer>();
		for (int i = 0; i < inputArray.length; i++) {
			int inputElement=inputArray[i];
			if(!inputMap.containsKey(inputElement)){
				inputMap.put(inputElement,1);
			}
			else{
				System.out.println(inputElement +" is repeated");
				inputMap.put(inputElement,inputMap.get(inputElement)+1);
			}
		}
		Object keys[]=inputMap.keySet().toArray();
		Object values[]=inputMap.values().toArray();
		for (int i = 0; i < values.length; i++) {
			if((int)values[i]!=1)
				System.out.println("Element "+keys[i]+" has appeared "+values[i]+" times");
		}
	}

}