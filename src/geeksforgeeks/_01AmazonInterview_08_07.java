package geeksforgeeks;

import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;




/*
 * http://www.geeksforgeeks.org/amazon-interview-set-8/
 * Given an array of integers,populate another array with the product 
 * of the  elements of the first array except for the current index element
 */;
 public class _01AmazonInterview_08_07 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[]=new int[size];
		 int outputArray[]=new int[size];
		 for (int i = 0; i < size; i++) {
			 int elementValue=0;
			 while((elementValue=new Random().nextInt(size*3))==0){

			 }
			 inputArray[i]=elementValue;
		 }
		 productWithDivision(size, inputArray, outputArray);
		 productWithoutDivision(size, inputArray, outputArray);

	 }

	 private static void productWithoutDivision(int size, int[] inputArray,
			 int[] outputArray) {
		 int[] left=new int[size];
		 int[] right=new int[size];
		 left[0]=1;
		 right[size-1]=1;
		 for (int i = 1; i < left.length; i++) {
			 left[i]=inputArray[i-1]*left[i-1];
		 }
		 for (int i = right.length-2; i >=0; i--) {
			 right[i]=inputArray[i+1]*right[i+1];
		 }
		 for (int i = 0; i <outputArray.length; i++) {
			 outputArray[i]=left[i]*right[i];
		 }
		 for (int i = 0; i < size; i++) {
			 System.out.print(outputArray[i]+",");
		 }
		 System.out.println();
	 }

	 private static void productWithDivision(int size, int[] inputArray,
			 int[] outputArray) {
		 BigInteger sum=new BigInteger("1");
		 for (int i = 0; i < size; i++) {
			 sum=sum.multiply(new BigInteger(inputArray[i]+""));
			 System.out.print(inputArray[i]+",");
		 }
		 System.out.println();
		 for (int i = 0; i < outputArray.length; i++) {
			 outputArray[i]=(sum.intValue())/inputArray[i];
		 }
		 for (int i = 0; i < size; i++) {
			 System.out.print(outputArray[i]+",");
		 }
		 System.out.println();
	 }
 }