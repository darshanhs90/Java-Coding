package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;





/*
 * http://www.geeksforgeeks.org/amazon-interview-set-16/
 * Given 2 sorted arrays of size m and n+m(with n elements) , merge
 * them into the latter..
 */;
 public class _01AmazonInterview_15_03 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 int m=Integer.parseInt(scanner.nextLine());
		 int n=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int []inputArrayM=new int[m];
		 int []inputArrayN=new int[n];
		 int []outputArray=new int[n+m];
		 inputArrayM=buildArray(inputArrayM);
		 System.out.println(Arrays.toString(inputArrayM));
		 inputArrayN=buildArray(inputArrayN);
		 System.out.println(Arrays.toString(inputArrayN));
		 outputArray=sortArrays(inputArrayM,inputArrayN);
		 System.out.println(Arrays.toString(outputArray));
	 }

	private static int[] sortArrays(int[] inputArrayM, int[] inputArrayN) {
		int mCounter=0,nCounter=0,mainCounter=0;
		int []outputArray=new int[inputArrayM.length+inputArrayN.length];
		while(mainCounter!=inputArrayM.length+inputArrayN.length){
			if(inputArrayM[mCounter]<inputArrayN[nCounter]){
				outputArray[mainCounter]=inputArrayM[mCounter];
				mCounter++;
				if(mCounter==inputArrayM.length)
					return fillOutput(outputArray,mainCounter+1,inputArrayN,nCounter);
			}else{
				outputArray[mainCounter]=inputArrayN[nCounter];
				nCounter++;
				if(nCounter==inputArrayN.length)
					return fillOutput(outputArray,mainCounter+1,inputArrayM,mCounter);
			}
			mainCounter++;
		}
		return outputArray;
	}

	private static int[] fillOutput(int[] outputArray,int mainCounter, int[] inputArray,
			int counter) {
		for (int i = counter; i < inputArray.length; i++) {
			outputArray[mainCounter]=inputArray[i];
			mainCounter++;
		}
		return outputArray;
	}

	private static int[] buildArray(int[] inputArray) {
		for (int i = 0; i < inputArray.length; i++) {
			inputArray[i]=new Random().nextInt(inputArray.length*3);
		}
		Arrays.sort(inputArray);
		return inputArray;
	}

	
 }