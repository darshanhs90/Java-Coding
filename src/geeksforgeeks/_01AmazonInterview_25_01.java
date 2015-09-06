package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * http://www.geeksforgeeks.org/amazon-interview-set-25/
 * Given an integer array and an integer value X,
 * return two elements in that array such that sum of them equals to X.
 */;
 public class _01AmazonInterview_25_01 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 Integer size=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[]=buildInputArray(size);
		 System.out.println("element is :"+(size*2)/3);
		 System.out.println(findElementNormalMethod(inputArray,(int)(size*2)/3));
		 findElementMapMethod(inputArray,(int)(size*2)/3);
	 }
	 private static void findElementMapMethod(int[] inputArray, int element) {

		 int binaryMap[]=new int[inputArray.length*2+1];
		 Arrays.fill(binaryMap,0);
		 for (int i = 0; i < inputArray.length; i++) {
			 int difference=element-inputArray[i];
			 if(difference>=0&&binaryMap[difference]==1)
			 {
				 System.out.println(inputArray[i]+"//"+difference);
			 }
			 binaryMap[inputArray[i]]=1;
		 }
	 }
	 private static String findElementNormalMethod(int[] inputArray, int element) {
		 Arrays.sort(inputArray);
		 System.out.println(Arrays.toString(inputArray));

		 int left=0;
		 int right=inputArray.length-1;
		 while(left<right){
			 if(inputArray[left]+inputArray[right]>element)
				 right--;
			 else  if(inputArray[left]+inputArray[right]<element)
				 left++;
			 else
				 return inputArray[left]+"//"+inputArray[right];

		 }
		 return "-1";
	 }
	 private static int[] buildInputArray(Integer size) {
		 int inputArray[]=new int[size];
		 for (int i = 0; i < size; i++) {
			 inputArray[i]=new Random().nextInt(size*2);
		 }
		 return inputArray;
	 }
 }