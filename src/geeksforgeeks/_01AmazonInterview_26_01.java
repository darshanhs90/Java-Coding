package geeksforgeeks;

import java.util.Arrays;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-26/
 * http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/
 * Given an array of integers which is initially increasing and then decreasing,
 * find the maximum value in the array.
 */;
 public class _01AmazonInterview_26_01 {
	 public static void main(String[] args) {
		 int input1[]={8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
		 int input2[]={1, 3, 50, 10, 9, 7, 6};
		 int input3[]={10, 20, 30, 40, 50};
		 int input4[]= {120, 100, 80, 20, 0};
		 System.out.println(Arrays.toString(input1));
		 System.out.println("Normal : "+findMAxElementNormal(input1));
		 System.out.println("Binary : "+findMAxElementBinary(input1));
		 System.out.println(Arrays.toString(input2));
		 System.out.println("Normal : "+findMAxElementNormal(input2));
		 System.out.println("Binary : "+findMAxElementBinary(input2));
		 System.out.println(Arrays.toString(input3));
		 System.out.println("Normal : "+findMAxElementNormal(input3));
		 System.out.println("Binary : "+findMAxElementBinary(input3));
		 System.out.println(Arrays.toString(input4));
		 System.out.println("Normal : "+findMAxElementNormal(input4));
		 System.out.println("Binary : "+findMAxElementBinary(input4));
	 }

	 private static int findMAxElementBinary(int[] input) {
		 // TODO Auto-generated method stub
		 int start=0,last=input.length-1; 
		 while(start<=last)
		 {
			 int mid=(start+last)/2;
			 if(mid-1>=0 && mid+1<=input.length-1)
			 {
				 if(input[mid]>input[mid-1] && input[mid]>input[mid+1])
					 return input[mid];
				 else if(input[mid]>input[mid-1] && input[mid]<input[mid+1])
					 start=mid+1;
				 else
					 last=mid-1;
			 }
			 else if(mid-1<0){
				 return input[start];
			 }
			 else if(mid+1>input.length-1){
				 return input[last];
			 }
		 }

		 return 0;
	 }

	 private static int findMAxElementNormal(int[] input) {
		 int max=input[0];
		 for (int i = 1; i < input.length; i++) {
			 if(input[i]>max)
				 max=input[i];
		 }
		 return max;
	 }
 }