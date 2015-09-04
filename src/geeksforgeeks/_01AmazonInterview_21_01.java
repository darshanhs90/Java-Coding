package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;



/*
 * http://www.geeksforgeeks.org/amazon-interview-set-21/
 * Find maximum frequent numbers in an array.
 * If there are more numbers with maximum frequency,
 * they display all numbers in ascending order.
 * Ascending order is important.
 */;
 public class _01AmazonInterview_21_01 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int[] inputArray=buildInputArray(size);
		 System.out.println(Arrays.toString(inputArray));
		 ArrayList<Integer> maxNumbers=findMaxNumbers(inputArray);
		 for (int i = 0; i < maxNumbers.size(); i++) {
			System.out.println(maxNumbers.get(i));
		}
	}

	private static ArrayList<Integer> findMaxNumbers(int[] inputArray) {
		ArrayList<Integer> maxNumbers=new ArrayList<Integer>();
		HashMap<Integer,Integer> elementsMap=new HashMap<Integer,Integer>();
		int max=0;
		for (int i = 0; i < inputArray.length; i++) {
			int element=inputArray[i];
			if(!elementsMap.containsKey(element)){
				elementsMap.put(element,1);
			}else{
				int value=elementsMap.get(element);
				elementsMap.put(element,value+1);
				if((value+1)>max){
					maxNumbers=new ArrayList<Integer>();
					maxNumbers.add(element);
					max=value+1;
				}
				else if((value+1)==max){
					maxNumbers.add(element);
				}
			}
		}
		
		return maxNumbers;
	}

	private static int[] buildInputArray(int size) {
		int[] inputArray=new int[size];
		for (int i = 0; i < size; i++) {
			inputArray[i]=new Random().nextInt(size*2);
		}
		return inputArray;
	}
	
	

 }