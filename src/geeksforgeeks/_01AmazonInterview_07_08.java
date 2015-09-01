package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-2/
 * Given an array, find three numbers a, b and c such that a^2 + b^2 = c^2
 * 
 */;
 public class _01AmazonInterview_07_08 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[]=new int[size];
		 for (int i = 0; i < size; i++) {
			 int x=0;
			 while((x=new Random().nextInt(3*size))==0){

			 }
			 inputArray[i]=x;
		 }

		 Arrays.sort(inputArray);
		 for (int i = 0; i < inputArray.length; i++) {
			 inputArray[i]=inputArray[i]*inputArray[i];
			 System.out.print(inputArray[i]+",");
		 }
		 System.out.println();
		 System.out.println(findTriplets(inputArray));


	 }

	 private static int findTriplets(int[] inputArray) {
		 for (int i = 0; i < inputArray.length-2; i++) {
			 int element=inputArray[i];
			 int first=i+1;
			 int last=inputArray.length-1;
			 while(first<last){
				 if(inputArray[first]+element-inputArray[last]==0){
					 System.out.println(inputArray[first]+" "+inputArray[last]+" "+inputArray[i]);
					 return 1;
				 }
				 else if((inputArray[first]+element-inputArray[last])>0){
					 first++;
				 }
				 else{
					 last--;
				 }
			 }
		 }
		 return 0;
	 }
 }