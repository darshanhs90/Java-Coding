package geeksforgeeks;

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


/*
 * http://www.geeksforgeeks.org/amazon-interview-set-17/
 * Given a matrix, find whether you can form the given number
 */;
 public class _01AmazonInterview_17_02 {
	 public static void main(String[] args) {
		Scanner scanner=new Scanner(new InputStreamReader(System.in));
		 String inputNumber=scanner.nextLine();
		 int matrixSize=Integer.parseInt(scanner.nextLine());
		 scanner.close();
		 int [][]inputMatrix =new int[matrixSize][matrixSize];
		 inputMatrix=buildMatrix(inputMatrix);
		 printMatrix(inputMatrix);
		 System.out.println("Number Valid : "+checkNumber(inputMatrix,inputNumber));
	 }

	private static boolean checkNumber(int[][] inputMatrix, String inputNumber) {
		HashMap<Integer,Integer> numberMap=new HashMap<Integer, Integer>();
		HashMap<Integer,Integer> matrixMap=new HashMap<Integer, Integer>();
		for (int i = 0; i < inputNumber.length(); i++) {
			int element=inputNumber.charAt(i);
			if(!numberMap.containsKey(element)){
				numberMap.put(element,element);
			}
			else{
				numberMap.put(element,numberMap.get(element)+1);
			}
		}
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix.length; j++) {
				int element=inputMatrix[i][j];
				if(!matrixMap.containsKey(element)){
					matrixMap.put(element,element);
				}
				else{
					matrixMap.put(element,matrixMap.get(element)+1);
				}
			}
		}
		
		
		for (int i = 0; i < 9; i++) {
			if((matrixMap.get(i)==null && numberMap.get(i)==null)||(matrixMap.get(i)!=null && numberMap.get(i)==null)){
				continue;
			}
			else{
				if((matrixMap.get(i)==null && numberMap.get(i)!=null)){
					return false;
				}
				else if(matrixMap.get(i)>=numberMap.get(i))
					continue;
				else
					return false;
			}
		}
		return true;
		
		
	}

	private static void printMatrix(int[][] inputMatrix) {
		for (int i = 0; i < inputMatrix.length; i++) {
			System.out.println(Arrays.toString(inputMatrix[i]));
		}
		
	}

	private static int[][] buildMatrix(int[][] inputMatrix) {
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix.length; j++) {
				inputMatrix[i][j]=new Random().nextInt(10);
			}
		}
		return inputMatrix;
	}
 }