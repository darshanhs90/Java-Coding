package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-2/
 * Median of two sorted arrays.
 * 
 */;
 public class _01AmazonInterview_07_05 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray1[]=new int[size];
		 int inputArray2[]=new int[size];

		 for (int i = 0; i < size; i++) {
			 inputArray1[i]=new Random().nextInt(3*size);
			 inputArray2[i]=new Random().nextInt(3*size);
		 }
		 Arrays.sort(inputArray1);
		 Arrays.sort(inputArray2);
		 for (int i = 0; i < size; i++) {
			 System.out.print(inputArray1[i]+",");
		 }
		 System.out.println();
		 for (int i = 0; i < size; i++) {
			 System.out.print(inputArray2[i]+",");
		 }
		 System.out.println();		 
		 int median=findMedian(inputArray1,inputArray2);
		 System.out.println("Median is : "+median);
	 }

	 private static int findMedian(int[] inputArray1, int[] inputArray2) {
		 int median1=inputArray1[inputArray1.length/2];
		 int median2=inputArray2[inputArray2.length/2];
		 if(inputArray1.length==2 && inputArray2.length==2){
			 return (Math.max(inputArray1[0],inputArray2[0])+Math.min(inputArray1[1],inputArray2[1]))/2;
		 }
		 if(median1==median2)
		 {
			 return median1;
		 }
		 else if(median1>median2){
			 return findMedian(Arrays.copyOfRange(inputArray1, 0, (inputArray1.length/2)+1),Arrays.copyOfRange(inputArray2, inputArray2.length/2,inputArray2.length));
		 }else{
			 return findMedian(Arrays.copyOfRange(inputArray1, inputArray2.length/2,inputArray2.length),Arrays.copyOfRange(inputArray2,0,(inputArray2.length/2)+1));
		 }
	 }
 }