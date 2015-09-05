package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/*
 * http://www.geeksforgeeks.org/amazon-interview-set-24/
 * Reverse bits in a binary
 */;
 public class _01AmazonInterview_24_05 {
	 public static void main(String[] args) {
		 Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 Integer noOfRows=Integer.parseInt(scanner.nextLine());
		 Integer noOfColumns=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int inputArray[][]=buildInputArray(noOfRows,noOfColumns);
		 printArray(inputArray);
		 System.out.println(getRowUsingSum(inputArray));
		 System.out.println(getRowUsingMap(inputArray));
	 }

	 private static int getRowUsingMap(int[][] inputArray) {

		 ArrayList<Integer> initInputList=new ArrayList<Integer>();
		 ArrayList<Integer> finalInputList=new ArrayList<Integer>();
		 for (int i = 0; i < inputArray.length; i++) {
			 if(inputArray[i][0]==0){
				 initInputList.add(i);
			 }
		 }
		 int counter=1;
		 int latestRow=0;
		 while(!initInputList.isEmpty() &&counter!=inputArray[0].length-1){
			 if(inputArray[initInputList.get(0)][counter]==0)
			 {
				 finalInputList.add(initInputList.get(0));
				 latestRow=initInputList.get(0);
			 }

			 initInputList.remove(0);
			 if(initInputList.isEmpty())
			 {
				 initInputList=finalInputList;
				 if(finalInputList.size()>0){
					 finalInputList=new ArrayList<Integer>();
				 }
				 else{
					 return latestRow;
				 }
				 counter++;
			 }
		 }
		 return latestRow;
	 }

	 private static int getRowUsingSum(int[][] inputArray) {
		 int min=Integer.MAX_VALUE;
		 int index=-1;
		 for (int i = 0; i < inputArray.length; i++) {
			 int sum=0;
			 for (int j = 0; j < inputArray.length; j++) {
				 sum+=inputArray[i][j];
			 }
			 if(sum<min){
				 min=sum;
				 index=i;
			 }
		 }
		 return (index);
	 }

	 private static void printArray(int[][] inputArray) {
		 for (int i = 0; i < inputArray.length; i++) {
			 Arrays.sort(inputArray[i]);
			 System.out.println(Arrays.toString(inputArray[i]));
		 }

	 }

	 private static int[][] buildInputArray(Integer noOfRows, Integer noOfColumns) {
		 int inputArray[][]=new int[noOfRows][noOfColumns];
		 for (int i = 0; i < noOfRows; i++) {
			 for (int j = 0; j < noOfColumns; j++) {
				 inputArray[i][j]=new Random().nextInt(2);
			 }
		 }
		 return inputArray;
	 }





 }